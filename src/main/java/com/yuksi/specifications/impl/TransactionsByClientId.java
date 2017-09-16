package com.yuksi.specifications.impl;

import com.yuksi.queries.QueriesSpecification;
import com.yuksi.specifications.Specification;

/**
 * Created by Yuksi on 16.09.2017.
 */
public class TransactionsByClientId implements Specification {

    private int id;

    public TransactionsByClientId(int id) {
        this.id = id;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.GET_TRANSACTIONS_BY_CLIENT_ID,
                id
        );
    }
}
