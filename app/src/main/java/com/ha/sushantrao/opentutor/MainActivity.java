package com.ha.sushantrao.opentutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FButton fTutor= (FButton) findViewById(R.id.findtutor);
        fTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FindtutorActivity.class));
            }
        });
        FButton frequest= (FButton) findViewById(R.id.requestTutor);
        frequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TutorRequestActivity.class));
            }
        });
    }

}
