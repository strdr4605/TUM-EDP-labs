package com.example.strainu.edp_lab3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        drawView = new DrawView(this);
        setContentView(drawView);
//        drawView = (DrawView) findViewById(R.id.drawing);
//        drawView.setBackgroundColor(Color.WHITE);

    }
}
