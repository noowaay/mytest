package com.example;

import org.springframework.data.repository.CrudRepository;

import com.example.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

}