package chengang.lofterimageview;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import chengang.library.BaseApplication;

/**
 * Created by urcha on 2017/7/8.
 */

public class AppContext extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
