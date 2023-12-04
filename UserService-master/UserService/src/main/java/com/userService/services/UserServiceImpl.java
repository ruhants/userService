package com.userService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.entities.User;
import com.userService.exceptions.UserNotFoundException;
import com.userService.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepo = userRepository;

	}

	@Override
	public User saveUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
	return userRepo.save(user);
	}

	@Override
	public User getUserByUserId(String id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

	}

	@Override
	public User getUserByUserName(String userName) {
		User findUserByUserName=null;
		try {
			findUserByUserName = userRepo.findUserByUserName(userName);
		}
		catch(UserNotFoundException ex) {
			throw new UserNotFoundException("Not found with UserName:"+userName);
		}if(findUserByUserName!=null)
		return findUserByUserName;
		else return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> findAll = userRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(String id) {
      userRepo.deleteById(id);
	}

	@Override
	public User updateUserById(String id,User updatedUser) {
		 User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
         user.setAbout(updatedUser.getAbout());
         user.setEmail(updatedUser.getEmail());
         user.setUserName(updatedUser.getUserName());
         userRepo.save(user);
		return user;
	}

}
