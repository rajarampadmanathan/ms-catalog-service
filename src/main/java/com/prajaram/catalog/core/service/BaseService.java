package com.prajaram.catalog.core.service;

import javax.annotation.Resource;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prajaram.catalog.core.entity.User;
import com.prajaram.catalog.core.repository.jpa.UserRepository;

@Service
public class BaseService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

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
		rabbitTemplate.setExchange("test-exchange");
		MessageProperties mp=new MessageProperties();
		Message m=new Message(user1.toString().getBytes(), mp);
		rabbitTemplate.send("test-key", m);
		kafkaTemplate.send("test", user1.toString());
		return user1;
	}
}
