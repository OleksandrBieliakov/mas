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

    @GetMapping("/booked")
    String getBooked(Model model) {
        model.addAttribute("title", "Booked appointments");
        model.addAttribute("description", "Booked appointments list. You can proceed to booking an appointment with patient fom here.");
        return "booked";
    }

    @GetMapping("/available-search")
    String getAvailableSearch(Model model) {
        model.addAttribute("title", "Appointment time slots search");
        model.addAttribute("description", "Select needed parameters to search for available time slots. Or create a new time slot.");
        model.addAttribute("subtitle", "Available appointment time slots search parameters");
        return "available-search";
    }

    @GetMapping("/available")
    String getAvailable(Model model) {
        model.addAttribute("title", "Available appointment time slots");
        model.addAttribute("description", "Select a suitable appointment time slot to book an appointment with patient and/or to edit appointment details.");
        return "available";
    }

    @GetMapping("/editing")
    String getEditing(Model model) {
        model.addAttribute("title", "Appointment editing");
        model.addAttribute("description", "Edit appointment status, type, time, staff, room, equipment and medicine supply. Appoint patient. Click parameters you want to edit.");
        model.addAttribute("parameterSubtitle", "Parameter");
        model.addAttribute("patientSubtitle", "Patient");
        return "editing";
    }
}
