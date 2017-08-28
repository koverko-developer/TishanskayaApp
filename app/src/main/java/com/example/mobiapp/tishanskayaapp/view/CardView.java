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
    }

    public void setText(String txt){
        tv.setText(txt);
    }

    public boolean check(){
        if(rb.isChecked()) {
            rb.setChecked(false);
            rel.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
            return true;
        }else {
            rb.setChecked(true);
            rel.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            return false;
        }
    }

    public void setChecked(){
        rb.setChecked(true);
        rel.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    public void dontChecked(){
        rb.setChecked(false);
        rel.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
    }
}
