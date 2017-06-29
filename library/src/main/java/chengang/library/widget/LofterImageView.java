package chengang.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import chengang.library.R;
import me.jessyan.progressmanager.ProgressListener;
import me.jessyan.progressmanager.ProgressManager;
import me.jessyan.progressmanager.body.ProgressInfo;
import uk.co.senab.photoview.PhotoView;

/**
 * 带进度条加载的imageView
 * Created by fengchengang on 2017/6/27.
 */

public class LofterImageView extends RelativeLayout {

    private static final String TAG = "LofterProgressView";
    private Context mContext;

    private View mView;
    //进度框
    private LofterProgressView mProgressView;
    //可伸缩的imageview
    private PhotoView mPhotoView;
    //加载失败的占位图
    private LinearLayout mErrorLayout;

    //加载图片的url
    private String mImageUrl;

    private long mContentLength = 0;

    public LofterImageView(Context context) {
        this(context, null);
    }

    public LofterImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LofterImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    /**
     * 初始化监听图片下载进度的监听器
     */
    private void initListener() {
        ProgressManager.getInstance().addResponseListener(mImageUrl, new ProgressListener() {
            @Override
            public void onProgress(ProgressInfo progressInfo) {
                int percent = progressInfo.getPercent();
                mProgressView.setPercent(percent);
                if (progressInfo.isFinish() || percent == 100) {
                    Log.d(TAG, "Glide --> finish");
                    mProgressView.startAnimation(getDefaultExitAnimation());
                }
            }

            @Override
            public void onError(long id, Exception e) {
                Log.d(TAG, "Glide --> error: " + e);
                mErrorLayout.setVisibility(VISIBLE);
            }
        });
    }

    private void initView() {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.lofter_progress_view, this, true);
        mProgressView = (LofterProgressView) mView.findViewById(R.id.pv);
        mPhotoView = (PhotoView) mView.findViewById(R.id.photo_view);
        mErrorLayout = (LinearLayout) mView.findViewById(R.id.layout_load_error);
    }

    /**
     * 加载图片
     *
     * @param imageUrl imageUrl
     */
    public void load(String imageUrl) {
        this.mImageUrl = imageUrl;
        initListener();

        mProgressView.setVisibility(VISIBLE);
        mErrorLayout.setVisibility(GONE);
        Glide.with(mContext)
                .load(mImageUrl)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.e(TAG, "load error:" + e);
                        mProgressView.setVisibility(GONE);
                        mErrorLayout.setVisibility(VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        if (isFromMemoryCache) {
                            mProgressView.setVisibility(GONE);
                        }
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .crossFade(500)
                .into(mPhotoView);

    }

    /**
     * 获取加载进度达到百分百后，进度条消失的动画
     *
     * @return
     */
    private Animation getDefaultExitAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        alphaAnimation.setStartOffset(600L);
        alphaAnimation.setDuration(400L);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG,"lofterProgressView exit animation start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG,"lofterProgressView gone");
                mProgressView.setVisibility(GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return alphaAnimation;
    }
}
