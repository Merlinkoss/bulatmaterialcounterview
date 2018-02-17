package com.goodboyapp.bulatmaterial;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
    private View separator;

    private int type = 0; // 0 is intValues, 1 is floatValues
    private float maxValue = 500;
    private float minValue = 0;
    private int primaryColor; // color of text Up/Down and backgrund of counter
    private int secondaryColor; // color of backgorund button and text of counter
    private int separatorColor; // color of separator
    private String plusString; // text of rightButton
    private String minusString; // text of leftButton

    private float diff = 1.0f; // step by click plus/minus button
    private float value = 1.0f;

    private OnChangeListener onChangeListener = null;

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attributeSet) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView = mInflater.inflate(R.layout.custom_view, this, true);
        left = (TextView) rootView.findViewById(R.id.leftButton);
        right = (TextView) rootView.findViewById(R.id.rightButton);
        counter = (TextView) rootView.findViewById(R.id.currentValue);
        separator = rootView.findViewById(R.id.separator);

        if (attributeSet != null) {
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
            diff = 1.0f;
            value = 1.0f;
        }

        setupPrimaryColor(primaryColor);
        setupSecondaryColor(secondaryColor);
        setupSeparatorColor(separatorColor);
        setupTextButton(minusString, plusString);
        correctAndSetupMinValue();
        setupButtonListeners();
    }

    private void setupDefaultValue(TypedArray array, Context context) {
        maxValue = array.getFloat(R.styleable.CounterView_maxValue, 500);
        minValue = array.getFloat(R.styleable.CounterView_minValue, 0);
        diff = array.getFloat(R.styleable.CounterView_diff, 0);

        primaryColor = array.getColor(R.styleable.CounterView_primaryColor, context.getResources().getColor(R.color.background));
        separatorColor = array.getColor(R.styleable.CounterView_separatorColor, context.getResources().getColor(R.color.separator));
        secondaryColor = array.getColor(R.styleable.CounterView_secondaryColor, context.getResources().getColor(R.color.alpha_background));

        plusString = array.getString(R.styleable.CounterView_plusString);
        minusString = array.getString(R.styleable.CounterView_minusString);

        type = array.getInt(R.styleable.CounterView_type, 0);
        value = array.getFloat(R.styleable.CounterView_value, 0);
    }

    public void setupOnChangeListener(OnChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    public void setupSeparatorColor(int separatorColor) {
        separator.setBackgroundColor(separatorColor);
    }

    public void setupSecondaryColor(int secondaryColor) {
        counter.setTextColor(secondaryColor);
        setupBackgroundButtonsColor(secondaryColor);
    }

    public void setupPrimaryColor(int primaryColor) {
        left.setTextColor(primaryColor);
        right.setTextColor(primaryColor);
        setupBackgroundCounterColor(primaryColor);
    }

    public void setupTextButton(String left, String right) {
        this.left.setText(left);
        this.right.setText(right);
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    private void setupButtonListeners() {
        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonsClick(false);
            }
        });

        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonsClick(true);
            }
        });
    }

    private void onButtonsClick(boolean isPlus) {
        float startValue = value;
        value = isPlus ? value + diff : value - diff;
        if (value < minValue || value > maxValue)
            value = startValue;

        if (type == 0) {
            String adder = value >= 0 ? "+" : "-";
            counter.setText(adder + String.format("%.0f", value));
        } else
            counter.setText(String.format("%.1f", value));

        if (onChangeListener != null)
            onChangeListener.onChange();
    }

    private void correctAndSetupMinValue() {
        if (type == 1) {
            minValue = 0f;

            if (value < 0)
                value = 1f;

            counter.setText(String.format("%.1f", value));
        } else {
            String adder = value >= 0 ? "+" : "-";
            counter.setText(adder + String.format("%.0f", value));
        }
    }

    private void setupBackgroundCounterColor(int primaryColor) {
        Drawable back = counter.getBackground();
        ((GradientDrawable) back).setColor(primaryColor);
    }

    private void setupBackgroundButtonsColor(int secondaryColor) {
        Drawable back = left.getBackground();
        ((GradientDrawable) back).setColor(secondaryColor);

        Drawable back2 = right.getBackground();
        ((GradientDrawable) back2).setColor(secondaryColor);
    }

    public interface OnChangeListener {
        void onChange();
    }
}