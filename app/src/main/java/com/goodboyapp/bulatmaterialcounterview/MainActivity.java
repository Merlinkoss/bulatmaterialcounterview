package com.goodboyapp.bulatmaterialcounterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.goodboyapp.bulatmaterial.CounterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CounterView counterView = (CounterView) findViewById(R.id.counterView);
    }
}
