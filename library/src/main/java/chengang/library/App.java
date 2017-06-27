package chengang.library;

import android.app.Application;

import me.jessyan.progressmanager.ProgressManager;
import okhttp3.OkHttpClient;

/**
 * Created by fengchengang on 2017/6/27.
 */

public class App extends Application {

    private OkHttpClient mOkHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mOkHttpClient = ProgressManager.getInstance().with(new OkHttpClient.Builder())
                .build();
    }


    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
