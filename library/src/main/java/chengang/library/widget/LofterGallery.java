package chengang.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

import chengang.library.R;
import chengang.library.adapter.LofterPagerAdapter;

/**
 * 多图预览
 * <p>
 * Created by fengchengang on 2017/6/28.
 */

public class LofterGallery extends RelativeLayout {

    private Context mContext;

    private View mView;
    private LofterViewPager mLofterViewPager;

    private LofterPagerAdapter mLofterPagerAdapter;

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

        mLofterPagerAdapter = new LofterPagerAdapter(mContext, null);
        mLofterViewPager.setAdapter(mLofterPagerAdapter);
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
    }
}
