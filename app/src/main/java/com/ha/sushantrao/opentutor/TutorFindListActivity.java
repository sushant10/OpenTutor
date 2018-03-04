package com.ha.sushantrao.opentutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class TutorFindListActivity extends AppCompatActivity {

    int[] tutorImages;
    ListView tutorList;
    String[] tutorNames;
    String[] rating;

    int index[];
    List<String> majors;
    List<String> CS ;
    List<String> Math;
    List<String> ECE;
    List<String> PH;
    List<String> BC;
    Map<String,List<String>> classes;

    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_find_list);

        //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tutorImages = new int[]{R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4, R.drawable.avatar5, R.drawable.avatar6};
        tutorNames = new String[]{"Sushant Rao","Rohan Nanda","Shubham Batra","Sharath Ramkumar","Harriet Smith","Catherine Walsh"};
        tutorList = (ListView) findViewById(R.id.tutor_list);
        rating = new String[]{"5.0","4.5","3.2","1.5","4.2","4.6"};

        majors = new LinkedList<>(Arrays.asList("Computer Science", "Mathematics", "Computer Engineering", "Public Health", "Biochemistry", "Public Health"));
        CS = new LinkedList<>(Arrays.asList("121", "187", "250", "311", "383"));
        Math = new LinkedList<>(Arrays.asList("131", "132", "233", "235", "311"));
        ECE = new LinkedList<>(Arrays.asList("112", "122", "211", "212", "331"));
        PH = new LinkedList<>(Arrays.asList("100", "156", "264", "330", "420"));
        BC = new LinkedList<>(Arrays.asList("151", "152", "250", "342", "545"));

        classes = new HashMap<String, List<String>>();

        classes.put("Computer Science",CS);
        classes.put("Mathematics",Math);
        classes.put("Computer Engineering",ECE);
        classes.put("Public Health",PH);
        classes.put("Biochemistry",BC);

       // Bundle extras = getIntent().getExtras();
       // index= extras.getIntArray("major and class");

        /*TextView a = (TextView) findViewById(R.id.test);
        a.setText(majors.get(index[0]));*/
        tutorList = (ListView) findViewById(R.id.tutor_list);
        CustomAdapter customAdapter = new CustomAdapter();
        tutorList.setAdapter(customAdapter);

        tutorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TutorFindListActivity.this, TutorFindListActivity.class);
                intent.putExtra("name",tutorNames[(int)tutorList.getSelectedItemId()]);
                intent.putExtra("major",majors.get((int)tutorList.getSelectedItemId()));
                intent.putExtra("rating",rating[(int)tutorList.getSelectedItemId()]);
                intent.putExtra("profile image", tutorImages[(int)tutorList.getSelectedItemId()]);

                startActivity(intent);
            }
        });

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


            View view=getLayoutInflater().inflate(R.layout.customtutorlist_layout, null);
            CircleImageView dp = (CircleImageView) view.findViewById(R.id.imagePerson);
            TextView nameTutor= (TextView) view.findViewById(R.id.textName);
            TextView tutorMajor = (TextView) view.findViewById(R.id.textMajor);
            ImageView ratingImage= (ImageView) view.findViewById(R.id.imageRating);
            TextView tutorRating= (TextView) view.findViewById(R.id.textRating);

            dp.setImageResource(tutorImages[position]);
            ratingImage.setImageResource(R.drawable.rating);
            nameTutor.setText(tutorNames[position]);
            tutorMajor.setText((String)majors.get(position));
            tutorRating.setText(rating[position]);

            return view;
        }
    }


}
