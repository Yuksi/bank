package com.yuksi.services.impl;

import com.yuksi.entities.Account;
import com.yuksi.repository.impl.AccountRepository;
import com.yuksi.services.IAccountService;
import com.yuksi.specifications.impl.AccountsByClientSpecification;
import com.yuksi.specifications.impl.AllAccountsSpecification;
import com.yuksi.specifications.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuksi on 15.09.2017.
 */

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean add(Account account) {
        return accountRepository.add(account);
    }

    @Override
    public Account getById(int id) {
        return accountRepository.getById(id);
    }

    @Override
    public List<Account> getAll() {
        Specification specification = new AllAccountsSpecification();
        return accountRepository.query(specification);
    }

    @Override
    public List<Account> getAllByClient(int client) {
        Specification specification = new AccountsByClientSpecification(client);
        return accountRepository.query(specification);
    }
}
