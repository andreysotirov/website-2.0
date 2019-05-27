package com.andreysotirov.website.service;

import com.andreysotirov.website.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface ServiceExpense {

    List<Expense> findAll();

    Optional<Expense> findById(int id);

    void save(Expense expense);

    void deleteById(int id);

    Double getExpense();

    Double getMonthlyExpense();

}
