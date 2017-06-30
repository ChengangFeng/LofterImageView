package chengang.lofterimageview;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chengang.library.widget.LofterGallery;

public class GalleryActivity extends AppCompatActivity {

    private LofterGallery mLofterGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mLofterGallery = (LofterGallery) findViewById(R.id.lofter_Gallery);


        ArrayList<String> gallery_image = getIntent().getStringArrayListExtra("GALLERY_IMAGE");

        mLofterGallery.showGallery(gallery_image, 0);
    }

}
