package com.ha.sushantrao.opentutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class TutorRequestActivity extends AppCompatActivity {

    int[] tutorImages;
    String[] names;
    String[] requested_class;
    ListView rList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_request);
        tutorImages = new int[]{R.drawable.request_avatar1, R.drawable.request_avatar2, R.drawable.request_avatar3};
        names = new String[]{"Samuel Riessmann", "Darcy Malone", "Jessica Savarese"};
        requested_class = new String[]{"Math 132", "Computer Science 121", "Physics 152"};

        rList = (ListView) findViewById(R.id.requestList);
        CustomAdapter customAdapter = new CustomAdapter();
        rList.setAdapter(customAdapter);

        rList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(TutorRequestActivity.this, ProfileConfirmActivity.class);
                intent.putExtra("name",names[position]);
                intent.putExtra("requested",requested_class[position]);
                intent.putExtra("profile image", tutorImages[position]);

                startActivity(intent);
            }


        });
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

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return tutorImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {


            View view=getLayoutInflater().inflate(R.layout.custom_requestlist, null);
            CircleImageView dp = (CircleImageView) view.findViewById(R.id.imagePerson);
            TextView name= (TextView) view.findViewById(R.id.textName);
            TextView rc = (TextView) view.findViewById(R.id.textClasses);

            dp.setImageResource(tutorImages[position]);
            name.setText(names[position]);
            rc.setText(requested_class[position]);


            return view;
        }
    }
}
