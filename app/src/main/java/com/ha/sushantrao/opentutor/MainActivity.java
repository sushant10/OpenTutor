package com.ha.sushantrao.opentutor;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

import info.hoang8f.widget.FButton;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
        TextView check= (TextView) findViewById(R.id.check) ;

        OkHttpClient client = new OkHttpClient();




            Request request = new Request.Builder()
                    .url("http://198.199.120.24:5000/")
                    .build();
        Response response;
        try {
                response = client.newCall(request).execute();
              check.setText(response.body().string());
            }
            catch (IOException e) {
                check.setText("request");

            }





    }


}
