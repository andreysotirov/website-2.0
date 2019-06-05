package com.andreysotirov.website.controllers;

import com.andreysotirov.website.entity.Expense;
import com.andreysotirov.website.entity.Patient;
import com.andreysotirov.website.service.ServiceExpense;
import com.andreysotirov.website.service.ServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private ServicePatient servicePatient;
    @Autowired
    private ServiceExpense serviceExpense;

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
}
