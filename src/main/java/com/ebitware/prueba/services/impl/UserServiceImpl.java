package com.ebitware.prueba.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebitware.prueba.entities.UsersEntity;
import com.ebitware.prueba.repositories.UserRepository;
import com.ebitware.prueba.services.UserService;
import com.ebitware.prueba.vo.UserDeleteRequestVo;
import com.ebitware.prueba.vo.UserRquestVO;
import com.ebitware.prueba.vo.UserUpdateRquestVO;
import com.ebitware.prueba.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserVO findUserId(Long id) {
		Optional<UsersEntity> user = null;
		try {
			user = userRepository.findById(id);
		} catch (Exception e) {
			throw new NoSuchElementException(e);
		}

		log.info("Response: {}", user);
		return mapperUser(user.get());

	}

	@Override
	public List<UserVO> findUser() {
		List<UsersEntity> user = userRepository.findAll();
		log.info("Response: {}", user);
		return mapperUserAll(user);

	}

	@Override
	public UserVO saveUser(UserRquestVO user) {
		UsersEntity result = userRepository.save(mapperUser(user));
		return mapperUser(result);
	}

	@Override
	public UserVO saveUserUpdate(UserUpdateRquestVO user) {
		UsersEntity result = null;
		try {
			Optional<UsersEntity> userExist = userRepository.findById(user.getUserId());
			if (userExist.isPresent()) {
				result = userRepository.save(mapperUser(user));
			}
		} catch (Exception e) {
			throw new NullPointerException();
		}

		return mapperUser(result);
	}

	@Override
	public Map<String, String> deleteUserUpdate(UserDeleteRequestVo user) {
		Map<String, String> response =  new HashMap<>();
		try {
			Optional<UsersEntity> userExist = userRepository.findById(user.getUserId());
			log.info("userExist: {}", userExist.get());
			if (!userExist.isEmpty()) {
				userRepository.updateUserStatus(user.getUserId(), user.getStatus());
			}
		} catch (Exception e) {
			throw new NullPointerException();
		}
		response.put("messages", "Successful");
		return  response ;
	}

	private UserVO mapperUser(UsersEntity user) {
		return UserVO.builder().userId(user.getUserId()).name(user.getName()).lastName(user.getLastName())
				.age(user.getAge()).status(user.getStatus()).build();
	}

	private UsersEntity mapperUser(UserUpdateRquestVO user) {
		return UsersEntity.builder().userId(user.getUserId()).name(user.getName()).lastName(user.getLastName())
				.age(user.getAge()).status(user.getStatus()).build();
	}

	private UsersEntity mapperUser(UserRquestVO user) {
		return UsersEntity.builder().name(user.getName()).lastName(user.getLastName()).age(user.getAge()).status(true)
				.build();

	}

	private List<UserVO> mapperUserAll(List<UsersEntity> user) {
		List<UserVO> result = new ArrayList<>();
		user.stream().forEach(x -> {
			result.add(mapperUser(x));
		});
		return result;
	}

}
