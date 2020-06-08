package com.example.bookscatalog;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadBookActivity extends AppCompatActivity {

    private TextView title;
    private Chronometer readChronometer;
    private WebView book_web_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_book_view);

        title = findViewById(R.id.book_title);
        readChronometer = findViewById(R.id.read_chronometer);
        Intent intent = getIntent();
        String bookTitle = intent.getExtras().getString("Title");
        String bookWebLink = intent.getExtras().getString("Link");
        title.setText(bookTitle);
        readChronometer.start();
        book_web_page = findViewById(R.id.book_web_page);
        book_web_page.getSettings().setJavaScriptEnabled(true);
        book_web_page.loadUrl(bookWebLink);

        book_web_page.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
    }
}
