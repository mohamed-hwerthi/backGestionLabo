package com.example.GestionLabo.testJava;



public class Cutomer {
    private int customId ;
    private String customname ;
    private  String coursename  ;

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public static void main(String[] args) {
        System.out.println("customer class is working well");
    }
}
