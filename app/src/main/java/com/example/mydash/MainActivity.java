package com.example.mydash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
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


        //notifications
        notificationManager = NotificationManagerCompat.from(this);

    }
    public void showNotification(View v){
        RemoteViews collapsedNotification = new RemoteViews(getPackageName(),
                R.layout.notification_collapsed);
        RemoteViews expandedNotification = new RemoteViews(getPackageName(),
                R.layout.notification_expanded);

        Notification notifi = new NotificationCompat.Builder(this, NotificationChannels.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_content)
                .setCustomContentView(collapsedNotification)
                .setCustomBigContentView(expandedNotification)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build();

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Intent.ACTION_MAIN);
        notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent openPending = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        notificationManager.notify(1,notifi);

    }

}


