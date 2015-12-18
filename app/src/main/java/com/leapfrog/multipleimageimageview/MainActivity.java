package com.leapfrog.multipleimageimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MultipleImageView multipleImageView;
    ArrayList<Integer> imageSourceIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multipleImageView = (MultipleImageView) findViewById(R.id.multiple_image_view);

        imageSourceIds.add(R.drawable.sample1);
        imageSourceIds.add(R.drawable.sample2);
        imageSourceIds.add(R.drawable.sample3);
        imageSourceIds.add(R.drawable.sample4);
        imageSourceIds.add(R.drawable.sample5);

        multipleImageView.setImageSource(imageSourceIds);

    }

}
