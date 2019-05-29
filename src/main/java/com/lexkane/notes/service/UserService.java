package com.lexkane.notes.service;

import com.lexkane.notes.dao.UserRepository;
import com.lexkane.notes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByEmail(String email){
        return userRepository.getByEmail(email);
    }

    public boolean checkUser(String email, String pass) {
        List<User> users = userRepository.getAllByEmail(email);
        if (users.size() > 0) {
            if (users.get(0).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public void insertUser(String username, String password, String email) {
        userRepository.insertUser(username, password, email);
    }
}
