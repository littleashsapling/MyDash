package com.example.mydash.mooddash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mydash.R;
import com.example.mydash.database.Mood;

import java.util.List;

public class MoodAdapter extends ArrayAdapter<Mood> {

    //constructor for moods
    public MoodAdapter(Context ctx, List<Mood> moods) {
        super(ctx, 0, moods);
    }

    //display info on fragment


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mood, parent, false);
        }
        convertView.setBackgroundResource(getItem(position).getColor());

        ImageView moodView = convertView.findViewById(R.id.moodView);
        moodView.setImageResource(getItem(position).getIcon());

        TextView moodContent = convertView.findViewById(R.id.mood);
        moodContent.setText(getItem(position).mood);

        TextView notesContent = convertView.findViewById(R.id.notes);
        notesContent.setText(getItem(position).notes);

        TextView dateContent = convertView.findViewById(R.id.date);
        dateContent.setText(getItem(position).dateToString());
        return convertView;
    }
}

