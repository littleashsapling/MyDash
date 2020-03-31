package com.example.mydash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabDash = findViewById(R.id.tabDash);
        TabItem tabHistory = findViewById(R.id.tabHistory);
        TabItem tabSettings = findViewById(R.id.tabSettings);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        PagesAdapter pagesAdapter = new PagesAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagesAdapter);
        tabLayout.setupWithViewPager(viewPager);




    }

}


