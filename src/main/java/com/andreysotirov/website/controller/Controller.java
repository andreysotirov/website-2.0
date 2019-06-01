package com.andreysotirov.website.controller;

import com.andreysotirov.website.entity.Expense;
import com.andreysotirov.website.entity.Patient;
import com.andreysotirov.website.service.ServiceExpense;
import com.andreysotirov.website.service.ServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ServicePatient servicePatient;
    @Autowired
    private ServiceExpense serviceExpense;

    @GetMapping("/home")
    public String homePage() {
        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Patient> patients = servicePatient.findAll();

        model.addAttribute("patients", patients);

        List<Expense> expenses = serviceExpense.findAll();

        model.addAttribute("expense", expenses);

        Double total = servicePatient.getSum();
        model.addAttribute("total", total);

        Double turnover = servicePatient.getTurnover();
        model.addAttribute("turnover", turnover);

        Double totalExpense = serviceExpense.getExpense();
        model.addAttribute("totalExpense", totalExpense);

        Double monthlyExpense = serviceExpense.getMonthlyExpense();
        model.addAttribute("monthlyExpense", monthlyExpense);

        return "dashboard";
    }

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

    @GetMapping("/dashboard/add-expense")
    public String addExpense(Model model) {
        Expense expense = new Expense();

        model.addAttribute("expense", expense);

        return "add-expense";
    }

    @PostMapping("/dashboard/add-expense")
    public String addExpense(@ModelAttribute("expense") Expense expense) {

        serviceExpense.save(expense);

        return "redirect:/dashboard";
    }

    @GetMapping("/delete-patient")
    public String deletePatient(@RequestParam("id") int id) {
        servicePatient.deleteById(id);

        return "redirect:/dashboard";
    }

    @GetMapping("/delete-expense")
    public String deleteExpense(@RequestParam("id") int id) {
        serviceExpense.deleteById(id);

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

    @GetMapping("/dashboard/update-expense")
    public String updateExpense(@RequestParam("id") int id, Model model) {

        Expense expenseEntity = null;

        Optional<Expense> optionalEntity = serviceExpense.findById(id);

        if (optionalEntity.isPresent()) {
            expenseEntity = optionalEntity.get();
        }

        model.addAttribute("expense", expenseEntity);

        return "add-expense";
    }
}
