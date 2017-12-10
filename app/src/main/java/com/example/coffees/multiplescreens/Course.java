package com.example.coffees.multiplescreens;

import java.io.Serializable;

/**
 * Created by Coffees on 12/8/2017.
 */

public class Course implements Serializable {
    private String course;

    public Course(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
