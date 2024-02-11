package spring_HW4.sem41.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloWorkcontroller {
    @RequestMapping("/hello")
    public String hello() {
        return "helloWork.html";
    }
}
