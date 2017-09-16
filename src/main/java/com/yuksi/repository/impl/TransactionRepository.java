package com.yuksi.repository.impl;

import com.yuksi.entities.Transaction;
import com.yuksi.queries.QueriesRepository;
import com.yuksi.repository.IRepository;
import com.yuksi.specifications.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yuksi on 15.09.2017.
 */

@Repository
public class TransactionRepository implements IRepository<Transaction> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Transaction> mapper = new RowMapper<Transaction>() {
        @Override
        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transaction account = new Transaction();
            account.setId(rs.getLong("transaction_id"));
            account.setSenderAcc(rs.getInt("sender_acc_id"));
            account.setGetterAcc(rs.getInt("getter_acc_id"));
            account.setAmount(rs.getDouble("amount"));
            account.setAddDate(rs.getString("add_date"));
            return account;
        }
    };

    public boolean add(Transaction item) {
        String query = QueriesRepository.INSERT_TRANSACTION;
        int out = jdbcTemplate.update(query,
                item.getSenderAcc(),
                item.getGetterAcc(),
                item.getAmount()
        );
        return out != 0;
    }

    public boolean update(Transaction item) {
        String query = QueriesRepository.UPDATE_TRANSACTION;
        int out = jdbcTemplate.update(query,
                item.getSenderAcc(),
                item.getGetterAcc(),
                item.getAmount(),
                item.getId()
        );
        return out != 0;
    }

    public boolean remove(Transaction item) {
        String query = QueriesRepository.DELETE_TRANSACTION;
        int out = jdbcTemplate.update(query,
                item.getId()
        );
        return out != 0;
    }

    @Override
    public Transaction getById(int transaction_id) {
        String query = QueriesRepository.GET_TRANSACTION_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{transaction_id}, mapper);
    }

    @Override
    public List<Transaction> query(Specification specification) {
        return jdbcTemplate.query(specification.toSqlQuery(), mapper);
    }
}
