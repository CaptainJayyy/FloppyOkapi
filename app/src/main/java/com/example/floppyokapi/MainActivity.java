package com.example.floppyokapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* TODO
         * Should all of this activity initialization/setup
         * be put into it's own function call?
         */

        View decorView = getWindow().getDecorView();

        int viewOptions = View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(viewOptions);

        // Request the feature of content transitions
        // (enables transitions between activities)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // Allow enter/exit transition overlap
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);

        // Set the entry transition
        getWindow().setEnterTransition(new Explode());

        // Set the exit transition (Slide to the top edge)
        getWindow().setExitTransition(new Slide(Gravity.TOP));

        setContentView(R.layout.activity_main);
    }


    public void startGame(View view) {
        Intent intent = new Intent(this, GameView.class);

        // Pass in Activity Options to enable transitions
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
