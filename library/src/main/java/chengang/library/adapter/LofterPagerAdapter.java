package chengang.library.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

import chengang.library.R;
import chengang.library.widget.LofterImageView;

/**
 * 多图预览采用PagerAdapter
 * <p>
 * Created by fengchengang on 2017/6/28.
 */

public class LofterPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> mImages;
    private SparseArray<View> cacheView;

    public LofterPagerAdapter(Context context, List<String> images) {
        this.mContext = context;
        if (images != null && images.size() > 0) {
            mImages = new ArrayList<>(images);
            cacheView = new SparseArray<>(images.size());
        } else {
            mImages = new ArrayList<>();
            cacheView = new SparseArray<>();
        }
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        LofterImageView image = new LofterImageView(container.getContext());
        image.load((mImages.get(position)));

        // Now just add PhotoView to ViewPager and return it
        container.addView(image, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return image;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    /**
     * 更新图片
     *
     * @param images images
     */
    public void updateImages(List<String> images) {
        if (images != null && images.size() > 0) {
            this.mImages.clear();
            this.mImages.addAll(images);
            notifyDataSetChanged();
        }
    }
}
