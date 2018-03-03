package com.ha.sushantrao.opentutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindtutorActivity extends AppCompatActivity {
    int index;

    List<String> majors;
    List<String> CS ;
    List<String> Math;
    List<String> ECE;
    List<String> PH;
    List<String> BC;
    Map<String,List<String>> classes;
    NiceSpinner spinnerMajor;
    NiceSpinner spinnerClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findtutor);

        majors = new LinkedList<>(Arrays.asList("Computer Science", "Mathematics", "Computer Engineering", "Public Health", "Biochemistry"));
        CS = new LinkedList<>(Arrays.asList("121", "187", "250", "311", "383"));
        Math = new LinkedList<>(Arrays.asList("131", "132", "233", "235", "311"));
        ECE = new LinkedList<>(Arrays.asList("112", "122", "211", "212", "331"));
        PH = new LinkedList<>(Arrays.asList("100", "156", "264", "330", "420"));
        BC = new LinkedList<>(Arrays.asList("151", "152", "250", "342", "545"));

        classes = new HashMap<String, List<String>>();
        spinnerMajor = (NiceSpinner) findViewById(R.id.spinnerMajor);
        spinnerClasses = (NiceSpinner) findViewById(R.id.spinnerClass);

        classes.put("Computer Science",CS);
        classes.put("Mathematics",Math);
        classes.put("Computer Engineering",ECE);
        classes.put("Public Health",PH);
        classes.put("Biochemistry",BC);

        spinnerMajor.attachDataSource(majors);
        index=0;
        spinnerMajor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index= i;
                spinnerClasses.attachDataSource(classes.get(majors.get(index)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                index=0;
                spinnerClasses.attachDataSource(classes.get(majors.get(index)));
            }
        });




        //int index = 0;

        spinnerClasses.attachDataSource(classes.get(majors.get(index)));
    }
}
