package com.andreysotirov.website.dao;

import com.andreysotirov.website.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Integer> {

    @Query("SELECT SUM(e.expensePrice) FROM Expense e")
    Double getExpense();

    @Query("select sum (e.expensePrice) from Expense e group by current_date ")
    Double getMonthlyExpense();
}
