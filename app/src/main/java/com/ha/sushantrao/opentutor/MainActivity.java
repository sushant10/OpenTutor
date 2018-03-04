package com.ha.sushantrao.opentutor;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar abar = getSupportActionBar();//line under the action bar
        View viewActionBar = getLayoutInflater().inflate(R.layout.action_bar_custom, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.mytext);
        textviewTitle.setText("OpenTutor");
        abar.setCustomView(viewActionBar,params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
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
