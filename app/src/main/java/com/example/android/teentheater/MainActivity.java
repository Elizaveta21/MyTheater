package com.example.android.teentheater;

import android.content.Intent;
import android.graphics.ImageFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickdate(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityOrder.class);
        startActivity(intent);
    }

    public void onClickperf1(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityPerf1.class);
        startActivity(intent);
    }

    public void onClickperf2(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityPerf2.class);
        startActivity(intent);
    }

    public void onClickperf3(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityPerf3.class);
        startActivity(intent);
    }

    public void clickSite(View view) {
        Uri address = Uri.parse("http://www.svoboda-3.ru");
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
        if (openlinkIntent.resolveActivity(getPackageManager()) != null)
            startActivity(openlinkIntent);
    }

}
