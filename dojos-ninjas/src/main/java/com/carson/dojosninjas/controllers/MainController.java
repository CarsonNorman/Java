package com.carson.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carson.dojosninjas.models.Dojo;
import com.carson.dojosninjas.models.Ninja;
import com.carson.dojosninjas.services.DojoService;
import com.carson.dojosninjas.services.NinjaService;

@Controller
public class MainController {
    @Autowired DojoService dojoService;
    @Autowired NinjaService ninjaService;


    @RequestMapping(value={"/dojos/new", "/"})
    public String index(@ModelAttribute("dojo")Dojo dojo, Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "dojos/new.jsp";
    }

    @PostMapping(value = {"/dojos"})
    public String createDojo(@ModelAttribute("dojo")Dojo dojo){
        System.out.println(dojo.getName());
        dojoService.create(dojo);
        return "redirect:/";
    }

    @RequestMapping(value={"/ninjas/new"})
    public String ninjaForm(@ModelAttribute("ninja")Ninja ninja, Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "ninjas/new.jsp";
    }

    @PostMapping(value = {"/ninjas"})
    public String createNinja(@ModelAttribute("ninja")Ninja ninja){
        ninjaService.create(ninja);
        return "redirect:/";
    }

    @GetMapping(value={"/dojos/show/{id}"})
    public String dojo(@PathVariable("id")Long id, Model model){
        Dojo dojo = dojoService.oneDojo(id);
        model.addAttribute("dojo", dojo);
        return "dojos/viewOne.jsp";
    }
}
