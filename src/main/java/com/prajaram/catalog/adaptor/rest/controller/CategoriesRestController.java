package com.mcd.catalog.adaptor.rest.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcd.catalog.core.entity.User;
import com.mcd.catalog.core.service.BaseService;

@RestController
public class CategoriesRestController extends BaseRestController {
	
	@Autowired
	private BaseService baseService;
	
	@Autowired
	private EntityManager entityManager;
	
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	@PostMapping(path="/user")
	public String sayHello( @RequestBody User user){
		System.out.println(entityManager.isOpen());
		return "Registered "+getBaseService().saveUser(user).getId();
	}
	
	@GetMapping(path="/user/{userId}")
	public String sayHello( @PathVariable("userId") int userId){
		System.out.println(entityManager.isOpen());
		return "Hello "+getBaseService().getUser(userId).getName();
	}

}
