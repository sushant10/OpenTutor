package com.ha.sushantrao.opentutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileConfirmActivity extends AppCompatActivity {

    TextView description;
    TextView name;
    TextView textrating;
    CircleImageView profiledp;
    ImageView ratingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_confirm);
        Bundle extras = getIntent().getExtras();

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
