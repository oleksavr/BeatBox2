package com.example.beatbox.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.beatbox.sounds.BeatBox;
import com.example.beatbox.sounds.Sound;

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox){
        mBeatBox = beatBox;
    }
     @Bindable
    public String getTitle(){
        return mSound.getName();
    }

    public Sound getSound(){
        return mSound;
    }

    public void setSound(Sound sound){
        mSound = sound;
        notifyChange();
    }
}
