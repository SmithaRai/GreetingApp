package com.bridgelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String fName;
    private String lName;

    public User() {

    }


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

}
