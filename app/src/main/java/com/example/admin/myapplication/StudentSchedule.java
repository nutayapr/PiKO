package com.example.admin.myapplication;

import android.widget.Spinner;

public class StudentSchedule {
    public String day;
    public String startTime;
    public String endTime;
    public String activity;

    public StudentSchedule(){

    }

    public StudentSchedule(String day, String startTime, String endTime, String activity) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
    }

//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public String getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(String endTime) {
//        this.endTime = endTime;
//    }
//
//    public String getActivity() {
//        return activity;
//    }
//
//    public void setActivity(String activity) {
//        this.activity = activity;
//    }


}
