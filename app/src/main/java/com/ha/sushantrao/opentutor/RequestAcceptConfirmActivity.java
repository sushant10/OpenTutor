package com.ha.sushantrao.opentutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import info.hoang8f.widget.FButton;

public class RequestAcceptConfirmActivity extends AppCompatActivity {
    TextView message;
    TextView name;
    TextView cr;
    CircleImageView dp;
    FButton acceptb;
    FButton declineb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_accept_confirm);
        Bundle extras = getIntent().getExtras();

        dp= (CircleImageView) findViewById(R.id.imageDp);
        name= (TextView) findViewById(R.id.textName);
        cr= (TextView) findViewById(R.id.reqClass);
        acceptb= (FButton) findViewById(R.id.acceptButton);
        declineb= (FButton) findViewById(R.id.declineButton);

        

        cr.setText("Requested :" + extras.getString("requested"));
        dp.setImageResource(extras.getInt("profile image"));
        name.setText(extras.getString("name"));


    }
}
