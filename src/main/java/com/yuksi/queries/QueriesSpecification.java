package com.yuksi.queries;

/**
 * Created by Yuksi on 15.09.2017.
 */
public interface QueriesSpecification {
    String GET_ALL_CLIENTS = "SELECT * FROM CLIENTS";

    String GET_ALL_ACCOUNTS = "SELECT * FROM ACCOUNTS";
    String GET_ACCOUNTS_BY_CLIENT = "SELECT account_id, client_id, sum FROM ACCOUNTS WHERE client_id=";

    String GET_ALL_TRANSACTIONS = "SELECT transaction_id, sender_acc_id, getter_acc_id, amount, " +
                                    "DATE_FORMAT(add_date, '%Y-%m-%d %T') add_date FROM TRANSACTIONS";
    String GET_TRANSACTIONS_BY_ACCOUNT = "SELECT transaction_id, sender_acc_id, getter_acc_id, amount, " +
                                            "DATE_FORMAT(add_date, '%Y-%m-%d %T') add_date FROM TRANSACTIONS " +
                                            "WHERE sender_acc_id=%1$s OR getter_acc_id=%1$s";
    String GET_TRANSACTIONS_BY_CLIENT_ID =
            "SELECT TRANSACTIONS.transaction_id, TRANSACTIONS.sender_acc_id, TRANSACTIONS.getter_acc_id, " +
                    "TRANSACTIONS.amount, DATE_FORMAT(TRANSACTIONS.add_date, '%Y-%m-%d %T') add_date " +
            "FROM TRANSACTIONS, ACCOUNTS " +
            "WHERE ACCOUNTS.client_id=%1$s " +
                    "AND ACCOUNTS.account_id=TRANSACTIONS.sender_acc_id OR ACCOUNTS.account_is=TRANSACTIONS.getter_acc_id";
    String GET_TRANSACTIONS_BY_CLIENT_NAME =
            "SELECT TRANSACTIONS.transaction_id, TRANSACTIONS.sender_acc_id, TRANSACTIONS.getter_acc_id, " +
                    "TRANSACTIONS.amount, DATE_FORMAT(TRANSACTIONS.add_date, '%Y-%m-%d %T') add_date " +
                    "FROM TRANSACTIONS, ACCOUNTS, CLIENTS " +
                    "WHERE CLIENTS.name=%1$s " +
                    "AND CLIENTS.client_id=ACCOUNTS.client_id " +
                    "AND ACCOUNTS.account_id=TRANSACTIONS.sender_acc_id OR ACCOUNTS.account_is=TRANSACTIONS.getter_acc_id";
    String GET_TRANSACTIONS_BY_PERIOD =
            "SELECT transaction_id, sender_acc_id, getter_acc_id, amount, DATE_FORMAT(add_date, '%Y-%m-%d %T') add_date " +
            "FROM TRANSACTIONS WHERE add_date BETWEEN %1$s AND %2$s";

}
