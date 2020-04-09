package com.example.mydash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RemoteViews;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

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

        PagesAdapter pagesAdapter = new PagesAdapter(getSupportFragmentManager(), tabLayout.getTabCount(),viewPager);

        viewPager.setAdapter(pagesAdapter);
        tabLayout.setupWithViewPager(viewPager);;
        //hide keyboard
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

}


