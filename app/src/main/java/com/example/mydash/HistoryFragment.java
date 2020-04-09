package com.example.mydash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mydash.database.DBManager;
import com.example.mydash.database.Database;
import com.example.mydash.database.Mood;
import com.example.mydash.mooddash.MoodAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private ListView listHistory;
    DBManager dbManager;
    List<Mood> moods;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager=new DBManager(getContext());
        moods= Database.getMoods(dbManager.getWritableDatabase());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_history, container, false);
        listHistory=fragmentView.findViewById(R.id.moodHistory);
        listHistory.setAdapter(new MoodAdapter(getContext(),moods));
        //reverse entries


        // Inflate the layout for this fragment
        return fragmentView;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position!=1)return;
        moods=Database.getMoods(dbManager.getWritableDatabase());
        listHistory=getView().findViewById(R.id.moodHistory);
        listHistory.setAdapter(new MoodAdapter(getContext(),moods));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
