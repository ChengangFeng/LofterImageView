package chengang.library.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import chengang.library.R;
import chengang.library.adapter.LofterPagerAdapter;

/**
 * 多图预览
 * <p>
 * Created by fengchengang on 2017/6/28.
 */

public class LofterGallery extends RelativeLayout implements ViewPager.OnPageChangeListener {

    private Context mContext;

    private View mView;
    private LofterViewPager mLofterViewPager;
    //indicator小圆点
    private LinearLayout indicator;

    private LofterPagerAdapter mLofterPagerAdapter;

    //save indicators
    private List<ImageView> mIndicators = new ArrayList<>();

    public LofterGallery(Context context) {
        this(context, null);
    }

    public LofterGallery(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LofterGallery(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;

        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(mContext).inflate(R.layout.lofter_gallery, this, true);
        mLofterViewPager = (LofterViewPager) mView.findViewById(R.id.lofter_viewpager);
        indicator = (LinearLayout) mView.findViewById(R.id.indicator);
        mLofterPagerAdapter = new LofterPagerAdapter(mContext, null);
        mLofterViewPager.setAdapter(mLofterPagerAdapter);
        mLofterViewPager.addOnPageChangeListener(this);
    }

    /**
     * show images
     *
     * @param images imagesList
     * @param index  下标
     */
    public void showGallery(List<String> images, int index) {
        mLofterPagerAdapter.updateImages(images);
        mLofterViewPager.setCurrentItem(index);
        mLofterViewPager.setOffscreenPageLimit(images.size());
        //add indicator
        initIndicator(images, index);
    }

    /**
     * 初始化indicator
     */
    private void initIndicator(List<String> images, int index) {
        //dip 转换成px
        float scale = getResources().getDisplayMetrics().density;
        int size = (int) (8 * scale);
        LinearLayout.LayoutParams params;
        for (int i = 0; i < images.size(); i++) {
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i != (images.size() - 1)) params.rightMargin = size;
            ImageView point = new ImageView(getContext());
            if (index == i) {
                point.setImageResource(R.drawable.image_indicator_selected);
            } else {
                point.setImageResource(R.drawable.image_indicator_unselected);
            }
            mIndicators.add(point);
            indicator.addView(point, params);
        }
    }

    /**
     * 重新设置小圆点指示器
     *
     * @param position 下标
     */
    private void reloadIndicator(int position) {
        if (mIndicators.size() > 0) {
            for (int i = 0; i < mIndicators.size(); i++) {
                if (i == position) {
                    mIndicators.get(i).setImageResource(R.drawable.image_indicator_selected);
                } else {
                    mIndicators.get(i).setImageResource(R.drawable.image_indicator_unselected);
                }
            }
        }
    }

    /*-------------------滑动相关-------------------*/

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //改变页面的时候，改写指示器
        reloadIndicator(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
