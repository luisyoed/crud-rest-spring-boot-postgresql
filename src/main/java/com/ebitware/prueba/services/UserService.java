package com.ebitware.prueba.services;

import java.util.List;
import java.util.Map;

import com.ebitware.prueba.vo.UserDeleteRequestVo;
import com.ebitware.prueba.vo.UserRquestVO;
import com.ebitware.prueba.vo.UserUpdateRquestVO;
import com.ebitware.prueba.vo.UserVO;

public interface UserService {

	UserVO findUserId(Long id);

	UserVO saveUser(UserRquestVO user);

	List<UserVO> findUser();

	UserVO saveUserUpdate(UserUpdateRquestVO user);

	Map<String, String> deleteUserUpdate(UserDeleteRequestVo user);

}
