package com.example.mucca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int mucche=0;
    Timer upTimer,rightTimer,downTimer,leftTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        setContentView(R.layout.activity_main);
        ImageView mucca= findViewById(R.id.mucca);
        Button moveUp= findViewById(R.id.buttonUp);
        Button moveRight= findViewById(R.id.buttonRight);
        Button moveDown= findViewById(R.id.buttonDown);
        Button moveLeft= findViewById(R.id.buttonLeft);
        MediaPlayer muuSound = MediaPlayer.create(this,R.raw.moo);
        mucca.setOnClickListener(v->{
            muuSound.start();
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
            mucca.startAnimation(animation);
        });

        moveUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Pressed down
                        upTimer=new Timer();
                        upTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mucca.getLayoutParams();
                                        params.verticalBias = Math.max(0f,params.verticalBias-0.005f);
                                        mucca.setLayoutParams(params);
                                    }
                                });
                            }
                        },0,20);
                        return true;
                    case MotionEvent.ACTION_UP:
                        // Release
                        upTimer.cancel();
                        upTimer.purge();
                        return true;
                }
                return false;
            }
        });
        moveRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Pressed down
                        rightTimer=new Timer();
                        rightTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mucca.getLayoutParams();
                                        params.horizontalBias = Math.min(1.0f,params.horizontalBias+0.005f);
                                        mucca.setLayoutParams(params);
                                    }
                                });
                            }
                        },0,20);
                        return true;
                    case MotionEvent.ACTION_UP:
                        // Release
                        rightTimer.cancel();
                        rightTimer.purge();
                        return true;
                }
                return false;
            }
        });

        moveDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Pressed down
                        downTimer=new Timer();
                        downTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mucca.getLayoutParams();
                                        params.verticalBias = Math.min(1.0f,params.verticalBias+0.005f);
                                        mucca.setLayoutParams(params);
                                    }
                                });
                            }
                        },0,20);
                        return true;
                    case MotionEvent.ACTION_UP:
                        // Release
                        downTimer.cancel();
                        downTimer.purge();
                        return true;
                }
                return false;
            }
        });
        moveLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Pressed down
                        leftTimer=new Timer();
                        leftTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mucca.getLayoutParams();
                                        params.horizontalBias = Math.max(0f,params.horizontalBias-0.005f);
                                        mucca.setLayoutParams(params);
                                    }
                                });
                            }
                        },0,20);
                        return true;
                    case MotionEvent.ACTION_UP:
                        // Release
                        leftTimer.cancel();
                        leftTimer.purge();
                        return true;
                }
                return false;
            }
        });
    }
}