package com.example.demo.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.UserEntity.Song;
import com.example.demo.UserService.SongService;

@Controller
public class SongController 
{

	@Autowired
	SongService ss;
	
	@PostMapping("addSong")
	public String addSong(@ModelAttribute Song song)
	{
		boolean SongStatus=ss.songExists(song.getName());
		if(SongStatus==false)
		{
			
			ss.addSong(song);
			System.out.println("Song Added");
			
		}
		else
		{
			System.out.println("Song already exists");
		}
		
		return"Adminhome";
	}
	
	@GetMapping("viewsong")
	public String viewsong(Model model)
	{
		List<Song>songslist=ss.fetchallSongs();
		model.addAttribute("songs",songslist);
		
		
		return "displaysong";
		
	}

	@GetMapping("playsong")
	public String playsong(Model model)
	{
		boolean  premiumUser=false;
		if(premiumUser==true)
		{
		List<Song>songslist=ss.fetchallSongs();
		model.addAttribute("songs",songslist);
		
		return"displaysong";
		}
		else
		{
			return"makepayment";
		}
		
	}
	
	
	
	
	
}
