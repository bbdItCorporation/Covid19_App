package com.bbd.Covid19_App.dao;


import com.bbd.Covid19_App.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer> {

    User save(User user);

    User findByUserId(Integer id);

    User findByLogin(String login);

    List<User> findAll();

    void deleteByUserId(Integer userId);

    @Query("SELECT u FROM User u WHERE (:name = '' or u.name LIKE %:name%)"
            + " and (:surname = '' or u.surname LIKE %:surname%)"
            + " and (:login = '' or u.login LIKE %:login%)"
            + " and (:role = '' or u.role = :role)"
            + " and (:enabled is null or u.enabled = :enabled)")
    List<User> findByNameAndSurnameAndLoginAndRoleAndEnabledOrderByUserIdAsc(@Param("name") String name,
                                                                            @Param("surname") String surname,
                                                                            @Param("login") String login,
                                                                            @Param("role") String role,
                                                                            @Param("enabled") Boolean enabled);
}
