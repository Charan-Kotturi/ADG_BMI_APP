package com.example.basic;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Utils {

    private static ArrayList<String> str;

    private static ArrayList<Plan> plans;

    static boolean addPlan(Plan plan) {
        if(null == plans) {
            plans = new ArrayList<>();
        }
        return plans.add(plan);
    }

    static boolean addString(String string) {
        if(null == str) {
            str = new ArrayList<>();
        }

        return str.add(string);
    }

    public static ArrayList<String> getStr() {
        return str;
    }


}
