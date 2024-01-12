package com.example.demo.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserEntity.User;
import com.example.demo.UserRepository.UserRepository;

@Service
public class UserServiceImplementation implements UserService
{ 
	@Autowired
	UserRepository ur;

	public String addUser(User user) 
	{
		ur.save(user);
		return "User Added successfully";
	}

	@Override
	public boolean emailExists(String email) {
	 if(ur.findByEmail(email)== null)
	 {
		 return false; 
	 }
	 else
	 {
		 return true;
	 }
		
	}

	@Override
	public boolean loginUser(String Email, String password)
	{
	User user=ur.findByEmail(Email);
	String db_pass=user.getPassword();
	if(password.equals(db_pass))
	{

		return true;
	}
	else
	{

		return false;
	}
	}

	@Override
	public String getRole(String Email) {
		User user=ur.findByEmail(Email);
		return user.getRole();
	}

	@Override
	public User getUser(String email) {

		return ur.findByEmail(email);
	}

	@Override
	public void updateUser(User users) {
		ur.save(users);
		
	}

	

	

	

	
	
	

}
