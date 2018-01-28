package com.hosamazzam.apps.shoply.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hosamazzam.apps.shoply.Adapters.Slider_Pager_Adapter;
import com.hosamazzam.apps.shoply.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Hosam Azzam on 28/01/2018.
 */

public class HomeFragment extends Fragment {

    Slider_Pager_Adapter sliderPagerAdapter;
    ArrayList<Integer> slider_image_list = new ArrayList<>();
    int page_position = 0;
    Timer timer;
    private ViewPager images_slider;
    private LinearLayout pages_dots;
    private TextView[] dots;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_home, container, false);

        images_slider = rootview.findViewById(R.id.image_page_slider);
        pages_dots = rootview.findViewById(R.id.image_page_dots);

        timer = new Timer();
        initSlider();
        scheduleSlider();


        return rootview;
    }

    public void initSlider() {
        addBottomDots(0);

        slider_image_list = new ArrayList<>();

        //Add few items to slider_image_list ,this should contain url of images which should be displayed in slider
        // here i am adding few sample image links from drawable, we will replace it later

        slider_image_list.add(R.drawable.slider1);
        slider_image_list.add(R.drawable.slider2);
        slider_image_list.add(R.drawable.slider3);
        slider_image_list.add(R.drawable.slider4);

        sliderPagerAdapter = new Slider_Pager_Adapter(getActivity(), slider_image_list);
        images_slider.setAdapter(sliderPagerAdapter);
        images_slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void scheduleSlider() {

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                images_slider.setCurrentItem(page_position, true);
            }
        };

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 500, 4000);
    }

    public void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        pages_dots.removeAllViews();
        pages_dots.setPadding(0, 0, 0, 20);
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#9f9f9f")); // un selected
            pages_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#2f383a")); // selected
    }

    @Override
    public void onPause() {
        timer.cancel();
        super.onPause();
    }
}
