package com.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userService.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	public User findUserByUserName(String userName);

}
