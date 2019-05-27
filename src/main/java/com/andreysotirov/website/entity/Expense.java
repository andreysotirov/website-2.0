package com.andreysotirov.website.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expenseId;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "expense_direction")
    private String expenseDirection;

    @Column(name = "expense_description")
    private String expenseDescription;

    @Column(name = "expense_price")
    private double expensePrice;

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExpenseDirection() {
        return expenseDirection;
    }

    public void setExpenseDirection(String expenseDirection) {
        this.expenseDirection = expenseDirection;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public double getExpensePrice() {
        return expensePrice;
    }

    public void setExpensePrice(double expensePrice) {
        this.expensePrice = expensePrice;
    }
}
