package com.example.admin.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends AppCompatActivity {

    @SuppressLint("CutPasteId")

//    FirebaseDatabase database;
//    DatabaseReference ref;

    private Button b;
//    private ListView listView;
//
//    private ArrayList<String> arrayList = new ArrayList<>();
//    private ArrayAdapter<String> adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        b = (Button) findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Schedule.this, Pop.class));
            }
        });

//        database = FirebaseDatabase.getInstance();
//        ref = database.getReference("testpiko-b5984");
//
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
//        listView = (ListView) findViewById(R.id.listSche);
//
//        listView.setAdapter(adapter);
//
//        ref.addChildEventListener(new ChildEventListener() {
//
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String string = dataSnapshot.getValue(String.class);
//                arrayList.add(string);
//                adapter.notifyDataSetChanged();
//            }
//        });
    }
}

//    private void getSchedule(){
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                setData(dataSnapshot);
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("Schedule","Failed to read value.",error.toException());
//            }
//        });

//
//    ListView list = (ListView) findViewById(R.id.listSche);
//
//    List<List<String>> scheInfo;
//    List<String> temp ;
//    private void setData(DataSnapshot dataSnapshot){
//        scheInfo = new ArrayList<>();
//
//        for (DataSnapshot alert: dataSnapshot.getChildren()) {
//            n = n + 1;
//            while(alert.child("day"+n).exists());
//            temp = new ArrayList<>();
//            Log.d("day", (String) alert.child("day").getValue());
//            Log.d("startTime", (String) alert.child("startTime").getValue());
//            Log.d("endTime", (String) alert.child("endTime").getValue());
//            Log.d("activity", (String) alert.child("activity").getValue());
//            temp.add((String) alert.child("day").getValue());
//            temp.add((String) alert.child("startTime").getValue());
//            temp.add((String) alert.child("endTime").getValue());
//            temp.add((String) alert.child("activity").getValue());
//            scheInfo.add(temp);
//        }
//
//        if(scheInfo.size() > 0){
//            setGridView();
//        }else{
//            Toast.makeText(this, "No data Found.", Toast.LENGTH_SHORT).show();
//        }
//    }



