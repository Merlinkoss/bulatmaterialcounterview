package com.goodboyapp.bulatmaterial;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Anton
 * email: kondratyuk.anton.ig@gmail.com
 */


public class CounterView extends RelativeLayout {
    private View rootView;
    private TextView left;
    private TextView right;
    private TextView counter;

    private int type = 0; // 0 is intValues, 1 is floatValues
    private float maxValue = 500;
    private float minValue = 0;
    private int primaryColor; // color of text Up/Down and backgrund of counter
    private int secondaryColor; // color of backgorund button and text of counter
    private int separatorColor; // color of separator
    private String plusString; // text of rightButton
    private String minusString; // text of leftButton

    public CounterView(Context context) {
        super(context, null);
        init(context, null);
    }

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attributeSet)
    {
        LayoutInflater  mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView = mInflater.inflate(R.layout.custom_view, this, true);
        left = (TextView) rootView.findViewById(R.id.leftButton);
        right = (TextView) rootView.findViewById(R.id.rightButton);
        counter = (TextView) rootView.findViewById(R.id.counter);

        if(attributeSet != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attributeSet,
                    R.styleable.CounterView,
                    0, 0);

            setupDefaultValue(a, context);
        } else {
            type = 0;
            maxValue = 500;
            minValue = 0;
            primaryColor = context.getResources().getColor(R.color.background);
            secondaryColor = context.getResources().getColor(R.color.alpha_background);
            separatorColor = context.getResources().getColor(R.color.separator);

            plusString = "+";
            minusString = "-";
        }
    }

    private void setupDefaultValue(TypedArray array, Context context) {
        maxValue = array.getFloat(R.styleable.CounterView_maxValue, 500);
        minValue = array.getFloat(R.styleable.CounterView_minValue, 0);

        primaryColor = array.getColor(R.styleable.CounterView_primaryColor, context.getResources().getColor(R.color.background));
        separatorColor = array.getColor(R.styleable.CounterView_separatorColor, context.getResources().getColor(R.color.separator));
        secondaryColor = array.getColor(R.styleable.CounterView_secondaryColor, context.getResources().getColor(R.color.alpha_background));

        plusString = array.getString(R.styleable.CounterView_plusString);
        minusString = array.getString(R.styleable.CounterView_minusString);

        type = array.getInt(R.styleable.CounterView_type, 0);
    }
}