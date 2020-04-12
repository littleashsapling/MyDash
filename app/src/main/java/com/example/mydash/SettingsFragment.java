package com.example.mydash;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mydash.database.DBManager;
import com.example.mydash.database.Database;

import static java.lang.Boolean.TRUE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    DBManager dbm;

    public SettingsFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbm = new DBManager(getContext());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_settings, container, false);
        //clear table
        Button clear = fragmentView.findViewById(R.id.clearTable);
        clear.setOnClickListener(clearedTable);

        Button contact = fragmentView.findViewById(R.id.contactUs);
        contact.setOnClickListener(sendEmail);

        return fragmentView;
    }

    private View.OnClickListener clearedTable = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbm.getWritableDatabase();
            Boolean cleared = Database.clearTable(db);
            if (cleared == TRUE) {
                Toast.makeText(getContext(), "Dash Cleared Successfully!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getContext(), "Dash not cleared, please try again.", Toast.LENGTH_LONG).show();
            }


        }
    };


    private View.OnClickListener sendEmail = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "joy.a.l@hotmail.com" });
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "mail body");
            startActivity(emailIntent);
        }
    };
}
