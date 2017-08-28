package com.example.mobiapp.tishanskayaapp.fragments;


import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobiapp.tishanskayaapp.R;
import com.example.mobiapp.tishanskayaapp.adapter.CoursesAdapter;
import com.example.mobiapp.tishanskayaapp.adapter.DiseaseAdapter;
import com.example.mobiapp.tishanskayaapp.classes.Paths;
import com.example.mobiapp.tishanskayaapp.disease.CoursesGenerate;
import com.example.mobiapp.tishanskayaapp.disease.DiseaseGenerate;
import com.example.mobiapp.tishanskayaapp.view.fillableloaders.FillableLoader;
import com.example.mobiapp.tishanskayaapp.view.fillableloaders.FillableLoaderBuilder;
import com.example.mobiapp.tishanskayaapp.view.fillableloaders.clippingtransforms.PlainClippingTransform;
import com.example.mobiapp.tishanskayaapp.view.fillableloaders.listener.OnStateChangeListener;
import com.github.jorgecastillo.State;
import com.triggertrap.seekarc.SeekArc;

import xyz.hanks.library.SmallBang;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {

    View v;
    int seconds = 0;
    final Handler handler = new Handler();
    private Runnable myRunnable;
    private Animation mEnlargeAnimation, mArcAnim;
    private boolean isAnim = false;
    FillableLoader fillableLoaderIn;
    ImageView imgAnim;
    SmallBang mSmallBang;
    TextView tvTimer;
    private boolean isVdoh = false;
    RelativeLayout rel_play;
    private boolean isPlay = false;
    ImageView img_play;
    FillableLoader fillableLoader;

    public CoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {
            v = inflater.inflate(R.layout.fragment_courses, container, false);

            FillableLoaderBuilder loaderBuilder = new FillableLoaderBuilder();
            RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.courses_rel_main);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(500, 500);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            fillableLoaderIn = loaderBuilder
                    .parentView(relativeLayout)
                    .layoutParams(params)
                    .svgPath(Paths.JOB_AND_TALENT)
                    .originalDimensions(500, 500)
                    .strokeWidth(2)
                    .strokeColor(Color.parseColor("#1c9ade"))
                    .fillColor(Color.parseColor("#1c9ade"))
                    .strokeDrawingDuration(1)
                    .fillDuration(7000)
                    .clippingTransform(new PlainClippingTransform())
                    .build();

//            fillableLoaderIn.setSvgPath(Paths.LEGHKIE);
//            fillableLoaderIn.start();

            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    private void init(){
        try {
            tvTimer = (TextView) v.findViewById(R.id.courses_timerText);
            rel_play = (RelativeLayout) v.findViewById(R.id.courses_play_rel);
            img_play = (ImageView) v.findViewById(R.id.courses_img_paly);
            rel_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!isPlay) {
                        in();
                        img_play.setImageDrawable(v.getResources().getDrawable(R.drawable.ic_pause_black_24dp));
                    }else {
                        reset();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void in(){
        try {
            if(isPlay)animImage();
            isPlay = true;
            isVdoh = true;
            if(myRunnable!=null)handler.removeCallbacks(myRunnable);
            runTimer();
            //fillableLoaderIn = (FillableLoader) v.findViewById(R.id.fillableLoader);

            fillableLoaderIn.setVisibility(View.GONE);
            fillableLoaderIn.setRotation(0);
            fillableLoaderIn.setVisibility(View.VISIBLE);
            fillableLoaderIn.setSvgPath(Paths.INDOMINUS_REX);

            fillableLoaderIn.start();

            fillableLoaderIn.setOnStateChangeListener(new OnStateChangeListener() {
                @Override
                public void onStateChange(int state) {
                    switch(state) {
                        case State.FILL_STARTED:

                            break;
                        case State.FINISHED:
                            out();
                            break;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void out(){
        try {
            isVdoh = false;
            handler.removeCallbacks(myRunnable);
            //fillableLoaderIn = (FillableLoader) v.findViewById(R.id.fillableLoader);
            animImage();
            fillableLoaderIn.setVisibility(View.GONE);
            fillableLoaderIn.setRotation(180);
            fillableLoaderIn.setVisibility(View.VISIBLE);
            fillableLoaderIn.setSvgPath(Paths.LEGHKIE);

            fillableLoaderIn.start();

            fillableLoaderIn.setOnStateChangeListener(new OnStateChangeListener() {
                @Override
                public void onStateChange(int state) {
                    switch(state) {
                        case State.FILL_STARTED:

                            break;
                        case State.FINISHED:
                            in();
                            break;
                    }
                }
            });

            runTimer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset(){
        isPlay = false;
        handler.removeCallbacks(myRunnable);
        img_play.setImageDrawable(v.getResources().getDrawable(R.drawable.ic_play_arrow_black_24dp));
        fillableLoaderIn.reset();
    }

    private void animImage(){
        imgAnim = (ImageView) v.findViewById(R.id.courses_imgAnima);
        mSmallBang = SmallBang.attach2Window(this.getActivity());

        mSmallBang.bang(imgAnim);
    }

    private void visibleElements() {
        isAnim = false;
//        ovalImage.clearAnimation();
//        arc1.setVisibility(View.VISIBLE);
//        arc2.setVisibility(View.VISIBLE);
    }

    private void setRecyclerCiew(){
//        //RecyclerView recyclerDisease = (RecyclerView) v.findViewById(R.id.recyclerCourses);
//        recyclerDisease.setHasFixedSize(true);
//
//        // используем linear layout manager
//        mLayoutManager = new LinearLayoutManager(this.getActivity());
//        recyclerDisease.setLayoutManager(mLayoutManager);
//        // создаем адаптер
//        try {
//            CoursesGenerate generate = new CoursesGenerate(this.getContext());
//            mAdapter = new CoursesAdapter(getDataSet(), this,generate.getAllCourses() );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        recyclerDisease.setAdapter(mAdapter);
    }

    private String[] getDataSet() {

        String[] mDataSet = new String[10];
        for (int i = 0; i < 10; i++) {
            mDataSet[i] = "item" + i;
        }
        return mDataSet;
    }


//    public void clickBuy(){
//
//    }
//

    public void runTimer(){
        long time = 8000;
        final long startTime = System.currentTimeMillis() + time;
        try {
            //seconds = 7;
            myRunnable = new Runnable() {
                @Override
                public void run(){


                    long millis = startTime - System.currentTimeMillis();
                    int seconds = (int) (millis / 1000);
                    int minutes = seconds / 60;
                    seconds = seconds % 60;
                    String text = String.format("%02d", seconds);
                    if(isVdoh) tvTimer.setText("Вдох: "+text);
                    else tvTimer.setText("Выдох: "+text);
                    handler.postDelayed(this, 500);
                }
            };
            handler.post(myRunnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void resetArc(){
//        ovalImage.startAnimation(mEnlargeAnimation);
////        arc1.startAnimation(mArcAnim);
////        arc2.startAnimation(mArcAnim);
////        arc1.setArcColor(this.getResources().getColor(R.color.circle_center));
////        arc2.setArcColor(this.getResources().getColor(R.color.circle_center));
////        arc1.setProgressColor(this.getResources().getColor(R.color.circle_center));
////        arc2.setProgressColor(this.getResources().getColor(R.color.circle_center));
//        arc1.setVisibility(View.GONE);
//        arc2.setVisibility(View.GONE);
//        releaseMP();
//        startSound3();
//    }
//
//    private void resetSeek(){
//        arc1.setProgress(0);
//        arc2.setProgress(0);
//        seconds = 0;
//        secondsTwo = 0;
//    }
//
//    private void releaseMP() {
//        if (mediaPlayer != null) {
//            try {
//                mediaPlayer.release();
//                mediaPlayer = null;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void startSound1(){
//        releaseMP();
//        mediaPlayer = MediaPlayer.create(this.getActivity(), R.raw.relax1);
//        mediaPlayer.start();
//    }
//
//    private void startSound2(){
//        releaseMP();
//        mediaPlayer = MediaPlayer.create(this.getActivity(), R.raw.relax2);
//        mediaPlayer.start();
//    }
//    private void startSound3(){
//        releaseMP();
//        mediaPlayer = MediaPlayer.create(this.getActivity(), R.raw.relax3);
//        mediaPlayer.start();
//    }
//
//    private void listenerSet(){
//        if (mediaPlayer == null)
//            return;
//        mediaPlayer.setOnCompletionListener(this);
//    }
//
//    public void onPrepared(MediaPlayer mp) {
//        mp.start();
//    }
//
//    @Override
//    public void onCompletion(MediaPlayer mp) {
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        releaseMP();
//    }
//
    @Override
    public void onPause() {
        super.onPause();
        reset();
    }
}
