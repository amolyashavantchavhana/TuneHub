package com.example.demo.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.UserEntity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer>
{

	

}
