package com.learn.JWTAuth.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.learn.JWTAuth.Entity.UserInfo;
import com.learn.JWTAuth.Service.UserService;
import com.learn.JWTAuth.repository.UserInfoRepository;

@Service
public class UserDetailsImpl implements UserService {

	@Autowired
	private UserInfoRepository userRepository;

	@Override
	public UserInfo loadUserByUsername(String username) {
		UserInfo user = userRepository.findByUserName(username);

		return user;
	}

	@Override
	public UserInfo addNewUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userRepository.save(userInfo);
	}

	@Override
	public List<UserInfo> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
}
