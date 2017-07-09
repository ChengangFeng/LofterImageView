package chengang.lofterimageview.ui;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;

import chengang.library.widget.LofterImageView;
import chengang.lofterimageview.R;

/**
 * Created by 陈岗不行陈 on 2017/6/30.
 * <p>
 * 图片详情Activity
 */
public class DetailActivity extends AppCompatActivity {

    LofterImageView lofterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        lofterImageView = (LofterImageView) findViewById(R.id.image_detail);
        String image_url = getIntent().getStringExtra("GALLERY_IMAGE");
        PhotoView mPhotoView = lofterImageView.getPhotoView();
        ViewCompat.setTransitionName(lofterImageView, "GALLERY_IMAGE");
        mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        lofterImageView.load(image_url);
    }

    @Override
    public void onBackPressed() {
        lofterImageView.removeBg();
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                DetailActivity.super.onBackPressed();
            }
        }, 200);
        super.onBackPressed();
    }

}
