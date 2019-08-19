package com.example.beatbox.sounds;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    public static final String TAG = "BeatBox";
    public static final String SOUND_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS=5;

    private AssetManager assetManager;
    private List<Sound> mSound = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox (Context context){
        assetManager = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    public void play(Sound sound){
        Integer soundId = sound.getmSoundId();
        if(soundId == null){
            return;
        }

        mSoundPool.play(soundId, 1.0f,1.0f,1,0,1.0f);
    }

    public void release(){
        mSoundPool.release();
    }

    private void loadSounds(){
        String [] soundNames;

        try {
            soundNames = assetManager.list(SOUND_FOLDER);

            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            return;
        }

        for (String filename : soundNames){
            try {
                String assetPath = SOUND_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSound.add(sound);
            }catch(IOException e){
                Log.e(TAG,"Could not load sound " + filename, e);
            }
        }

    }

    private void load(Sound sound) throws IOException{
        AssetFileDescriptor afd = assetManager.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSound(){
        return mSound;
    }


}
