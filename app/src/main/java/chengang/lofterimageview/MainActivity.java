package chengang.lofterimageview;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chengang.library.widget.LofterImageView;

public class MainActivity extends AppCompatActivity implements ImageAdapter.OnImageClickListener {

    private static final String TAG = "MainActivity";
    public static final String IMAGE_URL = "http://imglf.nosdn.127.net/img/NWxuTTNsdXVnVk01WXY5VHZEcURXL1Z2ZWdXQm1VR3BoaStzY3hBMFU0aVB4YjB4QzMvOUxnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0";


    List<String> singleImage = new ArrayList<>(Arrays.asList(
            "http://imglf.nosdn.127.net/img/NWxuTTNsdXVnVk01WXY5VHZEcURXL1Z2ZWdXQm1VR3BoaStzY3hBMFU0aVB4YjB4QzMvOUxnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0"));

    List<String> mutiImages = new ArrayList<>(Arrays.asList(
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVlBIU2JiUXBjQzkySmNMdFhXWEtsNnRmVklEeGpBMElMSi9mYkVaNXpCQ0dBPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0",
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVlB0Y0YzdDBWMFZ0dnVlWnFSK3R0cHBuRnFXREc0WUlVU2ZHcGVZcEkydWZnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0"));

    List<List<String>> images = new ArrayList<>();

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        images.add(singleImage);
        images.add(mutiImages);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        ImageAdapter mAdapter = new ImageAdapter(images, this);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setOnImageClickListener(this);
    }

    @Override
    public void onImageClick(List<String> imageList, ImageView imageView) {
        if(imageList.size() > 1){
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "GALLERY_IMAGE");
            Intent intent = new Intent(this, GalleryActivity.class);
            intent.putExtra("GALLERY_IMAGE", imageList.toArray());
            intent.putStringArrayListExtra("GALLERY_IMAGE", (ArrayList<String>) imageList);
            ActivityCompat.startActivity(this, intent, options.toBundle());
        }else {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "EXTRA_IMAGE");
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("EXTRA_IMAGE", imageList.get(0));
            ActivityCompat.startActivity(this, intent, options.toBundle());
        }
    }

}