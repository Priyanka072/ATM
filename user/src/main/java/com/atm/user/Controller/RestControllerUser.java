package com.atm.user.Controller;

import com.atm.user.Model.User;
import com.atm.user.Repository.UserRepository;
import com.atm.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class RestControllerUser {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/api/register")
    public String register( @RequestBody User user) {

        List<User> users = userRepository.findAll();
        System.out.println("New User -> " + user);

        for (User u: users) {
            if (user.equals(u)) {
                System.out.println("User already exists!");
                return "USER_ALREADY_EXISTS";
            }
        }

        userRepository.save(user);
        return "SUCCESS";

    }

    @PostMapping("/api/login")
    public String login( @RequestBody User user) {

        List<User> users = userRepository.findAll();

        for (User u: users) {
            if (u.equals(user)) {
                return user.getUserName();
            }
        }

        return "FAILURE";

    }

    @GetMapping("/{id}")
    public User findUserByid(@PathVariable("id") Long id){
        return userService.findUserByid(id);
    }
    }
