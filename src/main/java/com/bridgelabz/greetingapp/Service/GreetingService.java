package com.bridgelabz.greetingapp.Service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GreetingService {

    @Autowired
    GreetingRepository repo;
    private static String template="Hello %s";

    public String getMessage() {
        return "Hello World";
    }
    public String getGreetingMessage(String fName, String lName) {
        return "Hello "+fName+""+lName;
    }
    public String postMessage(User user) {
        return "Hello "+user.getfName()+""+user.getlName();
    }
    public Greeting saveMessage(Greeting greeting) {
        Greeting newGreeting=new Greeting(String.format(template,greeting.getContent()));
        repo.save(newGreeting);
        return newGreeting;
    }

    public String getData(Integer id) {
        Greeting newGreeting=repo.getReferenceById();
        return newGreeting.getContent();
    }
    public List<Greeting> getAllData() {
        List<Greeting> list=repo.findAll();
        return list;
    }
}