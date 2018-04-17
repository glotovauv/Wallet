package com.example.wallet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("B")
@Component
public class WalletB implements Wallet {
    private int balance;

    @Override
    public String showBalance() {
        return "Ваш баланс на кошельке B: " + balance + " руб.";
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
