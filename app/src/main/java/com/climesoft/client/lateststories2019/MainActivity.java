package com.climesoft.client.lateststories2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startReadingOnClick(View view) {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            startActivity(new Intent(this, ReadingActivity.class));
        }

    }

    public void existOnClick(View view) {
        finish();
        System.exit(0);
    }

    public void ratingAppOnClick(View view) {

    }

    @Override
    protected void onStart() {
        super.onStart();

        interstitialAdShow();

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                startActivity(new Intent(MainActivity.this, ReadingActivity.class));
            }
        });
    }

    private void interstitialAdShow() {
        try {
            MobileAds.initialize(this, getString(R.string.add_mob_app_id));
            interstitialAd = new InterstitialAd(this);
            interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
            interstitialAd.loadAd(new AdRequest.Builder().build());

        } catch (Exception ignored) {

        }
    }
}
