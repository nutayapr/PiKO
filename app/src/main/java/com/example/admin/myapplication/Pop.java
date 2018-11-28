package com.example.admin.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Map;

import static com.example.admin.myapplication.R.layout.add_schedule;

class Pop extends Activity {

    String day;
    Button addbtn, cancelbtn;
    EditText startTime, endTime, activity;
    FirebaseDatabase database;
    DatabaseReference ref;
    StudentSchedule studentSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_schedule);

        /// Pop up
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));


        /// Select day(spinner)
        String[] week = getResources().getStringArray(R.array.sche_weekday);
        Spinner day_spin = (Spinner) findViewById(R.id.fill_day);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, week);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day_spin.setAdapter(adapter);
        day_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                day = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        /// Add schedule
        studentSchedule = new StudentSchedule();
        addbtn = (Button) findViewById(R.id.btnadd);
        cancelbtn = (Button) findViewById(R.id.btncancel);
        startTime = (EditText) findViewById(R.id.fill_startTime);
        endTime = (EditText) findViewById(R.id.fill_endTime);
        activity = (EditText) findViewById(R.id.fill_acti);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference();
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSchedule(day,startTime.getText().toString(),endTime.getText().toString(),activity.getText().toString());
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Object> updateSchedule = (Map<String, Object>) dataSnapshot.getValue();
                        Log.i("Pop","updateSchedule ="+ updateSchedule.toString());
                        Toast.makeText(Pop.this,"New schedule added...",Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.i("Pop","onCancelled");
                    }
                });
            }
        });


    }


//    private void getValue(){
//        studentSchedule.setDay(day.getText().toString());
//        studentSchedule.setStartTime(startTime.getText().toString());
//        studentSchedule.setEndTime(endTime.getText().toString());
//        studentSchedule.setActivity(activity.getText().toString());
//    }


    public void addNewSchedule(String day,String startTime,String endTime,String activity) {
        StudentSchedule studentSchedule = new StudentSchedule(day, startTime, endTime, activity);
        ref.child(studentSchedule.day).setValue(studentSchedule);
    }
}