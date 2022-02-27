package com.example.account.service;


import com.example.account.dto.request.StoreRequest;
import com.example.account.dto.request.UserRequest;
import com.example.account.dto.response.UserResponse;
import com.example.account.model.User;
import com.example.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public UserResponse add(UserRequest request){
            User user = new User();
            user.setUsername(request.username);
            user.setPassword(request.password);
            return userModelToUserResponseDto(repository.save(user));
    }

    public List<UserResponse> get(){
        return userModelListToUserResponseList(repository.findAll());
    }

    public UserResponse userModelToUserResponseDto(User user){
        UserResponse response = new UserResponse();
        response.username = user.getUsername();
        RestTemplate restTemplate = new RestTemplate();
        String restUrl = "http://ec2-54-82-174-195.compute-1.amazonaws.com:9011/store/store/get";
        StoreRequest storeRequest = new StoreRequest();
        storeRequest.username = user.getUsername();
        response.storeName = restTemplate.postForObject(restUrl, storeRequest, String.class);
        return response;
    }

    public List<UserResponse> userModelListToUserResponseList(List<User> users){
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user:users){
            userResponseList.add(userModelToUserResponseDto(user));
        }

        return userResponseList;
    }
}
