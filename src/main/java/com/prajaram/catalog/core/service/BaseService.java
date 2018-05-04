package com.mcd.catalog.core.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcd.catalog.core.entity.User;
import com.mcd.catalog.core.repository.jpa.UserRepository;

@Service
public class BaseService {

	@Autowired
	private UserRepository userRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public User getUser(int userId) {
		return getUserRepository().findOne(userId);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public User saveUser(User user) {
		User user1= getUserRepository().save(user);
		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		return user1;
	}
}
