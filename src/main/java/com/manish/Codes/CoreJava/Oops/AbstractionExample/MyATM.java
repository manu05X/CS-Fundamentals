package com.manish.Codes.CoreJava.Oops.AbstractionExample;

class MyATM extends ATM {
    @Override
    void withdrawMoney() {
        System.out.println("Money withdrawn.");
    }

    @Override
    void checkBalance() {
        System.out.println("Balance checked.");
    }
}
