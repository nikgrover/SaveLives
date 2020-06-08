package com.example.savelives;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewsAndAnnouncements extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter aAdapter;

    private String[] news = {"Montreal-area daycares are set to reopen June 1.",
            "Outdoor pools, splash pads, playgrounds and washrooms can now reopen.",
            "Montreal's state of emergency has been extended to June 4."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_and_announcements);
        mListView = (ListView) findViewById(R.id.newslist);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, news);
        mListView.setAdapter(aAdapter);
    }






}
