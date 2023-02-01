package com.atm.user.Service;

import com.atm.user.Model.User;
import com.atm.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User findUserByid(Long id) {

        return userRepository.findUserByid(id);
    }
}
