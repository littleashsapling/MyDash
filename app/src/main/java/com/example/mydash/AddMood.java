package com.example.mydash;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
public class AddMood extends Fragment {
private EditText commentBox;
private String moodString;
DBManager dbm;


    public AddMood() {
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
        //db
        dbm=new DBManager(getContext());

        // Inflate the layout for this fragment
        return fragmentView;


    }

    public void happyClicked(View v) {
    moodString="Happy";
    }

    public void contentClicked(View v){
        moodString="Content";
    }

    public void sadClicked(View v){
        moodString="Sad";
    }

    public void submitMood(View view) {
        SQLiteDatabase db = dbm.getWritableDatabase();
        Database.insertRow(db, moodString, commentBox.getText().toString());
    }
}

