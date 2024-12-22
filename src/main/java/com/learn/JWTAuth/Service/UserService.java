package com.learn.JWTAuth.Service;



import java.util.List;

import com.learn.JWTAuth.Entity.UserInfo;

public interface UserService {

	UserInfo loadUserByUsername(String username) ;

	UserInfo addNewUser(UserInfo userInfo);
	
	List<UserInfo> getAllUsers();

}
