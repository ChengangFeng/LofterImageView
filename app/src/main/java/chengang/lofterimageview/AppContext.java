package chengang.lofterimageview;


import com.squareup.leakcanary.LeakCanary;

import chengang.library.BaseApplication;

/**
 * Created by 陈岗不行陈 on 2017/7/8.
 * <p>
 * 获取全局应用
 */

public class AppContext extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
