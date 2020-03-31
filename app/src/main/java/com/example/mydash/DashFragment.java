package com.example.mydash;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * A simple {@link Fragment} subclass.
 */
public class DashFragment extends Fragment {

    public DashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_dash, container, false);
        //date stuff
        TextView textView = fragmentView.findViewById(R.id.currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        String currentDateAndTime = sdf.format(new Date());
        textView.setText(currentDateAndTime);

        //buttons
        ImageButton happyButton = fragmentView.findViewById(R.id.happyImageButton);
        ImageButton contentButton = fragmentView.findViewById(R.id.contentImageButton);
        ImageButton sadButton = fragmentView.findViewById(R.id.sadImageButton);

        //comment box
        EditText commentBox = fragmentView.findViewById(R.id.commentBox);

        //submit button
        Button submit = fragmentView.findViewById(R.id.commentSubmit);

        // Inflate the layout for this fragment
        return fragmentView;


    }

}

