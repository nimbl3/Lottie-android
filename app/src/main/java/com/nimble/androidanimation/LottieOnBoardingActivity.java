package com.nimble.androidanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class LottieOnBoardingActivity extends AppCompatActivity {
    /**
     * Set animation progress for each page
     */
    private static final float[] ANIMATION_TIMES = new float[]{
            0f,
            0.3f,
            0.6f,
            1f,
            1f
    };

    @BindView(R.id.lottie_lav_view) LottieAnimationView mLavView;
    @BindView(R.id.lottie_ci_pager_indicator) CircleIndicator mCiPagerIndicator;
    @BindView(R.id.lottie_vp_pager) ViewPager mVpPager;

    public static void show(Context context) {
        Intent intent = new Intent(context, LottieOnBoardingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_onboarding);
        ButterKnife.bind(this);
        setupViewPager();
    }

    private void setupViewPager() {
        LottieIntroPagerAdapter adapter = new LottieIntroPagerAdapter(getSupportFragmentManager());
        mVpPager.setAdapter(adapter);
        mVpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setAnimationProgress(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mCiPagerIndicator.setViewPager(mVpPager);
    }

    /**
     * Calculate frame position to play
     * @param position view pager position
     * @param positionOffset scroll offset position for each page from 0-1
     */
    private void setAnimationProgress(int position, float positionOffset) {
        System.out.println("LOG positionOffset " + positionOffset);
        float startProgress = ANIMATION_TIMES[position];
        float endProgress = ANIMATION_TIMES[position + 1];
        float currentProgress = startProgress + positionOffset * (endProgress - startProgress);

        mLavView.setProgress(currentProgress);
    }

    private class LottieIntroPagerAdapter extends FragmentPagerAdapter {

        public LottieIntroPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return EmptyFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public static final class EmptyFragment extends Fragment {

        private static EmptyFragment newInstance() {
            return new EmptyFragment();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_empty, container, false);
        }
    }
}
