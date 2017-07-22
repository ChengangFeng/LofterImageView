package chengang.lofterimageview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import chengang.lofterimageview.R;
import chengang.lofterimageview.utils.ScreenUtils;

/**
 * Image adapter
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<List<String>> datas = null;

    private Context mContext;

    private OnImageClickListener onImageClickListener;

    private int ANIMATED_ITEMS_COUNT = 3;
    private int lastAnimatedPosition = -1;

    public ImageAdapter(List<List<String>> datas, Context context) {
        this.datas = datas;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image, viewGroup, false);
        final ViewHolder vh = new ViewHolder(view);
        vh.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageClickListener != null) {
                    onImageClickListener.onImageClick(datas.get(vh.getAdapterPosition()), vh.image);
                }
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        runEnterAnimation(viewHolder.itemView, position);
        viewHolder.image.setAdjustViewBounds(true);
        String imageUrl = datas.get(position).get(0);
        Glide.with(mContext).load(imageUrl)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_image_error).
                into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }

    public interface OnImageClickListener {
        void onImageClick(List<String> images, ImageView imageView);
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    /**
     * item进入时候的动画
     */
    private void runEnterAnimation(View view, int position) {
        if (position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(ScreenUtils.getScreenHeight(mContext));//把item移出屏幕
            view.animate()
                    .translationY(0)
                    .setStartDelay(100 * position)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(800)
                    .start();
        }
    }
}
