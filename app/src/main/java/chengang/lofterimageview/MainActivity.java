package chengang.lofterimageview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import chengang.library.widget.LofterImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    public static final String IMAGE_URL = "https://neweop.conow.cn:9099/appendix/M00/00/72/ClhJo1lTGt-AD6nMAAByeBmVWoM702.png";

    Button btn;
    Button btnGallery;

    LofterImageView mLofterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                mLofterImageView.load(IMAGE_URL);
                break;
            case R.id.btn_gallery:
                Intent intent = new Intent(this, GalleryActivity.class);
                startActivity(intent);
                break;
        }

    }


    private void initView() {
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btnGallery = (Button) findViewById(R.id.btn_gallery);
        mLofterImageView = (LofterImageView) findViewById(R.id.lofter_image_view);
        btn.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
    }
}
