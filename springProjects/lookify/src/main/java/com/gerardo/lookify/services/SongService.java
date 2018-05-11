package com.gerardo.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.lookify.models.Song;
import com.gerardo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private SongRepository repository;
	
	public SongService (SongRepository repository) {
		this.repository = repository;
	}
	
	public List<Song> getAllSongs() {
		return repository.findAll();
	}
	
	public void addSong (Song e) {
		repository.save(e);
	}
}
