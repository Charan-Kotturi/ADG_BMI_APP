package com.example.basic;

import android.os.Parcelable;

public class Plan {
    private String name;

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                '}';
    }
}
