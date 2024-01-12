package com.example.demo.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.UserEntity.Song;
import com.example.demo.UserEntity.User;
import com.example.demo.UserService.SongService;
import com.example.demo.UserService.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{
	
@Autowired
UserService us;
@Autowired
SongService ss;

@PostMapping("register")
public String addUser(@ModelAttribute User user)
{
	boolean userStatus=us.emailExists(user.getEmail());
	if(userStatus==false)
	{
		
		us.addUser(user);
		System.out.println("User Added");
		
	}
	else
	{
		System.out.println("User already exists");
	}
	
	
	return"home";
}
@PostMapping("login")
public String login(@RequestParam("Email")String Email,@RequestParam("password")String password,HttpSession session,Model model)
{
	if(us.loginUser(Email,password)==true)
	{
		String role=us.getRole(Email);
		session.setAttribute("email",Email);
		if(role.equals("Admin"))
		{
			return"Adminhome";
		}
		
		else
		{
			User u=us.getUser(Email);
			if(u.isPremium()==false)
			{
				return"Customerhome";
			}
			else
			{
				List<Song>songslist=ss.fetchallSongs();
				model.addAttribute("songs",songslist);
				return"CustomerPremiumHome";
			}
		}
	}

	else
	{
		return"login";
	}
}

@GetMapping("logout")
public String logout(HttpSession session) 
{
	session.invalidate();
	return"login";
	
    
}




}

	
		
