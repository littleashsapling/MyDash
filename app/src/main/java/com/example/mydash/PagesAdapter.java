package com.example.mydash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagesAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public PagesAdapter (FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new DashFragment();
            case 1:
                return new HistoryFragment();
            case 2:
                return new SettingsFragment();
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
