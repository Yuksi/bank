package com.yuksi.services.impl;

import com.yuksi.entities.Account;
import com.yuksi.entities.Client;
import com.yuksi.entities.Transaction;
import com.yuksi.repository.impl.AccountRepository;
import com.yuksi.repository.impl.TransactionRepository;
import com.yuksi.services.ITransactionService;
import com.yuksi.specifications.impl.*;
import com.yuksi.specifications.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuksi on 15.09.2017.
 */

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public boolean add(Transaction transaction) {
        double amountNewTr = transaction.getAmount();
        Account sender = accountRepository.getById(transaction.getSenderAcc());
        Account getter = accountRepository.getById(transaction.getGetterAcc());
        sender.setSum(sender.getSum() - amountNewTr);
        getter.setSum(getter.getSum() + amountNewTr);
        accountRepository.update(sender);
        accountRepository.update(getter);
        return transactionRepository.add(transaction);
    }

    @Override
    public Transaction getById(int id) {
        return transactionRepository.getById(id);
    }

    @Override
    public List<Transaction> getAll() {
        Specification specification = new AllTransactionsSpecification();
        return transactionRepository.query(specification);
    }

    @Override
    public List<Transaction> getAllByAccountId(int account) {
        Specification specification = new TransactionsByAccount(account);
        return transactionRepository.query(specification);
    }

    @Override
    public List<Transaction> getAllByClientId(int client) {
        Specification specification = new TransactionsByClientId(client);
        return transactionRepository.query(specification);
    }

    @Override
    public List<Transaction> getAllByClientName(String name) {
        Specification specification = new TransactionsByClientName(name);
        return transactionRepository.query(specification);
    }

    @Override
    public List<Transaction> getAllByPeriodBetween(String start, String end) {
        Specification specification = new TransactionsByPeriodBetween(start, end);
        return transactionRepository.query(specification);
    }

}
