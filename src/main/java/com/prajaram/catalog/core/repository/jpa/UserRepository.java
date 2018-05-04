package com.mcd.catalog.core.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.mcd.catalog.core.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
}
