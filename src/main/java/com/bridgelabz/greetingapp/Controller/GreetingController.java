package com.bridgelabz.greetingapp.Controller;

import com.bridgelabz.greetingapp.Service.GreetingService;
import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {
    private static final String template="Hello %s";
    private static AtomicLong counter=new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @GetMapping("/get")
    public Greeting greeting(@RequestParam (value="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    @PostMapping("/post")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getContent()));
    }
    @PutMapping("/put/{counter}")
    public Greeting sayHello(@PathVariable long counter,@RequestParam (value="content") String content) {
        return new Greeting(counter,String.format(template, content));
    }
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }
}
