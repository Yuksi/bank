package com.yuksi.specifications.impl;

import com.yuksi.queries.QueriesSpecification;
import com.yuksi.specifications.Specification;

/**
 * Created by Yuksi on 15.09.2017.
 */
public class TransactionsByAccount implements Specification {

    private int account;

    public TransactionsByAccount(int account) {
        this.account = account;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.GET_TRANSACTIONS_BY_ACCOUNT,
                account
        );
    }
}
