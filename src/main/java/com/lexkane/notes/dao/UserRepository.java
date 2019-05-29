package com.lexkane.notes.dao;

import com.lexkane.notes.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User getByEmail( String email);

    List<User> getAllByEmail (String email);

    @Modifying
    @Query(value = "insert into user ( username, email, password) values (:username, :email, :password);",
            nativeQuery = true)
    @Transactional
    void insertUser(@Param("username") String username,
                     @Param("email") String email, @Param("password") String password);
    }
