package com.leapfrog.multipleimageimageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Manas on 12/18/2015.
 */
public class MultipleImageView extends ImageView {
    ArrayList<Integer> imageSourceIds = new ArrayList<>();
    Paint paint = new Paint();
    RectF rectF = new RectF();
    Bitmap bitmap;

    public MultipleImageView(Context context) {
        this(context, null, 0);
    }

    public MultipleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageSource(ArrayList<Integer> imageSourceIds) {
        this.imageSourceIds = imageSourceIds;
        Log.e("---", "setting img src " + this.getHeight() + " width " + this.getWidth());
        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        paint.setColor(Color.GREEN);
        if (imageSourceIds.size() == 1) {
            rectF.set(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
            bitmap = decodeSampledBitmapFromResource(getResources(), imageSourceIds.get(0), 25, 25);
//            bitmap = BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0));
            canvas.drawBitmap(bitmap, null, rectF, paint);
            bitmap.recycle();
        } else if (imageSourceIds.size() == 2) {
            rectF.set(this.getLeft(), this.getTop(), this.getRight() / 2, this.getBottom());
            bitmap = decodeSampledBitmapFromResource(getResources(),imageSourceIds.get(0),25,25);
//            bitmap = BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0));
            canvas.drawBitmap(bitmap, null, rectF, paint);
            bitmap.recycle();

            rectF.set(this.getRight() / 2, this.getTop(), this.getRight(), this.getBottom());
            bitmap = decodeSampledBitmapFromResource(getResources(),imageSourceIds.get(1),25,25);
//            bitmap = BitmapFactory.decodeResource(getResources(), imageSourceIds.get(1));
            canvas.drawBitmap(bitmap, null, rectF, paint);
            bitmap.recycle();
        } else if (imageSourceIds.size() == 3) {
            bitmap = decodeSampledBitmapFromResource(getResources(),imageSourceIds.get(0),25,25);
//            bitmap = BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0));
            rectF.set(this.getLeft(), this.getTop(), this.getRight() / 2, this.getBottom());
            canvas.drawBitmap(bitmap, null, rectF, paint);
            bitmap.recycle();

            rectF.set(getRight() / 2, getTop(), getRight(), getBottom() / 2);
            bitmap = decodeSampledBitmapFromResource(getResources(),imageSourceIds.get(1),25,25);
//            bitmap = BitmapFactory.decodeResource(getResources(), imageSourceIds.get(1));
            canvas.drawBitmap(bitmap, null, rectF, paint);
            bitmap.recycle();

            bitmap = decodeSampledBitmapFromResource(getResources(),imageSourceIds.get(2),25,25);
//            bitmap = BitmapFactory.decodeResource(getResources(), imageSourceIds.get(2));
            rectF.set(getRight() / 2, getBottom() / 2, getRight(), getBottom());
            canvas.drawBitmap(bitmap, null, rectF, paint);
            bitmap.recycle();
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
            rectF.set(getLeft(), getTop(), getRight() / 2, getBottom() / 2);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(0)), null, rectF, paint);

            rectF.set(getRight() / 2, getTop(), getRight(), getBottom() / 2);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(1)), null, rectF, paint);

            rectF.set(getLeft(), getBottom() / 2, getRight() / 3, getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(2)), null, rectF, paint);

            rectF.set(getRight() / 3, getBottom() / 2, (getRight() * 2) / 3, getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(3)), null, rectF, paint);

            rectF.set((getRight() * 2) / 3, getBottom() / 2, getRight(), getBottom());
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), imageSourceIds.get(4)), null, rectF, paint);
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
