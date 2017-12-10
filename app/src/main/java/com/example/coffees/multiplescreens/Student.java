package com.example.coffees.multiplescreens;

import java.io.Serializable;

/**
 * Created by Coffees on 12/8/2017.
 */

public class Student implements Serializable {
    private String name;
    private int age;
    private String qualification;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
