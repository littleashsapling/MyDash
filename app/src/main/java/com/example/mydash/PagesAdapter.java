package com.example.mydash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mydash.mooddash.AddMood;

public class PagesAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    private ViewPager vPage;
    private AddMood moodPage;
    private HistoryFragment h;
    private SettingsFragment settings;
    public PagesAdapter (FragmentManager fm, int numOfTabs,ViewPager vPage){
        super(fm);
        this.numOfTabs = numOfTabs;
        this.vPage = vPage;
        moodPage = new AddMood();
        h = new HistoryFragment();
        settings= new SettingsFragment();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return moodPage;
            case 1:
                vPage.addOnPageChangeListener(h);
                return h;
            case 2:
                return settings;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Dash";
            case 1:
                return "History";
            case 2:
                return "Settings";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
