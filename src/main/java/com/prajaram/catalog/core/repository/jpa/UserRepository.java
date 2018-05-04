package com.prajaram.catalog.core.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.prajaram.catalog.core.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
}
