package com.climesoft.client.lateststories2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startReadingOnClick(View view) {
        startActivity(new Intent(this, ReadingActivity.class));
    }

    public void existOnClick(View view) {
        finish();
        System.exit(0);
    }

    public void ratingAppOnClick(View view) {
    }
}
