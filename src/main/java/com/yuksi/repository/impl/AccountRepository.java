package com.yuksi.repository.impl;

import com.yuksi.entities.Account;
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
public class AccountRepository implements IRepository<Account> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Account> mapper = new RowMapper<Account>() {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            account.setClient(rs.getInt("client_id"));
            account.setSum(rs.getInt("sum"));
            return account;
        }
    };

    public boolean add(Account item) {
        String query = QueriesRepository.INSERT_ACCOUNT;
        int out = jdbcTemplate.update(query,
                item.getClient(),
                item.getSum()
        );
        return out != 0;
    }

    public boolean update(Account item) {
        String query = QueriesRepository.UPDATE_ACCOUNT;
        int out = jdbcTemplate.update(query,
                item.getClient(),
                item.getSum(),
                item.getId()
        );
        return out != 0;
    }

    public boolean remove(Account item) {
        String query = QueriesRepository.DELETE_ACCOUNT;
        int out = jdbcTemplate.update(query,
                item.getId()
        );
        return out != 0;
    }

    @Override
    public Account getById(int account_id) {
        String query = QueriesRepository.GET_ACCOUNT_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{account_id}, mapper);
    }

    @Override
    public List<Account> query(Specification specification) {
        return jdbcTemplate.query(specification.toSqlQuery(), mapper);
    }
}
