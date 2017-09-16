package com.yuksi.controllers;

import com.yuksi.entities.Transaction;
import com.yuksi.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Yuksi on 16.09.2017.
 */

@Controller
public class TransactionController {
    @Autowired
    ITransactionService transactionService;

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public String transactions(Model model) {
        List<Transaction> transactions = transactionService.getAll();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    @RequestMapping(value = "/add-transaction", method = RequestMethod.GET)
    public String addTransaction() {
        return "add-transaction";
    }
    @ModelAttribute("transaction")
    public Transaction newTransaction() {
        return new Transaction();
    }
    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public String addTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.add(transaction);
        return "redirect:transactions";
    }
}
