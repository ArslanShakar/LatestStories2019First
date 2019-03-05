package com.climesoft.client.lateststories2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {
    private Context context;
    private int[] imagesArray = new int[]{
            R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4,
            R.drawable.img_6, R.drawable.img_7, R.drawable.img_8, R.drawable.img_9,
            R.drawable.img_10, R.drawable.img_11, R.drawable.img_12
    };

    ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagesArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pager, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(imagesArray[position]);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}