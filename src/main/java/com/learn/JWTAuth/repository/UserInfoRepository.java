package com.learn.JWTAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.JWTAuth.Entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	UserInfo findByUserName(String username);
	
	
}
