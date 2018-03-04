package com.ha.sushantrao.opentutor;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;
import info.hoang8f.widget.FButton;

public class ProfileConfirmActivity extends AppCompatActivity {

    TextView description;
    TextView name;
    TextView textrating;
    CircleImageView profiledp;
    ImageView ratingImage;
    FButton request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_confirm);
        Bundle extras = getIntent().getExtras();

        final ActionBar abar = getSupportActionBar();//line under the action bar
        View viewActionBar = getLayoutInflater().inflate(R.layout.action_bar_custom, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.mytext);
        textviewTitle.setText("Tutor Profile");
        abar.setCustomView(viewActionBar,params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);

        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String major= extras.getString("major");
        String namepr= extras.getString("name");
        String rating= extras.getString("rating");
        int dp= extras.getInt("profile image");

        description = (TextView) findViewById(R.id.textDescription);
        name = (TextView) findViewById(R.id.textName);
        textrating= (TextView) findViewById(R.id.textRating);
        profiledp = (CircleImageView) findViewById(R.id.imageDp);
        ratingImage = (ImageView) findViewById(R.id.imageRating);
        request = (FButton) findViewById(R.id.request);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request.setButtonColor(Color.rgb(0,200,0));
                request.setText("Request sent!");
            }
        });
        name.setText(namepr);
        description.setText("I am a student at UMass Amherst who has a passion for tutoring in "+major);
        profiledp.setImageResource(dp);
        ratingImage.setImageResource(R.drawable.rating);
        textrating.setText(rating);

       /* TextView a = (TextView) findViewById(R.id.test);
        a.setText(extras.getString("name"));*/
    }

    //on back button clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
