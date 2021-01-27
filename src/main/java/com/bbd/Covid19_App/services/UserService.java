package com.bbd.Covid19_App.services;

import com.bbd.Covid19_App.dao.UserRepository;
import com.bbd.Covid19_App.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUserId(Integer id){
        return userRepository.findByUserId(id);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void deleteByUserId(Integer userId) {
        userRepository.deleteByUserId(userId);
    }

    public List<User> searchForUsers(String name, String surname, String login, String role, Boolean enabled) {
        return userRepository.findByNameAndSurnameAndLoginAndRoleAndEnabledOrderByUserIdAsc(name, surname, login, role, enabled);
    }
}
