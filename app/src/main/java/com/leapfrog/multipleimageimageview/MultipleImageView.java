package com.leapfrog.multipleimageimageview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Manas on 12/18/2015.
 */
public class MultipleImageView extends ImageView {
    ArrayList<Integer> imageSourceIds = new ArrayList<>();
    Paint paint = new Paint();
    RectF rectF = new RectF();

    public MultipleImageView(Context context) {
        super(context);
    }

    public MultipleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultipleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageSource(ArrayList<Integer> imageSourceIds) {
        this.imageSourceIds = imageSourceIds;
        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        paint.setColor(Color.GREEN);
        if (imageSourceIds.size() == 1) {
            rectF.set(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0)), null, rectF, paint);
        } else if (imageSourceIds.size() == 2) {
            rectF.set(this.getLeft(), this.getTop(), this.getRight() / 2, this.getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0)), null, rectF, paint);

            rectF.set(this.getRight() / 2, this.getTop(), this.getRight(), this.getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(1)), null, rectF, paint);
        } else if (imageSourceIds.size() == 3) {
            rectF.set(this.getLeft(), this.getTop(), this.getRight() / 2, this.getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0)), null, rectF, paint);

            rectF.set(getRight() / 2, getTop(), getRight(), getBottom() / 2);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(1)), null, rectF, paint);

            rectF.set(getRight() / 2, getBottom() / 2, getRight(), getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(2)), null, rectF, paint);
        } else if (imageSourceIds.size() == 4) {
            rectF.set(this.getLeft(), this.getTop(), this.getRight() / 2, this.getBottom() / 2);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0)), null, rectF, paint);

            rectF.set(this.getLeft(), this.getBottom() / 2, this.getRight() / 2, this.getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(1)), null, rectF, paint);

            rectF.set(this.getRight() / 2, this.getTop(), this.getRight(), this.getBottom() / 2);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(2)), null, rectF, paint);

            rectF.set(this.getRight() / 2, this.getBottom() / 2, this.getRight(), this.getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(3)), null, rectF, paint);
        } else {
            rectF.set(getLeft(),getTop(),getRight()/2,getBottom()/2);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0)), null, rectF, paint);

            rectF.set(getRight() / 2, getTop(), getRight(), getBottom() / 2);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(1)), null, rectF, paint);

            rectF.set(getLeft(), getBottom()/2, getRight()/3, getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(2)), null, rectF, paint);

            rectF.set(getRight()/3, getBottom() / 2, (getRight()*2)/3, getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(3)), null, rectF, paint);

            rectF.set((getRight()*2)/3, getBottom() / 2, getRight(), getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(4)), null, rectF, paint);
        }
    }
}
