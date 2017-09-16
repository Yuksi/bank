package com.yuksi.services;

import com.yuksi.entities.Account;
import com.yuksi.entities.Client;

import java.util.List;

/**
 * Created by Yuksi on 15.09.2017.
 */
public interface IAccountService {
    boolean add(Account account);
    Account getById(int id);
    List<Account> getAll();
    List<Account> getAllByClient(int id);
}
