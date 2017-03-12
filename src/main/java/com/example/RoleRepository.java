package com.example;

import org.springframework.data.repository.CrudRepository;

import com.example.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);

}
