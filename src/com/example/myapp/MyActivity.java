package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class MyActivity extends Activity {
    SoundPool soundPool;
    HashMap<Integer, Integer> soundPoolMap;
    int CLICK = 1;
    int BLUE = 2;
    int RED= 3;
    int GREEN=4;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap<Integer, Integer>();

        soundPoolMap.put(CLICK, soundPool.load(this, R.raw.sndclick1, 1));
        soundPoolMap.put(BLUE, soundPool.load(this, R.raw.blue, 1));
        soundPoolMap.put(RED, soundPool.load(this, R.raw.red, 1));
        soundPoolMap.put(GREEN
                , soundPool.load(this, R.raw.green, 1));


    }

    public void click1(View view) {
        sound(CLICK);
    }
    public void clickBlue(View view) {
        sound(BLUE);
    }

    public void GREEN1(View view) {
        sound(GREEN);
    }
    public void clickrad(View view) {
        sound(RED);
    }









    void sound(int id){
        //view.setEnabled(false);

        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float leftVolume = curVolume/maxVolume;
        float rightVolume = curVolume/maxVolume;
        int priority = 1;
        int no_loop = 0;
        float normal_playback_rate = 1f;
        soundPool.play(soundPoolMap.get(id), leftVolume, rightVolume, priority, no_loop, normal_playback_rate);

    }
}
