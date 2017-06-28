package chengang.lofterimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chengang.library.widget.LofterGallery;

public class GalleryActivity extends AppCompatActivity {

    private LofterGallery mLofterGallery;

    List<String> images = new ArrayList<>(Arrays.asList(
            "http://imglf.nosdn.127.net/img/NWxuTTNsdXVnVk01WXY5VHZEcURXL1Z2ZWdXQm1VR3BoaStzY3hBMFU0aVB4YjB4QzMvOUxnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0",
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVlBIU2JiUXBjQzkySmNMdFhXWEtsNnRmVklEeGpBMElMSi9mYkVaNXpCQ0dBPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0",
            "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVlB0Y0YzdDBWMFZ0dnVlWnFSK3R0cHBuRnFXREc0WUlVU2ZHcGVZcEkydWZnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mLofterGallery = (LofterGallery) findViewById(R.id.lofter_Gallery);
        mLofterGallery.showGallery(images, 0);
    }

}
