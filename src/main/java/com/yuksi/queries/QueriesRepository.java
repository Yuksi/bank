package com.yuksi.queries;

/**
 * Created by Yuksi on 14.09.2017.
 */
public interface QueriesRepository {
    String INSERT_CLIENT = "INSERT INTO CLIENTS(name, address, age) values(?,?,?)";
    String UPDATE_CLIENT = "UPDATE CLIENTS SET name=?, address=?, age=? WHERE client_id=?";
    String DELETE_CLIENT = "DELETE FROM CLIENTS WHERE client_id=?";
    String GET_CLIENT_BY_ID = "SELECT * FROM CLIENTS WHERE client_id=?";

    String INSERT_ACCOUNT = "INSERT INTO ACCOUNTS(client_id, sum) values(?,?)";
    String UPDATE_ACCOUNT = "UPDATE ACCOUNTS SET client_id=?, sum=? WHERE account_id=?";
    String DELETE_ACCOUNT = "DELETE FROM ACCOUNTS WHERE account_id=?";
    String GET_ACCOUNT_BY_ID = "SELECT * FROM ACCOUNTS WHERE account_id=?";

    String INSERT_TRANSACTION = "INSERT INTO TRANSACTIONS(sender_acc_id, getter_acc_id, amount, add_date) values(?,?,?,now())";
    String UPDATE_TRANSACTION = "UPDATE TRANSACTIONS SET sender_acc_id=?, getter_acc_id=?, amount=? add_date=now() " +
                                    "WHERE transaction_id=?";
    String DELETE_TRANSACTION = "DELETE FROM TRANSACTIONS WHERE transaction_id=?";
    String GET_TRANSACTION_BY_ID = "SELECT transaction_id, sender_acc_id, getter_acc_id, amount, " +
            "DATE_FORMAT(add_time, '%Y-%m-%d %T') add_date " +
            "FROM TRANSACTIONS WHERE transaction_id=?";

}
