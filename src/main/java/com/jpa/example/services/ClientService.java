package com.jpa.example.services;

import com.jpa.example.Dao.ClientDaoImp;
import com.jpa.example.Dao.IClient;
import com.jpa.example.models.Client;

import java.util.List;

public class ClientService {
    private IClient iclient;
    public ClientService(){
        iclient = new ClientDaoImp();
    }
    public boolean saveClient(Client client){
        return iclient.save(client);
    }
    public Client findClientById(Long id){
        return iclient.findById(id);
    }
    public List<Client> findAllClient(){
        return iclient.findAll();
    }
}
