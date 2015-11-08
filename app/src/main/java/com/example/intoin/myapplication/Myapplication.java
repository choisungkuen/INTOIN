package com.example.intoin.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import com.example.intoin.myapplication.util.BasicInfoPreference;
import com.google.gson.Gson;
import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthType;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedByteArray;


/**
 * Created by choeseong-geun on 15. 10. 27..
 */
public class Myapplication extends Application {

    private static volatile Activity currentActivity = null;
    private static volatile Myapplication myapplication = null;
    private RestAdapter restAdapter;
    public String HOST = "host";
    BasicInfoPreference bp;

    @Override
    public void onCreate() {
        super.onCreate();

        myapplication = this;
        bp = new BasicInfoPreference(this);
        KakaoSDK.init(new KakaoSDKAdapter());


    }
    public static Myapplication getInstance() {
        return myapplication;
    }

    public String getServerHost() {
        return this.HOST;
    }


    public RestAdapter getRestAdapter() {
        String host = this.getServerHost();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(host)
                .setConverter(new GsonConverter(new Gson()))
                .setRequestInterceptor(requestInterceptor)
                .setClient(new GzippedClient(new OkClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();


        return restAdapter;
    }

    RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {

            String cookieString = bp.getValue("cookieString", null);

            if(cookieString != null) {
                request.addHeader("Cookie", cookieString);
            }
        }
    };
    public class GzippedClient implements Client {

        private Client wrappedClient;

        public GzippedClient(Client wrappedClient) {
            this.wrappedClient = wrappedClient;
        }

        @Override
        public Response execute(Request request) throws IOException {
            Response response = wrappedClient.execute(request);

            boolean gzipped = false;


            for (Header h : response.getHeaders()) {
                if (h.getName() != null && h.getName().toLowerCase().equals("set-cookie") && h.getValue() != null) {
                    Log.e("session",h.getValue());


                    String cookieString = h.getValue();
                    if(cookieString.contains("ASPXAUTH")){
                        bp.put("cookieString", cookieString);
                    }


                    CookieSyncManager.createInstance(getApplicationContext());
                    CookieManager.getInstance().removeAllCookie();
                    CookieManager cookieManager = CookieManager.getInstance();
                    CookieSyncManager.getInstance().startSync();

                    cookieManager.setCookie(Myapplication.getInstance().getServerHost(), cookieString);
                    CookieSyncManager.getInstance().sync();

                    try {
                        Thread.sleep(500);  //동기화 하는데 약간의 시간을 필요로 한다.
                    } catch (InterruptedException e) {   }
                }
            }


            for (Header h : response.getHeaders()) {
                if (h.getName() != null && h.getName().toLowerCase().equals("content-encoding") && h.getValue() != null && h.getValue().toLowerCase().equals("gzip")) {
                    gzipped = true;
                    break;
                }
            }

            Response r = null;
            if (gzipped) {
                InputStream is = null;
                ByteArrayOutputStream bos = null;

                try {
                    is = new BufferedInputStream(new GZIPInputStream(response.getBody().in()));
                    bos = new ByteArrayOutputStream();

                    int b;
                    while ((b = is.read()) != -1) {
                        bos.write(b);
                    }

                    TypedByteArray body = new TypedByteArray(response.getBody().mimeType(), bos.toByteArray());
                    r = new Response(response.getUrl(), response.getStatus(), response.getReason(), response.getHeaders(), body);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                }
            } else {
                r = response;
            }
            return r;
        }

    }



    private static class KakaoSDKAdapter extends KakaoAdapter {
        @Override
        public ISessionConfig getSessionConfig() {
            return new ISessionConfig() {
                @Override
                public AuthType[] getAuthTypes() {
                    return new AuthType[]{AuthType.KAKAO_LOGIN_ALL};
                }

                @Override
                public boolean isUsingWebviewTimer() {
                    return false;
                }

                @Override
                public ApprovalType getApprovalType() {
                    return ApprovalType.INDIVIDUAL;
                }

                @Override
                public boolean isSaveFormData() {
                    return true;
                }
            };
        }

        @Override
        public IApplicationConfig getApplicationConfig() {
            return new IApplicationConfig() {
                @Override
                public Activity getTopActivity() {
                    return myapplication.getCurrentActivity();
                }

                @Override
                public Context getApplicationContext() {
                    return myapplication.getGlobalApplicationContext();
                }
            };


        }
    }
    public static Activity getCurrentActivity(){
        return currentActivity;
    }
    public static Myapplication getGlobalApplicationContext() {
        if(myapplication == null)
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        return myapplication;
    }

    public static void setCurrentActivity(Activity currentActivity){
        Myapplication.currentActivity = currentActivity;
    }

    public static String getPackageHashKey(Context ctx) {
        try {
            PackageInfo info = ctx.getPackageManager().getPackageInfo("com.example.intoin.intoin", PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.DEFAULT);
            }
        } catch (PackageManager.NameNotFoundException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
