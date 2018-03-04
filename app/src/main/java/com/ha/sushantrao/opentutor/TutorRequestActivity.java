package com.ha.sushantrao.opentutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class TutorRequestActivity extends AppCompatActivity {

    int[] tutorImages;
    String[] names;
    String[] requested_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_request);
        tutorImages = new int[]{R.drawable.request_avatar1, R.drawable.request_avatar2, R.drawable.request_avatar3};
        names = new String[]{"Samuel Riessmann", "Darcy Malone", "Jessica Savarese"};
        requested_class = new String[]{"Math 132", "Computer Science 121", "Physics 152"};

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
