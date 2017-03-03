package com.nimble.androidanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.lottie_bt_progress)
    public void goToAnimationProgressExample() {
        LottieOnBoardingActivity.show(this);
    }

    @OnClick(R.id.lottie_bt_gif_comparison)
    public void goToGifComparisonExample() {
        LottieVsGifActivity.show(this);
    }
}
