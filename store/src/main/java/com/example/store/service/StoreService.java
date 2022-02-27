package com.example.store.service;


import com.example.store.dto.request.StoreRequest;
import com.example.store.model.Store;
import com.example.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    StoreRepository repository;

    public String get(StoreRequest request){
        return add(request.username);
    }

    public String add(String username){
        Store store = new Store();
        store.setUsername(username);
        store.setStoreName(username + "'s Store");
        repository.save(store);
        return store.getStoreName();
    }
}
