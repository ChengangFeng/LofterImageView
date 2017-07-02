package chengang.lofterimageview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.Map;

/**
 * Image adapter
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<List<String>> datas = null;

    private Context mContext;

    private OnImageClickListener onImageClickListener;

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
                if(onImageClickListener != null){
                    onImageClickListener.onImageClick(datas.get(vh.getAdapterPosition()), vh.image);
                }
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.image.setAdjustViewBounds(true);
        String imageUrl = datas.get(position).get(0);
        if(imageUrl.endsWith("GIF") || imageUrl.endsWith("gif")){
            Glide.with(mContext).load(imageUrl).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(viewHolder.image);
        }else {
            Glide.with(mContext).load(imageUrl).into(viewHolder.image);
        }
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

    interface OnImageClickListener{
        void onImageClick(List<String> images,ImageView imageView);
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener){
        this.onImageClickListener = onImageClickListener;
    }
}
