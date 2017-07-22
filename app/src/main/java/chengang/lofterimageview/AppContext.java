package chengang.lofterimageview;


import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import me.jessyan.progressmanager.ProgressManager;
import okhttp3.OkHttpClient;

/**
 * Created by 陈岗不行陈 on 2017/7/8.
 * <p>
 * 获取全局应用
 */

public class AppContext extends Application {

    private static final String TAG = "AppContext";

    private static AppContext instance;

    private OkHttpClient mOkHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //初始化okhttp
        initUnsafeOkHttpClient();

        LeakCanary.install(this);
    }

    /**
     * 获取全局应用
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }

    /**
     * 设置okhttp绕过证书验证
     */
    private void initUnsafeOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        final X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            builder.sslSocketFactory(sslSocketFactory, trustManager)
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    });

            this.mOkHttpClient = ProgressManager.getInstance().with(builder)
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
            Log.e(TAG, "init unsafeOkHttp error" + e);
        }
    }


    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
