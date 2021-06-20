package com.obieliakov.clinic.controller;

import com.obieliakov.clinic.model.Appointment;
import com.obieliakov.clinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentsController {

    private final AppointmentService appointmentService;

    @GetMapping("/booked")
    String getBooked(Model model) {
        model.addAttribute("title", "Booked appointments");
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
    String getAvailable(@RequestParam(name = "type", required = false) String type,
                        @RequestParam(name = "doctor", required = false) Long doctorId,
                        @RequestParam(name = "from", required = false) String from,
                        @RequestParam(name = "to", required = false) String to,
                        Model model) {
        model.addAttribute("title", "Available appointment time slots");
        model.addAttribute("description", "Select a suitable appointment time slot to book an appointment with patient. Or create a new time slot.");
        try {
            model.addAttribute("appointments", appointmentService.listAvailable(type, doctorId, from, to));
        } catch (Exception exception) {
            model.addAttribute("appointments", new ArrayList<Appointment>());
        }
        return "available";
    }

    @GetMapping("/{id}/book")
    String getBooking(Model model, @PathVariable Long id) {
        model.addAttribute("title", "Appointment booking");
        model.addAttribute("description", "Select patient for the appointment booking.");
        model.addAttribute("appointment", appointmentService.findById(id));
        model.addAttribute("patients", appointmentService.listAllPatients());
        return "booking";
    }

    @GetMapping("/creation")
    String getCreation(Model model) {
        model.addAttribute("title", "New time slot creation");
        model.addAttribute("description", "Select parameters of a new time slot for an appointment.");
        return "creation";
    }

    // example of how to add attributes to view model by default
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("title", "Clinic appointments");
    }
}
