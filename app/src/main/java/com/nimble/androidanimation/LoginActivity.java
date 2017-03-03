package com.nimble.androidanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_ll_container) ViewGroup mLlLoginLayout;
    @BindView(R.id.login_ll_form_container) ViewGroup mLlLoginForm;
    @BindView(R.id.login_pb_progress) ProgressBar mPbProgressbar;
    @BindView(R.id.login_bt_submit) Button mBtLogin;
    @BindView(R.id.login_bt_animation) LottieAnimationView mLavLoginAnimation;

    public static void show(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLlLoginForm.setVisibility(View.GONE);

        mLlLoginLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        TransitionManager.beginDelayedTransition(mLlLoginLayout);
                        mLlLoginForm.setVisibility(View.VISIBLE);
                    }
                }, 200);

                mLlLoginLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @OnClick(R.id.login_bt_submit)
    public void submit() {
        TransitionManager.beginDelayedTransition(mLlLoginLayout);
        mPbProgressbar.setVisibility(View.VISIBLE);
        mLlLoginForm.setVisibility(View.GONE);

        mLavLoginAnimation.loop(true);
        mLavLoginAnimation.playAnimation();
    }
}

