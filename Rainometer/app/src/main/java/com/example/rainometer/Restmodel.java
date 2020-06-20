package com.example.rainometer;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Restmodel{
    int rain;
    @SerializedName("enterytime")
    String date1;




    public int getRain() {
        return rain;
    }

    public String getDate1() {
        return date1;
    }
}

