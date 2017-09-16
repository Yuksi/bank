package com.yuksi.specifications.impl;

import com.yuksi.queries.QueriesSpecification;
import com.yuksi.specifications.Specification;

/**
 * Created by Yuksi on 15.09.2017.
 */
public class AccountsByClientSpecification implements Specification {

    private int client;

    public AccountsByClientSpecification(int client) {
        this.client = client;
    }

    @Override
    public String toSqlQuery() {
        String query = QueriesSpecification.GET_ACCOUNTS_BY_CLIENT + client;
        return query;
    }
}
