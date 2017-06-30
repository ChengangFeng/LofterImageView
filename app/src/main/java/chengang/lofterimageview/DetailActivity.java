package chengang.lofterimageview;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import chengang.library.widget.LofterImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        LofterImageView lofterImageView = (LofterImageView)findViewById(R.id.image_detail);
        String image_url = getIntent().getStringExtra("EXTRA_IMAGE");
        ViewCompat.setTransitionName(lofterImageView.getPhotoView(), "EXTRA_IMAGE");
        lofterImageView.load(image_url);
    }
}
