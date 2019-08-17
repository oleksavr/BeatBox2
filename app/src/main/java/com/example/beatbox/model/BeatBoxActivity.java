package com.example.beatbox.model;

import android.support.v4.app.Fragment;

import com.example.beatbox.SingleFragmentActivity;

public class BeatBoxActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
