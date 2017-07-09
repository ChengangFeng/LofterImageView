package chengang.library.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

import chengang.library.widget.LofterImageView;


/**
 * Created by 陈岗不行陈 on 2017/6/28.
 * <p>
 * 多图预览PagerAdapter
 */
public class LofterPagerAdapter extends PagerAdapter {

    private static final String TAG = "LofterPagerAdapter";
    private Context mContext;
    private List<String> mImages;

    private static ArrayList<LofterImageView> mPhotoViewPool;
    private static final int mPhotoViewPoolSize = 9;


    public LofterPagerAdapter(Context context, List<String> images) {
        this.mContext = context;
        if (images != null && images.size() > 0) {
            mImages = new ArrayList<>(images);
        } else {
            mImages = new ArrayList<>();
        }

        mPhotoViewPool = new ArrayList<>();
        buildMLofterImageViewPool();
    }

    private void buildMLofterImageViewPool() {
        for (int i = 0; i < mPhotoViewPoolSize; i++) {
            LofterImageView mLofterImageView = new LofterImageView(mContext);
            mLofterImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mPhotoViewPool.add(mLofterImageView);
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
        LofterImageView image = mPhotoViewPool.get(position);
        if (image == null) {
            image = new LofterImageView(mContext);
            image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

        }
        image.getPhotoView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick((PhotoView) v);
                }
            }
        });
        image.load((mImages.get(position)));
        container.addView(image);
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

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(PhotoView imageView);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void destroy() {
        for (LofterImageView lofterImageView : mPhotoViewPool) {
            lofterImageView.destroy();
        }
        mPhotoViewPool.clear();
        mPhotoViewPool = null;
    }

}
