package com.example.timetablemanager;

public class ModelClass {
    private String textview1;
    private String textview2;
    private String textview3;
    private String linedivider;

    ModelClass(String textview1,String textview2,String textview3,String linedivider){
        this.textview1=textview1;
        this.textview2=textview2;
        this.textview3=textview3;
        this.linedivider=linedivider;
    }

    public String getTextview1(){
        return textview1;
    }
    public String getTextview2(){
        return textview2;
    }
    public String getTextview3(){
        return textview3;
    }
    public String getLinedivider(){
        return linedivider;
    }
}
