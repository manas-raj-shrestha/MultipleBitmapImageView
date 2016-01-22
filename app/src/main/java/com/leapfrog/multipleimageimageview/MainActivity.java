package com.leapfrog.multipleimageimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

//    MultipleImageView multipleImageView;
//    ArrayList<Integer> imageSourceIds = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Glide.with(this).load("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQOGb7RRV8iDy_VhowxhUtExK2ehR0_XXcmAG9PPtshl1QxDYRtEQ").into(imageView);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_test);
        recyclerView.setAdapter(new RecyclerViewAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        multipleImageView = (MultipleImageView) findViewById(R.id.multiple_image_view);
//
//        imageSourceIds.add(R.drawable.sample1);
//        imageSourceIds.add(R.drawable.sample2);
//        imageSourceIds.add(R.drawable.sample3);
//        imageSourceIds.add(R.drawable.sample4);
//        imageSourceIds.add(R.drawable.sample5);
//
//        multipleImageView.setImageSource(imageSourceIds);

    }

}
