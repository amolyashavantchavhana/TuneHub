package com.example.demo.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.UserEntity.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	public User findByEmail(String email);

	
	

}
