package com.ha.sushantrao.opentutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_confirm);
        Bundle extras = getIntent().getExtras();

        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        TextView a = (TextView) findViewById(R.id.test);
        a.setText(extras.getString("name"));
    }

    //on back button clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
