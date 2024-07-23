package dev.cb.students.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/")
public class HomePageController {

    public HomePageController() {
    }

    @GetMapping("/")
    public String home() {
        return "/homePage";
    }

    @GetMapping("/teapot")
    public String teapot() {
        if (true) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        } else {
            return "/homePage";
        }
    }
}
