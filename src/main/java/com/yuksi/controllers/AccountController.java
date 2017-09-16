package com.yuksi.controllers;

import com.yuksi.entities.Account;
import com.yuksi.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Yuksi on 16.09.2017.
 */
@Controller
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String accounts(Model model) {
        List<Account> accounts = accountService.getAll();
        model.addAttribute("accounts", accounts);
        return "accounts";
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
}
