package com.obielaikov.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    String index() {
        return "redirect:/appointments/booked";
    }
}
