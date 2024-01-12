package com.example.demo.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.UserEntity.Song;

public interface SongRepository extends JpaRepository <Song,Integer>
{
public Song findByName(String name);
}
