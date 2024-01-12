package com.example.demo.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserEntity.Playlist;
import com.example.demo.UserRepository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService 
{

	@Autowired
	PlaylistRepository pr;
	@Override
	public void addPlaylist(Playlist playlist)
	{
		pr.save(playlist);
		
	}
	@Override
	public List<Playlist> fetchallplaylist() {
		
		return pr.findAll();
	}

}
