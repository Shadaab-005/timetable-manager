package com.example.timetablemanager;

public class futuretasks {

    private String Tasktobeper;
    private String Time;
    private String Taskdesc;
    private String Date;


    public futuretasks(String tasktobeper, String time, String taskdesc, String date) {
        Tasktobeper = tasktobeper;
        Time = time;
        Taskdesc = taskdesc;
        Date = date;
    }

    public String getDate() {
        return Date;
    }



    public String getTasktobeper() {
        return Tasktobeper;
    }

    public String getTime() {
        return Time;
    }

    public String getTaskdesc() {
        return Taskdesc;
    }


    public void setTasktobeper(String tasktobeper) {
        Tasktobeper = tasktobeper;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setTaskdesc(String taskdesc) {
        Taskdesc = taskdesc;
    }
    public void setDate(String date) {
        Date = date;
    }
}
