package com.bridgelabz.greetingapp.Controller;

import com.bridgelabz.greetingapp.Service.GreetingService;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
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
        return new ResponseEntity<String>(greetingService.getMessage(),HttpStatus.OK);
    }
    @GetMapping("/getGreetingMessage")
    public ResponseEntity<String>getGreetingMessage(@RequestParam(value="fName",defaultValue="World") String fName,@RequestParam(value="lName",defaultValue="") String lName){
        return new ResponseEntity<String>(greetingService.getGreetingMessage(fName,lName),HttpStatus.OK);
    }
    @PostMapping("/postGreeting")
    public ResponseEntity<String> getGreeting(@RequestBody User user){
        return new ResponseEntity<String>(greetingService.postMessage(user.getfName(),user.getlName()),HttpStatus.OK);
    }
}
