package com.nimble.androidanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LottieVsGifActivity extends AppCompatActivity {
    @BindView(R.id.lottie_lav_view) LottieAnimationView mLavView;
    @BindView(R.id.lottie_iv_gif) ImageView mIvGif;

    public static void show(Context context) {
        Intent intent = new Intent(context, LottieVsGifActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_vs_gif);
        ButterKnife.bind(this);

        Glide.with(this)
                .load(R.drawable.progress)
                .asGif()
                .into(mIvGif);
    }
}
