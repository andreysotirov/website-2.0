package com.andreysotirov.website.controller;

import com.andreysotirov.website.entity.Expense;
import com.andreysotirov.website.service.ServiceExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ExpenseController {

    @Autowired
    private ServiceExpense serviceExpense;

    @GetMapping("/delete-expense")
    public String deleteExpense(@RequestParam("id") int id) {
        serviceExpense.deleteById(id);

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
