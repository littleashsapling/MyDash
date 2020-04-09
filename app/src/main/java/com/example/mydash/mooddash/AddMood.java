package com.example.mydash.mooddash;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydash.R;
import com.example.mydash.database.DBManager;
import com.example.mydash.database.Database;

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
        //buttons

        ImageButton happyButton =fragmentView.findViewById(R.id.happyImageButton);
        happyButton.setOnClickListener(happyClicked);
        ImageButton contentButton = fragmentView.findViewById(R.id.contentImageButton);
        contentButton.setOnClickListener(contentClicked);
        ImageButton sadButton = fragmentView.findViewById(R.id.sadImageButton);
        sadButton.setOnClickListener(sadClicked);

        //date stuff
        TextView textView = fragmentView.findViewById(R.id.currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yy");
        String currentDateAndTime = sdf.format(new Date());
        textView.setText(currentDateAndTime);


        //comment box
        commentBox = fragmentView.findViewById(R.id.commentBox);

        //submit button
        Button submit = fragmentView.findViewById(R.id.commentSubmit);
        submit.setOnClickListener(submitMood);
        //db
        dbm=new DBManager(getContext());

        // Inflate the layout for this fragment
        return fragmentView;


    }

    View.OnClickListener happyClicked= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                moodString="Happy";

        }
    };
    View.OnClickListener contentClicked= new View.OnClickListener(){
        public void onClick(View v) {
            moodString="Content";
        }
    };


    View.OnClickListener sadClicked= new View.OnClickListener(){
        public void onClick(View v) {
            moodString="Sad";
        }
    };

    View.OnClickListener submitMood = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbm.getWritableDatabase();
            long rowInserted= Database.insertRow(db, moodString, commentBox.getText().toString());
            if (rowInserted!=-1){
                Toast.makeText(getContext(), "Mood Recorded Successfully!",Toast.LENGTH_LONG).show();
                commentBox.getText().clear();
            }
            else {
                Toast.makeText(getContext(),"Mood not recorded, please try again.",Toast.LENGTH_LONG).show();
            };

        }
    };

}

