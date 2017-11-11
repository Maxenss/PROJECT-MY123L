package com.leonis.leonisandrod;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Floglor on 10.11.2017.
 */

public class PhoneCall extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_call_layout);
        final ImageButton buttonMic = (ImageButton) findViewById(R.id.buttonMic);
        final ImageButton buttonVolume = (ImageButton) findViewById(R.id.buttonVolume);

        buttonMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMic.setImageResource(R.drawable.ic_action_call_mic_off);
            }
        });

        buttonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonVolume.setImageResource(R.drawable.ic_action_call_volume_off);
            }
        });
    }
}
