package com.example.account.controller;

import com.example.account.dto.request.UserRequest;
import com.example.account.dto.response.UserResponse;
import com.example.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> add(@RequestBody UserRequest request){
            UserResponse response = service.add(request);
            return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> get(){
        List<UserResponse> response = service.get();
        return ResponseEntity.ok(response);
    }
}
