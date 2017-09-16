package com.yuksi.services.impl;

import com.yuksi.entities.Client;
import com.yuksi.repository.impl.ClientRepository;
import com.yuksi.services.IClientService;
import com.yuksi.specifications.impl.AllClientsSpecification;
import com.yuksi.specifications.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuksi on 14.09.2017.
 */

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public boolean add(Client client) {
        return clientRepository.add(client);
    }

    @Override
    public Client getById(int id) {
        return clientRepository.getById(id);
    }

    @Override
    public List<Client> getAll() {
        Specification specification = new AllClientsSpecification();
        return clientRepository.query(specification);
    }
}
