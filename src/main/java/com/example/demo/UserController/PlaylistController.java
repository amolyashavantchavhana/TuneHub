package com.example.demo.UserController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.UserEntity.Playlist;
import com.example.demo.UserEntity.Song;
import com.example.demo.UserService.PlaylistService;
import com.example.demo.UserService.SongService;

@Controller
public class PlaylistController
{

	
	
	
	@Autowired
	SongService ss;
	
	@Autowired
	PlaylistService ps;
	
@GetMapping("createplaylist")
public String createplaylist(Model model)
{

  List<Song>songlist=ss.fetchallSongs();
	model.addAttribute("songs",songlist);
	return"createplaylist";
}

@PostMapping("addPlaylist")
public String addPlaylist(@ModelAttribute Playlist playlist)
{
	
	ps.addPlaylist(playlist);             //updating playlist table
	List<Song>songlist=playlist.getSongs();
	for(Song s:songlist)
	{
		s.getPlaylist().add(playlist);
		
		  ss.updateSong(s);                //updating song object in database
		
	}
	
	return"Adminhome";

}
@GetMapping("viewplaylist")
public String viewplaylist(Model model)
{
	List<Playlist>ListPlaylists=ps.fetchallplaylist();
	model.addAttribute("allPlaylists",ListPlaylists);
	return "displayplaylist";
}

}

