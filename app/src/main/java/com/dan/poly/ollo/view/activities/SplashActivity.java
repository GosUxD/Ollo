package com.dan.poly.ollo.view.activities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dan.poly.ollo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash_logo)
    ImageView mLogo;
    @BindView(R.id.logo_text_container)
    RelativeLayout mLogoTextContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


    }

    public void animate(View view) {
        ObjectAnimator dropAnimation = ObjectAnimator.ofFloat(mLogo, View.TRANSLATION_Y, 300);
        dropAnimation.setDuration(1000);
        dropAnimation.setInterpolator(new BounceInterpolator());

        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(mLogo, View.ROTATION, 1080);
        rotateAnimation.setDuration(3500);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(mLogoTextContainer, View.ALPHA, 0.f);
        fadeOut.setDuration(1000);

        AnimatorSet choreography = new AnimatorSet();
        choreography.play(dropAnimation).before(rotateAnimation).with(fadeOut);
        choreography.start();
        choreography.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                finish();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}
