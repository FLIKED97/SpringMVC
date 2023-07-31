package org.springmvc.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){


        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String  action,
                             Model model){
        double answer;
        if(Objects.equals(action, "plus")){
            answer = a+b;
        } else if(Objects.equals(action, "minus")){
            answer = a-b;
        } else if(Objects.equals(action, "mnog")){
            answer = a*b;
        } else {
            answer = a/(double)b;
        }

        model.addAttribute("answer", answer);
        return "first/calculator";
    }
}
