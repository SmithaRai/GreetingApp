package com.bridgelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue
    private long id;
    private String content;

    public Greeting(Long id, String content) {
        super();
        this.id = id;
        this.content = content;
    }

    public Greeting(String content) {
        this.content =content;
    }
    public Greeting(Greeting greeting) {
        this.id =greeting.id;
        this.content =greeting.content;
    }

    public Greeting(Integer id, String format) {

    }


    public String getContent() {
        return content;
    }


}
