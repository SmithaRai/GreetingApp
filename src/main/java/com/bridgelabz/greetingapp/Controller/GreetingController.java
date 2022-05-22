package com.bridgelabz.greetingapp.Controller;

import com.bridgelabz.greetingapp.Service.GreetingService;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/getGreetingMessage")
    public ResponseEntity<String>getGreetingMessage(@RequestParam(value="fName",defaultValue="World") String fName,@RequestParam(value="lName",defaultValue="") String lName){
        return new ResponseEntity<>(greetingService.getGreetingMessage(fName,lName),HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<String> getGreeting(@RequestBody User user){
        return new ResponseEntity<>(greetingService.postMessage(user),HttpStatus.OK);
    }
    @PostMapping("/saveGreeting")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting){
        return new ResponseEntity<>(greetingService.saveMessage(greeting),HttpStatus.OK);
    }

    @GetMapping("/findGreeting")
    public ResponseEntity<String> findGreeting(@RequestParam Integer id){
        return new ResponseEntity<String>(greetingService.getData(id),HttpStatus.OK);
    }

    @GetMapping("/findAllGreeting")
    public ResponseEntity<List<Greeting>> findAllGreeting(){
        return new ResponseEntity<List<Greeting>>(greetingService.getAllData(),HttpStatus.OK);
    }
    @PutMapping("/editGreetingById/{id}")
    public ResponseEntity<Greeting> editGreeting(@RequestParam String content,@PathVariable Integer id){
        return new ResponseEntity<Greeting>(greetingService.editData(id,content),HttpStatus.OK);
    }
}
