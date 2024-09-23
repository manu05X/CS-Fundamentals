package com.manish.Codes.CoreJava.Oops.AbstractionExample;

//Think of an ATM machine.
// You interact with it to withdraw money,
// check your balance, etc.,
// without needing to know how it processes
// transactions internally.
abstract class ATM {
    abstract void withdrawMoney();

    abstract void checkBalance();
}
