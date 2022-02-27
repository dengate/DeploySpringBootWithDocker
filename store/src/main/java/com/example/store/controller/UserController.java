package com.example.store.controller;

import com.example.store.dto.request.StoreRequest;
import com.example.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/store")
public class UserController {

    @Autowired
    StoreService service;

    @PostMapping("/get")
    public ResponseEntity<String> get(@RequestBody StoreRequest request){
        return ResponseEntity.ok(service.get(request));
    }
}
