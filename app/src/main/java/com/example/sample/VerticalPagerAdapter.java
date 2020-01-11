package com.example.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class VerticalPagerAdapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public VerticalPagerAdapter(List<Model> models, Context context) {
        mContext = context;
        this.models = models;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((FrameLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.fragment_my, container, false);
        TextView title1 = (TextView) itemView.findViewById(R.id.title);
        TextView desc1 = (TextView) itemView.findViewById(R.id.desc);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);

        imageView.setImageResource(models.get(position).getImage());
        title1.setText(models.get(position).getTitle());
        desc1.setText(models.get(position).getDesc());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }
}
