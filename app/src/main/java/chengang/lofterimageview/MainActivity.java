package chengang.lofterimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import chengang.library.widget.LofterImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    public static final String IMAGE_URL = "http://imglf1.nosdn.127.net/img/NWxuTTNsdXVnVlBIU2JiUXBjQzkySmNMdFhXWEtsNnRmVklEeGpBMElMSi9mYkVaNXpCQ0dBPT0.jpg?imageView&thumbnail=2000y1333&type=jpg&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6ZmI5bKX5LiN5aeT6ZmIIC8gY2hhbmtvbmcubG9mdGVyLmNvbQ==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0";

    Button btn;

    LofterImageView mLofterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public void onClick(View v) {
        mLofterImageView.load(IMAGE_URL);
    }


    private void initView() {
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        mLofterImageView = (LofterImageView) findViewById(R.id.lofter_image_view);
        btn.setOnClickListener(this);
    }
}
