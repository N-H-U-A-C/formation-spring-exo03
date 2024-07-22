package dev.cb.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    public HomePageController() {}

    @GetMapping("/")
    public String home() {
        return "/homePage";
    }
}
