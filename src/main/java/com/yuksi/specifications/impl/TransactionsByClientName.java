package com.yuksi.specifications.impl;

import com.yuksi.queries.QueriesSpecification;
import com.yuksi.specifications.Specification;

/**
 * Created by Yuksi on 16.09.2017.
 */
public class TransactionsByClientName implements Specification {

    private String name;

    public TransactionsByClientName(String name) {
        this.name = name;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.GET_TRANSACTIONS_BY_CLIENT_NAME,
                name
        );
    }
}
