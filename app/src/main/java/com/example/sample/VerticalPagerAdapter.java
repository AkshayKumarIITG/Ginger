package com.example.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VerticalPagerAdapter extends PagerAdapter {

    private List<Movie> movieList;
    private LayoutInflater inflater;
    private Context context;

    public VerticalPagerAdapter(List<Movie> movieList, ValueEventListener valueEventListener){

    }

    public VerticalPagerAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((FrameLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View itemView = inflater.inflate(R.layout.fragment_my, container, false);
        TextView title1 = (TextView) itemView.findViewById(R.id.title);
        TextView desc1 = (TextView) itemView.findViewById(R.id.desc);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);



        Picasso.get().load(movieList.get(position).getImage()).into(imageView);
        title1.setText(movieList.get(position).getName());
        desc1.setText(movieList.get(position).getDescription());


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }
}
