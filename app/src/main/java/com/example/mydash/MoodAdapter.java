package com.example.mydash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MoodAdapter extends ArrayAdapter<Mood> {

    //constructor for moods
    public MoodAdapter(Context ctx, List<Mood> moods){
        super(ctx, 0, moods);
    }

    //display info on fragment


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
