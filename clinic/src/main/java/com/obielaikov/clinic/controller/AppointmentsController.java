package com.obielaikov.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("title", "Clinic appointments");
    }

    @GetMapping("/available")
    String getAvailable(Model model) {
        model.addAttribute("subtitle", "Available appointments");
        model.addAttribute("description", "Select a suitable appointment time slot...");
        model.addAttribute("hello", "Another world");
        return "available";
    }
    @GetMapping("/booked")
    String getBooked(Model model) {
        model.addAttribute("subtitle", "Booked appointments");
        model.addAttribute("description", "Booked appointments list");
        model.addAttribute("hello", "world");
        return "booked";
    }
}
