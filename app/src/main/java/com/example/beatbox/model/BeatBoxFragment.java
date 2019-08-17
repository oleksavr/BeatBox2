package com.example.beatbox.model;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beatbox.R;
import com.example.beatbox.databinding.FragmentBeatBoxBinding;

public class BeatBoxFragment extends Fragment {

    public static BeatBoxFragment newInstance(){
        return new BeatBoxFragment();

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBeatBoxBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_beat_box,container,false);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        return binding.getRoot();
    }
}
