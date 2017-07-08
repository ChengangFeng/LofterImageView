package chengang.lofterimageview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import com.github.chrisbanes.photoview.PhotoView;

import chengang.library.widget.LofterImageView;

public class DetailActivity extends AppCompatActivity{

    LofterImageView lofterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
      lofterImageView = (LofterImageView)findViewById(R.id.image_detail);
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
        },200);
        super.onBackPressed();
    }

}
