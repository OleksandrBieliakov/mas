package com.obielaikov.clinic.controller;

import com.obielaikov.clinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentsController {

    private final AppointmentService appointmentService;

    @GetMapping("/booked")
    String getBooked(Model model) {
        //model.addAttribute("title", "Booked appointments");
        model.addAttribute("description", "Booked appointments list. You can proceed to booking an appointment with patient fom here.");
        model.addAttribute("appointments", appointmentService.listBooked());
        return "booked";
    }

    @GetMapping("/available/search")
    String getAvailableSearch(Model model) {
        model.addAttribute("title", "Appointment time slots search");
        model.addAttribute("description", "Select needed parameters to search for available time slots. Or create a new time slot.");
        model.addAttribute("subtitle", "Available appointment time slots search parameters");
        model.addAttribute("examinationTypes", appointmentService.listAllExaminationTypes());
        model.addAttribute("procedureTypes", appointmentService.listAllProcedureTypes());
        model.addAttribute("doctors", appointmentService.listAllDoctors());
        model.addAttribute("currentTime", ZonedDateTime.now().toLocalDateTime());
        model.addAttribute("maxTime", ZonedDateTime.now().plusYears(1).toLocalDateTime());
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

    // example of how to add attributes to view model by default
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("title", "Clinic appointments");
    }
}
