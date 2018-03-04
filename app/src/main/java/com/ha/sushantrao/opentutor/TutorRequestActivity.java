package com.ha.sushantrao.opentutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class TutorRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_request);

        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    //on back button clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
