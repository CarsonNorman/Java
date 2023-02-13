package com.carson.omikuji_form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;


@Controller
public class OmikujiController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping(value="/handle", method=RequestMethod.POST )
    public String handleFortune(HttpSession session,
    @RequestParam("num") int num ,
    @RequestParam("name") String name, 
    @RequestParam("place") String place,
    @RequestParam("animal") String animal,
    @RequestParam("hobby") String hobby
    ){
        session.setAttribute("num", num);
        session.setAttribute("name", name);
        session.setAttribute("place", place);
        session.setAttribute("animal", animal);
        session.setAttribute("hobby", hobby);
        
        return "redirect:/fortune";
    }

    @RequestMapping("/fortune")
        public String renderFortune(){
            return "fortune.jsp";
        }
}
