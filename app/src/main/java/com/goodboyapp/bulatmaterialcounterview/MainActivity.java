package com.goodboyapp.bulatmaterialcounterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.goodboyapp.bulatmaterial.CounterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CounterView counterView = (CounterView) findViewById(R.id.counterView);
        counterView.setupOnChangeListener(new CounterView.OnChangeListener() {
            @Override
            public void onChange() {
                Toast.makeText(MainActivity.this, "testMessage", Toast.LENGTH_LONG).show();
            }
        });
    }
}
