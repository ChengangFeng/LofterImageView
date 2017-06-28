package chengang.library.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * viewpager
 * <p>
 * 解决跟PhotoView配合使用，快速缩放会报
 * Java.lang.IllegalArgumentException:pointerIndex out of range异常的问题
 * <p>
 * Created by fengchengang on 2017/6/28.
 */

public class LofterViewPager extends ViewPager{

    public LofterViewPager(Context context) {
        super(context);
    }

    public LofterViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
