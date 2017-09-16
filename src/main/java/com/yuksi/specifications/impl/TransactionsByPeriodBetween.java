package com.yuksi.specifications.impl;

import com.yuksi.queries.QueriesSpecification;
import com.yuksi.specifications.Specification;

/**
 * Created by Yuksi on 16.09.2017.
 */
public class TransactionsByPeriodBetween implements Specification {
    private String start;
    private String end;

    public TransactionsByPeriodBetween(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.GET_TRANSACTIONS_BY_PERIOD,
                start, end
        );
    }
}
