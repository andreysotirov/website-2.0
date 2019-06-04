package com.andreysotirov.website.controller;

import com.andreysotirov.website.entity.Patient;
import com.andreysotirov.website.service.ServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private ServicePatient servicePatient;

    @GetMapping("/dashboard/add-patient")
    public String addPatient(Model model) {
        Patient patient = new Patient();

        model.addAttribute("patient", patient);

        return "add-patient";
    }

    @PostMapping("/dashboard/add-patient")
    public String addPatient(@ModelAttribute("patient") Patient patient) {

        servicePatient.save(patient);

        return "redirect:/dashboard";
    }
    @GetMapping("/delete-patient")
    public String deletePatient(@RequestParam("id") int id) {
        servicePatient.deleteById(id);

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard/update-patient")
    public String updatePatient(@RequestParam("id") int id, Model model) {
        //Look at optional isPresent()
        Patient patientEntity = null;

        Optional<Patient> optionalEntity = servicePatient.findById(id);
        if (optionalEntity.isPresent()) {

            patientEntity = optionalEntity.get();

        }

        model.addAttribute("patient", patientEntity);

        return "add-patient";
    }
}
