package com.example.timetablemanager;

public class goalstatus {

    private String Tasktobeper;
    private String Time;
    private String Taskdesc;


    public goalstatus(String tasktobeper, String time, String taskdesc) {
        Tasktobeper = tasktobeper;
        Time = time;
        Taskdesc = taskdesc;
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
}
