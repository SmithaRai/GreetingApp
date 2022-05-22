package com.bridgelabz.greetingapp.model;

public class Greeting {
    private Long id;
    private String content;

    public Greeting(Long id, String content) {
        super();
        this.id = id;
        this.content = content;
    }


    public String getContent() {
        return content;
    }


}
