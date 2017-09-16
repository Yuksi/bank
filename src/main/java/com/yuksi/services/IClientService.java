package com.yuksi.services;

import com.yuksi.entities.Client;

import java.util.List;

/**
 * Created by Yuksi on 14.09.2017.
 */
public interface IClientService {
    boolean add(Client client);
    Client getById(int id);
    List<Client> getAll();
}
