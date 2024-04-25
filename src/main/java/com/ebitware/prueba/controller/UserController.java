package com.ebitware.prueba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebitware.prueba.services.impl.UserServiceImpl;
import com.ebitware.prueba.vo.UserDeleteRequestVo;
import com.ebitware.prueba.vo.UserRquestVO;
import com.ebitware.prueba.vo.UserUpdateRquestVO;
import com.ebitware.prueba.vo.UserVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path =  "api/user")
@Slf4j
public class UserController {
	
	@Autowired
	public UserServiceImpl userServiceImpl;

	@GetMapping("")
	public ResponseEntity<UserVO> getUser(@RequestParam Long id)  {
		log.info("Id: {}", id);
		return ResponseEntity.ok(userServiceImpl.findUserId(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserVO>> getUserAll() {
		return ResponseEntity.ok(userServiceImpl.findUser());
	}
	
	@PostMapping("")
	public  ResponseEntity<UserVO> setUser(@Valid @RequestBody UserRquestVO user) {
		log.info("Resquest: {}", user);
		return ResponseEntity.ok(userServiceImpl.saveUser(user));
	
	}
	
	@PutMapping("")
	public  ResponseEntity<UserVO> updateUser(@Valid @RequestBody UserUpdateRquestVO user) {
		log.info("Resquest: {}", user);
		return ResponseEntity.ok(userServiceImpl.saveUserUpdate(user));
	}
	
	@DeleteMapping("")
	public  ResponseEntity<Map<String, String>> deleteUser(@Valid @RequestBody UserDeleteRequestVo user) {
		log.info("Resquest: {}", user);
		return ResponseEntity.ok(userServiceImpl.deleteUserUpdate(user));
	}
	

}
