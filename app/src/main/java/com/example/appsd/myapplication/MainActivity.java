package com.example.appsd.myapplication;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;
public class MainActivity extends Activity {

    private final String htmlText = "<body><h1>Heading Text</h1><p>This tutorial " +
            "explains how to display " +
            "<strong>HTML </strong>text in android text view.&nbsp;</p>" +
            "<img src=\"hughjackman.jpg\">" +
            "<blockquote>Example from <a href=\"www.javatechig.com\">" +
            "Javatechig.com<a></blockquote></body>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView htmlTextView = (TextView) findViewById(R.id.html_text);
        htmlTextView.setText(Html.fromHtml(htmlText, new ImageGetter(), null));

    }

    private class ImageGetter implements Html.ImageGetter {

        public Drawable getDrawable(String source) {
            int id;
            if (source.equals("hughjackman.jpg")) {
                id = R.drawable.screenshot;
            } else {
                return null;
            }

            Drawable d = getResources().getDrawable(id);
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            return d;
        }
    }

    ;

}