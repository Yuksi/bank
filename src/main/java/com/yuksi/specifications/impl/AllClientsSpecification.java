package com.yuksi.specifications.impl;

import com.yuksi.queries.QueriesSpecification;
import com.yuksi.specifications.Specification;

/**
 * Created by Yuksi on 15.09.2017.
 */
public class AllClientsSpecification implements Specification {

    @Override
    public String toSqlQuery() {
        return QueriesSpecification.GET_ALL_CLIENTS;
    }
}
