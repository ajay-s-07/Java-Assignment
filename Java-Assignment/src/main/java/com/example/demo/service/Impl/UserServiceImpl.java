package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.models.User.UserModel;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(UserModel userModel) {
        User user = User.builder()
                .name(userModel.getName())
                .role(userModel.getRole())
                .email(userModel.getEmail())
                .contact_no(userModel.getContact_no())
                .build();
        userRepository.save(user);
    }
}
