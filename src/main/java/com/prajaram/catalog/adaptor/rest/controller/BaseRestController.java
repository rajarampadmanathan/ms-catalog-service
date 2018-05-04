package com.mcd.catalog.adaptor.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class BaseRestController implements CatalogRestController {

	<T> ResponseEntity<T> sendResponse(T response,MultiValueMap<String, String> headers) {
		ResponseEntity<T> responseEntity = new ResponseEntity<T>(response,headers, HttpStatus.OK);
		return responseEntity;
	}
	
	<T> ResponseEntity<T> sendResponse(T response, HttpStatus status) {
		ResponseEntity<T> responseEntity = new ResponseEntity<T>(response, status);
		return responseEntity;
	}
}
