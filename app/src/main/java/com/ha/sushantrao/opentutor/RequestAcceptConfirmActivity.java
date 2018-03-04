package com.ha.sushantrao.opentutor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
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

        message= (TextView) findViewById(R.id.textMessage);
        dp= (CircleImageView) findViewById(R.id.imageDp);
        name= (TextView) findViewById(R.id.textName);
        cr= (TextView) findViewById(R.id.reqClass);
        acceptb= (FButton) findViewById(R.id.acceptButton);
        declineb= (FButton) findViewById(R.id.declineButton);


        cr.setText("Requested: " + extras.getString("requested"));
        dp.setImageResource(extras.getInt("profile image"));
        name.setText(extras.getString("name"));
        message.setText("Hi! I need help with understanding some concepts in "+extras.getString("requested"));

        acceptb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acceptb.setButtonColor(Color.rgb(0,200,0));
                acceptb.setText("Accepted!");
                RelativeLayout.LayoutParams rel_btn = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                rel_btn.setMarginStart(370);
                rel_btn.topMargin=950;
                rel_btn.width=350;
                acceptb.setLayoutParams(rel_btn);
                declineb.setVisibility(View.GONE);
            }
        });

        declineb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                declineb.setButtonColor(Color.rgb(200,0,0));
                declineb.setText("Declined");
                RelativeLayout.LayoutParams rel_btn = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                rel_btn.setMarginStart(370);
                rel_btn.topMargin=950;
                rel_btn.width=350;
                declineb.setLayoutParams(rel_btn);
                acceptb.setVisibility(View.GONE);
            }
        });

    }
}
