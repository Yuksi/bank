package com.yuksi.controllers;

import com.yuksi.entities.Account;
import com.yuksi.entities.Client;
import com.yuksi.entities.Transaction;
import com.yuksi.services.IAccountService;
import com.yuksi.services.IClientService;
import com.yuksi.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yuksi on 14.09.2017.
 */

@Controller
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ITransactionService transactionService;

    @RequestMapping(value = "/")
    public String startPage() {
        return "startpage";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String clients(Model model) {
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public String transactions(Model model) {
        List<Transaction> transactions = transactionService.getAll();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String accounts(Model model) {
        List<Account> accounts = accountService.getAll();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @RequestMapping(value = "/add-client", method = RequestMethod.GET)
    public String addClient() {
        return "add-client";
    }
    @ModelAttribute("client")
    public Client newClient() {
        return new Client();
    }
    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client client) {
        clientService.add(client);
        return "redirect:clients";
    }

    @RequestMapping(value = "/clients/{id}/accounts", method = RequestMethod.GET)
    public String getClientAccounts(@PathVariable("id") int id, Model model) {
        List<Account> accounts = accountService.getAllByClient(id);
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @RequestMapping(value = "/clients/{id}/add-account", method = RequestMethod.GET)
    public String addAccount() {
        return "add-account";
    }
    @ModelAttribute("account")
    public Account newAccount() {
        return new Account();
    }
    @RequestMapping(value = "/clients/{id}/accounts", method = RequestMethod.POST)
    public String addAccount(@ModelAttribute("account") Account account, @PathVariable("id") int id) {
        account.setClient(id);
        accountService.add(account);
        return "redirect:accounts";
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
