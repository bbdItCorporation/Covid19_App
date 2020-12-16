package com.bbd.Covid19_App.dao;


import com.bbd.Covid19_App.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer> {

    public User save(User user);

    public User findByUserId(Integer id);

    public User findByLogin(String login);
}
