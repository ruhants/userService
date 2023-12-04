package com.userService.services;

import java.util.List;

import com.userService.entities.User;

public interface UserService {
	
	User saveUser(User user);
	User getUserByUserId(String id);
	User getUserByUserName(String userName);
	List<User> getAllUsers();
	void deleteById(String id);
	User updateUserById(String id,User updatedUser);
	
	

}
