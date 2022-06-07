package com.softuni.bankAccount;

public class BankAccount {
    private int id;
    private static int accountsCount = 0;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountsCount() {
        return accountsCount;
    }

    public void setAccountsCount(int accountsCount) {
        this.accountsCount = accountsCount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double money) {
        this.balance += money;
    }

    public double getInterest(int years) {
        return interestRate * years * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
}
