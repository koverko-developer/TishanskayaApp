package com.example.mobiapp.tishanskayaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.mobiapp.tishanskayaapp.fragments.AboutFragment;
import com.example.mobiapp.tishanskayaapp.fragments.CoursesFragment;
import com.example.mobiapp.tishanskayaapp.fragments.DiseaseListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {

    private static final String APP_PREFERENCES = "config";
    private static final String APP_PREFERENCES_FIRST = "first";
    private SharedPreferences mSettings;

    private TextView mTextMessage, textToolbar;
    private SliderLayout mDemoSlider;
    FrameLayout frameLayout;
    private Animation mFadeInAnimation, mFadeOutAnimation;
    RelativeLayout relPreView, relNext, relIndicatorSlider, relToolbar;
    BottomNavigationView navigation;
    private static final String LOG_TAG = "";
    private static Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private ImageView imgEverest;

    TextView tvIndicator1,tvIndicator2,tvIndicator3,tvIndicator4, tvNext;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new CoursesFragment();
                    textToolbar.setText(getResources().getString(R.string.toolbar_course));
                    relToolbar.setVisibility(View.VISIBLE);
                    transactionFragment();
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new DiseaseListFragment();
                    textToolbar.setText(getResources().getString(R.string.toolbar_disease));
                    relToolbar.setVisibility(View.VISIBLE);
                    transactionFragment();
                    return true;
                case R.id.navigation_notifications:
                    fragment = new AboutFragment();
                    textToolbar.setText(getResources().getString(R.string.toolbar_about));
                    //relToolbar.setVisibility(View.GONE);
                    transactionFragment();
                    //startActivity(new Intent(MainActivity.this,AboutActivity.class));
                    return true;
            }
            return false;
        }

    };

    private void initIndicators(){

        //initialize 4 indicators and text new slide

        tvNext = (TextView) findViewById(R.id.textViewNext);

        tvIndicator1 = (TextView) findViewById(R.id.textView32);
        tvIndicator2 = (TextView) findViewById(R.id.textView3);
        tvIndicator3 = (TextView) findViewById(R.id.textView31);
        tvIndicator4 = (TextView) findViewById(R.id.textView33);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            allInit();
            mSettings = this.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            String first = mSettings.getString(APP_PREFERENCES_FIRST, "");
            if(Integer.parseInt(first)==1) noFirstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //nextPage();
        //preViewPage();
        if(position==203) {
            float i = positionOffsetPixels;
            float t = positionOffset;
            if(i>0.01){
                try {
                    //mDemoSlider.setVisibility(View.GONE);
                    animHideSlider();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        sliderScrolledIndicator();
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            //frameLayout.startAnimation(mFadeOutAnimation);
            frameLayout.setVisibility(View.VISIBLE);
            navigation.setVisibility(View.VISIBLE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            frameLayout.setVisibility(View.VISIBLE);
            navigation.setVisibility(View.VISIBLE);
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            frameLayout.setVisibility(View.VISIBLE);
            navigation.setVisibility(View.VISIBLE);
            // TODO Auto-generated method stub
        }
    };

    Animation.AnimationListener animationFadeOutListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            //frameLayout.startAnimation(mFadeOutAnimation);
            mDemoSlider.setVisibility(View.GONE);
            relIndicatorSlider.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            mDemoSlider.setVisibility(View.VISIBLE);
            relIndicatorSlider.setVisibility(View.VISIBLE);
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            mDemoSlider.setVisibility(View.VISIBLE);
            relIndicatorSlider.setVisibility(View.VISIBLE);
            // TODO Auto-generated method stub
        }
    };

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()){
                case R.id.relNext:
                    try {
                        tvNext.setText(getResources().getString(R.string.next));
                        nextPage();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.relPreView:
                    tvNext.setText(getResources().getString(R.string.next));
                    preViewPage();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nextPage() {
        // click next page

        try {
            int i = mDemoSlider.getCurrentPosition();
            if(mDemoSlider.getCurrentPosition()!=3) {
                nextIndicator();mDemoSlider.moveNextPosition();
                //animHideSlider();
            }else {
                animHideSlider();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preViewPage() {

        // click pre page


        if(mDemoSlider.getCurrentPosition()!=0){
            preIndicztor();
            mDemoSlider.movePrevPosition();
        }
    }

    private void nextIndicator(){

        // initialize current indicators (click new page)

        try {
            resetIndicator();
            if(mDemoSlider.getCurrentPosition()==0){
                relPreView.setVisibility(View.VISIBLE);
                tvIndicator2.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
            }else if(mDemoSlider.getCurrentPosition()==1){
                //relPreView.setVisibility(View.GONE);
                tvIndicator3.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
            }else if(mDemoSlider.getCurrentPosition()==2){
                tvNext.setText(getResources().getString(R.string.done));
                tvIndicator4.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preIndicztor(){

        // initialize current indicators (click pre page)

        resetIndicator();
        if(mDemoSlider.getCurrentPosition()==3){
            relNext.setVisibility(View.VISIBLE);
            tvIndicator3.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
        }else if(mDemoSlider.getCurrentPosition()==2){
            tvIndicator2.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
        }else if(mDemoSlider.getCurrentPosition()==1){
            tvIndicator1.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
            relPreView.setVisibility(View.GONE);
        }
    }

    private void resetIndicator(){

        //  reset back indicators tv

        tvIndicator1.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv));
        tvIndicator2.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv));
        tvIndicator3.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv));
        tvIndicator4.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv));
    }

    private void sliderScrolledIndicator(){
        resetIndicator();
        switch (mDemoSlider.getCurrentPosition()){
            case 0:
                tvIndicator1.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
                relPreView.setVisibility(View.GONE);
                break;
            case 1:
                tvIndicator2.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
                relPreView.setVisibility(View.VISIBLE);
                break;
            case 2:
                tvIndicator3.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
                tvNext.setText(getResources().getString(R.string.next));
                break;
            case 3:
                tvIndicator4.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_tv_active));
                tvNext.setText(getResources().getString(R.string.done));
                break;
        }
    }

    private void allInit(){


        imgEverest = (ImageView) findViewById(R.id.imageView4);
        textToolbar = (TextView) findViewById(R.id.toolbar_text);
        relToolbar = (RelativeLayout) findViewById(R.id.relToolbar);
        relIndicatorSlider = (RelativeLayout) findViewById(R.id.relIndicatorSlider);
        frameLayout = (FrameLayout) findViewById(R.id.content);
        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        mFadeOutAnimation.setAnimationListener(animationFadeOutListener);

        relNext = (RelativeLayout) findViewById(R.id.relNext);
        relPreView = (RelativeLayout) findViewById(R.id.relPreView);

        relNext.setOnClickListener(this);
        relPreView.setOnClickListener(this);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);


        // init drawable to sliders

        List<Integer> map = new ArrayList<>();
        map.add(R.drawable.aimage);
        map.add(R.drawable.bimage);
        map.add(R.drawable.cimage);
        map.add(R.drawable.dimage);
        //map.add(R.drawable.eimage);

        for (int name : map) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(name)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra","" );

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.stopAutoCycle();
        mDemoSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);

        //mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(400000);
        mDemoSlider.addOnPageChangeListener(this);

        initIndicators();

        fragment = new CoursesFragment();
        transactionFragment();
    }

    private void animHideSlider(){
        setPrefsFirst();
        imgEverest.setVisibility(View.GONE);
        frameLayout.startAnimation(mFadeInAnimation);
        navigation.startAnimation(mFadeInAnimation);
        mDemoSlider.startAnimation(mFadeOutAnimation);
        relIndicatorSlider.startAnimation(mFadeOutAnimation);
    }

    private void transactionFragment(){
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    private void setPrefsFirst(){
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_FIRST, "1");
        editor.apply();
    }

    private void noFirstRun(){
        imgEverest.setVisibility(View.GONE);
        mDemoSlider.setVisibility(View.GONE);
        relIndicatorSlider.setVisibility(View.GONE);
        frameLayout.startAnimation(mFadeInAnimation);
        navigation.startAnimation(mFadeInAnimation);

    }
}
