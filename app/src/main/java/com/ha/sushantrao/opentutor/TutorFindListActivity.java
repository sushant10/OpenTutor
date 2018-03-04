package com.ha.sushantrao.opentutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TutorFindListActivity extends AppCompatActivity {

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

        majors = new LinkedList<>(Arrays.asList("Computer Science", "Mathematics", "Computer Engineering", "Public Health", "Biochemistry"));
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

        Bundle extras = getIntent().getExtras();
        index= extras.getIntArray("major and class");

        /*TextView a = (TextView) findViewById(R.id.test);
        a.setText(majors.get(index[0]));*/



    }

    //on back button clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
