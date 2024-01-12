package com.example.demo.UserService;

import java.util.List;

import com.example.demo.UserEntity.Playlist;

public interface PlaylistService 
{
public void addPlaylist(Playlist playlist);
 public List<Playlist>fetchallplaylist();

}
