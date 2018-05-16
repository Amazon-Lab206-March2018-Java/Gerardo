package com.gerardo.lookify.services;

import java.util.List;
import java.util.Optional;

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
	
	public Song getSong (Long song_id) {
		Optional <Song> song = repository.findById(song_id);
		if (song.isPresent()) {
			return song.get(); 
		} else {
			return null;
		}
	}
	
	public void deleteSong (Long song_id) {
		repository.deleteById(song_id);
	}
	
	public List<Song> searchByArtist (String artist) {
		return repository.findByArtist(artist);
	}
	
	public List<Song> getTopSongs () {
		return repository.findTop10ByOrderByRatingDesc();
	}
}
