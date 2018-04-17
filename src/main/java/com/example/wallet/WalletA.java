package com.example.wallet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("A")
@Component
public class WalletA implements Wallet {
    private int balance;

    @Override
    public String showBalance() {
        return "Ваш баланс на кошельке A: " + balance + " руб.";
    }

    @Override
    public void putMoney(int sum) {
        balance += sum;
    }

    @Override
    public boolean getMoney(int sum) {
        if (sum > balance) {
            return false;
        }
        balance -= sum;
        return true;
    }
}
