package com.example.beatbox.sounds;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

public class BeatBox {
    public static final String TAG = "BeatBox";
    public static final String SOUND_FOLDER = "sample_sounds";

    private AssetManager assetManager;
    public BeatBox (Context context){
        assetManager = context.getAssets();
        loadSounds();
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

    }
}
