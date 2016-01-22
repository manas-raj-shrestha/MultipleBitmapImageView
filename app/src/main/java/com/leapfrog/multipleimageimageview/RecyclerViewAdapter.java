package com.leapfrog.multipleimageimageview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Manas on 1/21/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RvViewHolder> {
    Context context;

    ArrayList<ArrayList<String>> imageSourceIds = new ArrayList<>();

    public void createImageArray() {
        ArrayList<String> imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/2022725-wallpaper_625864_Iz6NK8G.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/2022725-wallpaper_625864_Iz6NK8G.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/23-3d-beach-sand-wallpaper.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/bicycle-1280x720.jpg");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/79438-blue-world-map_nJEOoUQ.jpg");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/2013-ferrari-f12-n-largo-_600x0w.jpg");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/2014-ferrari-f12-berlinetta-front-three-quarters.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/6866.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/car-pictures.cars.com.png");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/6736.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/Autumn-Garden-HD-Wallpaper1.jpg");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/2012-lexus-lfa_100366586_l.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/2015-lexus-rc-f-gt3-racing-003-1.jpg");

        imgArray.add("http://www.planwallpaper.com/static/images/2013-lexus-is-trd-01.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/01-2011-lexus-lfa-review.jpg");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/lineup.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/2015-lexus-rc-f-gt3-racing-003-1.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/LaFerrari007.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/ferrari-9.jpg");

        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/high-definition-wallpaper-3-798x350.jpg");

        imgArray.add("http://www.planwallpaper.com/static/images/1907906.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/b807c2282ab0a491bd5c5c1051c6d312_rP0kQjJ.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/6768666-1080p-wallpapers.jpg");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.androidguys.com/wp-content/uploads/2015/10/211.jpg");

        imgArray.add("http://www.planwallpaper.com/static/images/xperia_z_ultra-wallpaper-1366x768.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/Autumn-Garden-HD-Wallpaper1.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/a601cb579cc9a289bc51cd41d8bcf478_large.jpg");
        imageSourceIds.add(imgArray);

        imgArray = new ArrayList<>();
        imgArray.add("http://www.planwallpaper.com/static/images/f12-berlinetta-thumb.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/lamborghini_murcielago_superveloce_2-2880x1800.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/city_of_love-wallpaper-1366x768.jpg");
        imgArray.add("http://www.planwallpaper.com/static/images/city_of_love-wallpaper-1366x768.jpg");
        imageSourceIds.add(imgArray);

    }

    public RecyclerViewAdapter(Context context) {
        this.context = context;

        createImageArray();


    }

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RvViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false));
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position) {
        Log.e("----", " - " + position);
        holder.multipleImageView.setImageIdSources(imageSourceIds.get(position));
    }

    @Override
    public int getItemCount() {
        return imageSourceIds.size();
    }

    public class RvViewHolder extends RecyclerView.ViewHolder {

        MultipleImageViewGroup multipleImageView;

        public RvViewHolder(View itemView) {
            super(itemView);

            multipleImageView = (MultipleImageViewGroup) itemView.findViewById(R.id.multiple_image_view);
        }
    }


}
