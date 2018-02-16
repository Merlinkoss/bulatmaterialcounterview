package com.goodboyapp.bulatmaterial;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Anton
 * email: kondratyuk.anton.ig@gmail.com
 */


public class CounterView extends RelativeLayout {
    View rootView;
    TextView left;
    TextView right;
    TextView counter;

    public CounterView(Context context) {
        super(context);
        init(context);
    }

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context)
    {
        rootView = inflate(getContext(), R.layout.custom_view, null);
        addView(rootView);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}
