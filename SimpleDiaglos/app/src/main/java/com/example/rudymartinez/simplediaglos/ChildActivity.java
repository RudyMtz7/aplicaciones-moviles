package com.example.rudymartinez.simplediaglos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Intent targetIntent;
        targetIntent = getIntent();
        String myText;
        myText = targetIntent.getStringExtra("myData");
        TextView myTextView;
        myTextView = (TextView)findViewById(R.id.textView2);
        myTextView.setText(myText);
    }
}
