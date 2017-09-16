package com.yuksi.repository.impl;

import com.yuksi.entities.Client;
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
 * Created by Yuksi on 14.09.2017.
 */

@Repository
public class ClientRepository implements IRepository<Client> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Client> mapper = new RowMapper<Client>() {
        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client client = new Client();
            client.setId(rs.getInt("client_id"));
            client.setName(rs.getString("name"));
            client.setAddress(rs.getString("address"));
            client.setAge(rs.getInt("age"));
            return client;
        }
    };

    public boolean add(Client item) {
        String query = QueriesRepository.INSERT_CLIENT;
        int out = jdbcTemplate.update(query,
                item.getName(),
                item.getAddress(),
                item.getAge()
        );
        return out != 0;
    }

    public boolean update(Client item) {
        String query = QueriesRepository.UPDATE_CLIENT;
        int out = jdbcTemplate.update(query,
                item.getName(),
                item.getAddress(),
                item.getAge(),
                item.getId()
        );
        return out != 0;
    }

    public boolean remove(Client item) {
        String query = QueriesRepository.DELETE_CLIENT;
        int out = jdbcTemplate.update(query,
                item.getId()
        );
        return out != 0;
    }

    @Override
    public Client getById(int client_id) {
        String query = QueriesRepository.GET_CLIENT_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{client_id}, mapper);
    }

    @Override
    public List<Client> query(Specification specification) {
       return jdbcTemplate.query(specification.toSqlQuery(), mapper);
    }
}
