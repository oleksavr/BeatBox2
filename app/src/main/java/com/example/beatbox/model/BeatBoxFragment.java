package com.example.beatbox.model;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beatbox.R;
import com.example.beatbox.databinding.FragmentBeatBoxBinding;
import com.example.beatbox.databinding.ListItemSoundBinding;
import com.example.beatbox.sounds.BeatBox;
import com.example.beatbox.sounds.Sound;

import java.util.List;

public class BeatBoxFragment extends Fragment {

    private BeatBox mBeatBox;

    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeatBox = new BeatBox(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentBeatBoxBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_beat_box, container, false);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.recyclerView.setAdapter(new SoundAdapter(mBeatBox.getSound()));

        return binding.getRoot(); //binging
    }

    private class SoundHolder extends RecyclerView.ViewHolder{
        private ListItemSoundBinding mBinding;

        private SoundHolder (ListItemSoundBinding binding){
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewModel(new SoundViewModel(mBeatBox));
        }

        public void bind(Sound sound){
            mBinding.getViewModel().setSound(sound);
            mBinding.executePendingBindings();
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{

        private List<Sound> mSound;

        public SoundAdapter(List<Sound> sounds){
            mSound = sounds;
        }

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ListItemSoundBinding binding = DataBindingUtil
                    .inflate(inflater,R.layout.list_item_sound, parent, false);
            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder holder, int position) {
            Sound sound = mSound.get(position);
            holder.bind(sound);
        }

        @Override
        public int getItemCount() {
            return mSound.size();
        }
    }
}
