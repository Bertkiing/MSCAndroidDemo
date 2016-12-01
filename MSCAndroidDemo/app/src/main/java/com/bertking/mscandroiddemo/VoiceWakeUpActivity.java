package com.bertking.mscandroiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

/**
 * 语音唤醒
 */
public class VoiceWakeUpActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = VoiceWakeUpActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_voice_wake_up);
        findViewById(R.id.btn_wake).setOnClickListener(this);
        findViewById(R.id.btn_oneshot).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_wake:
                intent = new Intent(this, WakeUpActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_oneshot:
                intent = new Intent(this, OneShotDemo.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
