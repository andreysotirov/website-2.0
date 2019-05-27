package com.andreysotirov.website.service;

import com.andreysotirov.website.dao.ExpenseRepo;
import com.andreysotirov.website.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceExpenseImpl implements ServiceExpense {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Override
    public List<Expense> findAll() {
        return expenseRepo.findAll();
    }

    //LOOK IF IT IS WORKING THAT WAY!!!! IMPORTANT!!!
    @Override
    public Optional<Expense> findById(int id) {

        return expenseRepo.findById(id);
    }

    @Override
    public void save(Expense expense) {
        Date now = new Date();
        expense.setDate(now);
        expenseRepo.save(expense);
    }

    @Override
    public void deleteById(int id) {
        expenseRepo.deleteById(id);
    }

    @Override
    public Double getExpense() {
        return expenseRepo.getExpense();
    }

    @Override
    public Double getMonthlyExpense() {
        return expenseRepo.getMonthlyExpense();
    }
}
