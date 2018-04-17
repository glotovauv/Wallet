package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/wallet")
public class ControllerWallet {
    @Autowired
    private Wallet wallet;

    @RequestMapping("/")
    @ResponseBody
    String welcome() {
        return "Добро пожаловать!";
    }

    @RequestMapping("/status")
    @ResponseBody
    String getStatus() {
        return wallet.showBalance();
    }

    @RequestMapping(value = "/cash/{count}", method = RequestMethod.PUT)
    @ResponseBody
    String putMoney(@PathVariable int count) {
        wallet.putMoney(count);
        return "На счет положено " + count + " руб.";
    }

    @RequestMapping(value = "/cash", method = RequestMethod.PUT)
    @ResponseBody
    String putMoneyByParam(@PathParam("count") int count) {
        wallet.putMoney(count);
        return "На счет положено " + count + " руб.";
    }

    @RequestMapping(value = "/cash/{count}", method = RequestMethod.GET)
    @ResponseBody
    String getMoney(@PathVariable int count) {
        boolean enoughMoney = wallet.getMoney(count);
        if (!enoughMoney) {
            return "На Вашем счету недостаточно средств!";
        }
        return "С Вашего счета снято " + count + " руб.";
    }
}
