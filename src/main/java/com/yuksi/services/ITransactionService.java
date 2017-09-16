package com.yuksi.services;

import com.yuksi.entities.Account;
import com.yuksi.entities.Transaction;

import java.util.List;

/**
 * Created by Yuksi on 15.09.2017.
 */
public interface ITransactionService {
    boolean add(Transaction transaction);
    Transaction getById(int id);
    List<Transaction> getAll();
    List<Transaction> getAllByAccountId(int account);
    List<Transaction> getAllByClientId(int client);
    List<Transaction> getAllByClientName(String name);
    List<Transaction> getAllByPeriodBetween(String start, String end);
}
