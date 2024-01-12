package com.example.demo.UserService;

import com.example.demo.UserEntity.User;

public interface UserService 
{
String addUser(User user);

public boolean emailExists(String email);
public boolean loginUser(String Email,String password);
public String getRole(String Email);
public User getUser(String email);
public void updateUser(User users);



}
