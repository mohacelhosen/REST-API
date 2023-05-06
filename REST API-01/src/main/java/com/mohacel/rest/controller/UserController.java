package com.mohacel.rest.controller;

import com.mohacel.rest.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/show")
    public ResponseEntity<User> showUser(){
        User user = new User(102,"Mohacel","HTML, CSS, JS, Java");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> showInfo(@RequestParam("name") String name, @RequestParam("id") Integer id, @RequestParam("tech") String tech){
        String[] techStack={"HTML","CSS","JavaScript","Java","Spring Boot"};
        String msg = "Name: "+name+",\nID: "+id+"\n Tech-Stack:"+tech;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/product/{id}/{name}/{price}")
    public ResponseEntity<String> getProduct(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable("price") Double price){
        String resPayload = "Book id: "+id+ "\nBook Name: "+name+"\nBook Price: "+price;
        return  new ResponseEntity<>(resPayload, HttpStatus.OK);
    }
}
