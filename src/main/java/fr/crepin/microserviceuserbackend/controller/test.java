package fr.crepin.microserviceuserbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "${front.url}")
public class test {

    @PostMapping
    public String test(){
        try{
            return "test";
        }catch (Exception e){
            return "ddd";
        }
    }
}
