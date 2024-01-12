package com.example.demo.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserEntity.Song;
import com.example.demo.UserRepository.SongRepository;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
	SongRepository sr;

	@Override
	public void addSong(Song song) 
	{
	sr.save(song);
	
		
	}

	@Override
	public List<Song> fetchallSongs() {
		return sr.findAll();
		
	}

	@Override
	public boolean songExists(String name) {
	Song song =sr.findByName(name);
	if(song==null)
	{
		return false;
	}
	else
	{
		return true;
	}
	}

	@Override
	public void updateSong(Song song) {
	sr.save(song);
		
	}

	
	
	
}
