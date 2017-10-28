/*
 * Copyright (c) 2009-2017 Freedomotic team http://freedomotic.com
 *
 * This file is part of Freedomotic
 *
 * This Program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2, or (at your option) any later version.
 *
 * This Program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Freedomotic; see the file COPYING. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.freedomotic.freedomotic.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.freedomotic.freedomotic.R;

import butterknife.BindView;

public class SplashScreen extends BaseActivity {
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    private Handler progressBarbHandler = new Handler();
    public static int progressBarStatus=0;
    @BindView(R.id.splash_progress_bar) ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //This method to be used when no progress is to be done or splash screen is just for display purpose only
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //Add intent to which activity to go from splash screen
            }
        }, SPLASH_DISPLAY_LENGTH);
        //If data loading threads are present or actual method for data loading
//        progressBar.setVisibility(View.VISIBLE);
//        progressBar.setMax(100);
//        progressBar.setProgress(0);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (progressBarStatus < 100) {
//                    //call methodFor running thread process with return type int
//                    //progressBarStatus=method()
//                    progressBarStatus=progressBarStatus+1;
//                }
//                progressBarbHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        progressBar.setProgress(progressBarStatus);
//                    }
//                });
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
