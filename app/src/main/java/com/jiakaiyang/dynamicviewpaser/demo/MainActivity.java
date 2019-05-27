package com.jiakaiyang.dynamicviewpaser.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jiakaiyang.dynamicviewpaser.demo.R;
import com.jiakaiyang.dynamicviewpaser.lib.AttributeSetCreater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        AttributeSetCreater.createParser();
    }
}
