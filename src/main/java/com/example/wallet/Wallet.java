package com.example.wallet;

public interface Wallet {
    String showBalance();

    void putMoney(int sum);

    boolean getMoney(int sum);
}
