package com.example.mobiapp.tishanskayaapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobiapp.tishanskayaapp.R;

/**
 * Created by mobi app on 25.08.2017.
 */

public class CardView extends RelativeLayout {

    TextView tv;
    RadioButton rb;
    RelativeLayout rel;
    ImageView img;

    public CardView(Context context) {
        super(context);
        init();
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.card_view, this);
        this.tv = (TextView) findViewById(R.id.card_text);
        this.rel = (RelativeLayout) findViewById(R.id.card_rel);
        this.rb = (RadioButton) findViewById(R.id.card_radio);
        this.img = (ImageView) findViewById(R.id.card_img);
    }

    public void setText(String txt){
        tv.setText(txt);
    }

    public boolean check(){
        if(rb.isChecked()) {
            rb.setChecked(false);
            rel.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
            img.setImageDrawable(getResources().getDrawable(R.drawable.cimage));
            return true;
        }else {
            rb.setChecked(true);
            rel.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            img.setImageDrawable(getResources().getDrawable(R.drawable.circle_button));
            return false;
        }
    }

    public void setChecked(){
        img.setImageDrawable(getResources().getDrawable(R.drawable.circle_button));
        rb.setChecked(true);
        rel.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    public void dontChecked(){
        img.setImageDrawable(getResources().getDrawable(R.drawable.cimage));
        rb.setChecked(false);
        rel.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
    }
}
