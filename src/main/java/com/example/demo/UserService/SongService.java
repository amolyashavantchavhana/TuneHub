package com.example.demo.UserService;

import java.util.List;

import com.example.demo.UserEntity.Song;

public interface SongService {

	 public void addSong(Song song);

	public List<Song>fetchallSongs();
	public boolean songExists(String name);
	
       public void updateSong(Song song);

}
