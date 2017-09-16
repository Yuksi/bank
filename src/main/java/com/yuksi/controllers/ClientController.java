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

}
