package com.leapfrog.multipleimageimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Manas on 1/21/2016.
 */
public class MultipleImageViewGroup extends RelativeLayout {

    RectF rectF = new RectF();
    int width, height;
    ArrayList<String> imageIdSources = new ArrayList<>();
    ImageView imageView;
    RelativeLayout.LayoutParams ivParams;

    public MultipleImageViewGroup(Context context) {
        this(context, null, 0);
    }

    public MultipleImageViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleImageViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        int[] attrsArray = new int[]{
                android.R.attr.layout_width,
                android.R.attr.layout_height
        };

        TypedArray ta = context.obtainStyledAttributes(attrs, attrsArray);
        width = ta.getDimensionPixelSize(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        height = ta.getDimensionPixelSize(1, ViewGroup.LayoutParams.WRAP_CONTENT);
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * Create and add image views to view group
     */
    private void initViews() {
        if (imageIdSources.size() == 1) {
            imageView = new ImageView(getContext());
            rectF.set(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
            ivParams = new RelativeLayout.LayoutParams(width, height);
            Glide.with(getContext()).load(imageIdSources.get(0)).centerCrop().into(imageView);
            imageView.setLayoutParams(ivParams);
            imageView.setId(1);

            this.addView(imageView);
        } else if (imageIdSources.size() == 2) {
            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height);
            Glide.with(getContext()).load(imageIdSources.get(0)).centerCrop().into(imageView);
            imageView.setLayoutParams(ivParams);
            imageView.setId(1);
            this.addView(imageView);

            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height);
            Glide.with(getContext()).load(imageIdSources.get(1)).centerCrop().into(imageView);
            ivParams.addRule(RIGHT_OF, 1);
            imageView.setLayoutParams(ivParams);
            imageView.setId(2);
            this.addView(imageView);
        } else if (imageIdSources.size() == 3) {
            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height);
            Glide.with(getContext()).load(imageIdSources.get(0)).centerCrop().into(imageView);
            imageView.setLayoutParams(ivParams);
            imageView.setId(1);
            this.addView(imageView);

            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height / 2);
            Glide.with(getContext()).load(imageIdSources.get(1)).centerCrop().into(imageView);
            ivParams.addRule(RIGHT_OF, 1);
            imageView.setLayoutParams(ivParams);
            imageView.setId(2);
            this.addView(imageView);

            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height / 2);
            Glide.with(getContext()).load(imageIdSources.get(2)).centerCrop().into(imageView);
            ivParams.addRule(RIGHT_OF, 1);
            ivParams.addRule(BELOW, 2);
            imageView.setLayoutParams(ivParams);
            imageView.setId(3);
            this.addView(imageView);
        } else {
            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height / 2);
            Glide.with(getContext()).load(imageIdSources.get(0)).centerCrop().into(imageView);
            imageView.setLayoutParams(ivParams);
            imageView.setId(1);
            this.addView(imageView);

            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height / 2);
            Glide.with(getContext()).load(imageIdSources.get(1)).centerCrop().into(imageView);
            ivParams.addRule(RIGHT_OF, 1);
            imageView.setLayoutParams(ivParams);
            imageView.setId(2);
            this.addView(imageView);

            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height / 2);
            Glide.with(getContext()).load(imageIdSources.get(2)).centerCrop().into(imageView);
            ivParams.addRule(BELOW, 1);
            imageView.setLayoutParams(ivParams);
            imageView.setId(3);
            this.addView(imageView);

            imageView = new ImageView(getContext());
            ivParams = new RelativeLayout.LayoutParams(width / 2, height / 2);
            Glide.with(getContext()).load(imageIdSources.get(3)).centerCrop().into(imageView);
            ivParams.addRule(BELOW, 2);
            ivParams.addRule(RIGHT_OF, 1);
            imageView.setLayoutParams(ivParams);
            imageView.setId(4);
            this.addView(imageView);
        }

    }

    /**
     * Method to set image url sources
     *
     * @param imageIdSources {@link ArrayList<String>} list of image urls
     */
    public void setImageIdSources(ArrayList<String> imageIdSources) {
        this.imageIdSources = imageIdSources;

        initViews();
    }


}
