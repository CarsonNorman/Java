package com.carson.droutes.controllers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
        @RequestMapping("/travel/{place}")
        public String travel(@PathVariable String place) {
                return "Congratulations! You will soon travel to " + place;
        }
        @RequestMapping("/lotto/{num}")
        public String lotto(@PathVariable int num) {
                if(num % 2 == 0){
                    return "You will take a grand journey in the near future, but be weary of tempting offers";
                }
                return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        }
}