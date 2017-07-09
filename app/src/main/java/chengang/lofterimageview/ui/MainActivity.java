package chengang.lofterimageview.ui;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import chengang.lofterimageview.adapter.ImageAdapter;
import chengang.lofterimageview.R;
/**
 * Created by 陈岗不行陈 on 2017/6/27.
 * <p>
 * 主页面
 */
public class MainActivity extends AppCompatActivity implements ImageAdapter.OnImageClickListener {

    private static final String TAG = "MainActivity";
    public static final String IMAGE_URL = "http://imglf.nosdn.127.net/img/NWxuTTNsdXVnVk01WXY5VHZEcURXL1Z2ZWdXQm1VR3BoaStzY3hBMFU0aVB4YjB4QzMvOUxnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0";


    List<String> singleImage = new ArrayList<>(Collections.singletonList(
            "http://imglf.nosdn.127.net/img/NWxuTTNsdXVnVk01WXY5VHZEcURXL1Z2ZWdXQm1VR3BoaStzY3hBMFU0aVB4YjB4QzMvOUxnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0"));

    List<String> singleImage2 = new ArrayList<>(Collections.singletonList(
            "http://imglf.nosdn.127.net/img/NWxuTTNsdXVnVlBjL1h6M0RCbDlhZFBTd3NWZ0xteVJzaktYK0tkRElLRUhabkFLSkd2YktnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0"));

    List<String> singleImage3 = new ArrayList<>(Collections.singletonList(
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVk1MSGpteGRzQ0VnQlMzTy9sOUNYang4aUJlS0JHZkE3WWFrWEY1VFI3dDNnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0"));


    List<String> singleImage4 = new ArrayList<>(Collections.singletonList(
            "http://imglf2.nosdn.127.net/img/NWxuTTNsdXVnVk1tS0h3Q3FiKzN3NWhIc05Qc2hLYktrb0RaZnhjQnBGM0VnUFJuQzFrNDVRPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0"));

    List<String> gitImage = new ArrayList<>(Collections.singletonList(
            "http://storage.slide.news.sina.com.cn/slidenews/77_ori/2017_26/74766_782959_356164.gif"));

    List<String> mutiImages = new ArrayList<>(Arrays.asList(
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVlBIU2JiUXBjQzkySmNMdFhXWEtsNnRmVklEeGpBMElMSi9mYkVaNXpCQ0dBPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0",
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVlB0Y0YzdDBWMFZ0dnVlWnFSK3R0cHBuRnFXREc0WUlVU2ZHcGVZcEkydWZnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0",
            "http://imglf2.nosdn.127.net/img/NWxuTTNsdXVnVk1vb3dudkVROGNHVkdHekFsU3VUODlSdDVDWXlhQkxGVWt0bzV2UFk1TE5RPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0",
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVk1aS2xlTlZQblQ3KzZ0eDlmTTlob3UyakJxdFByeU1MUmgvZEJzc0gvMFJBPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0",
            "http://imglf2.nosdn.127.net/img/NWxuTTNsdXVnVk04MzE2YkRlVFovcjJxeWlRQVNmN2w3K2FOMUh0M2hCd21PbmxtRkxIV3R3PT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=340&dx=16&dy=20&stripmeta=0",
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVk53ejBoYVJWWXkxSUdYZEErUU5rOURTU2hZcmEvQlFhR0luenVNNjJlRkNRPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=340&dx=16&dy=20&stripmeta=0",
            "http://imglf0.ph.126.net/9QxriHiQRIN7kyZsCOnQZQ==/671880769426312011.jpg"));

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
        images.add(singleImage2);
        images.add(singleImage3);
        images.add(singleImage4);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        ImageAdapter mAdapter = new ImageAdapter(images, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnImageClickListener(this);
    }

    @Override
    public void onImageClick(List<String> imageList, ImageView imageView) {
        if(imageList.size() > 1){
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "GALLERY_IMAGE");
            Intent intent = new Intent(this, GalleryActivity.class);
            intent.putStringArrayListExtra("GALLERY_IMAGE", (ArrayList<String>) imageList);
            ActivityCompat.startActivity(this, intent, options.toBundle());
        }else {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "GALLERY_IMAGE");
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("GALLERY_IMAGE", imageList.get(0));
            ActivityCompat.startActivity(this, intent, options.toBundle());
        }
    }

}