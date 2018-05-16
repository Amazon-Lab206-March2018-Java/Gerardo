package com.gerardo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gerardo.lookify.models.Song;
import com.gerardo.lookify.services.SongService;

@Controller
public class SongsController {
	
	private SongService service;
	
	public SongsController (SongService service) {
		this.service = service;
	}
	
	@RequestMapping ("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = service.getAllSongs();
		model.addAttribute("songs", songs);
		return "views/dashboard.jsp";
	}
	
	@RequestMapping ("/songs/new")
	public String addSongForm (@ModelAttribute ("song") Song song) {
		return "views/addSongForm.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createSong (@Valid @ModelAttribute ("song") Song song, BindingResult result) {
		if (result.hasErrors() ) {
			return "views/addSongForm.jsp";
		} else {
			service.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping ("/songs/{song_id}")
	public String showSong (@PathVariable Long song_id, Model model) {
		Song song = service.getSong (song_id);
		if (song != null) {
			model.addAttribute("song", song);
			return "views/showSong.jsp";			
		} else {
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping ("/delete/{song_id}")
	public String deleteSong (@PathVariable Long song_id) {
		service.deleteSong (song_id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping ("/search{search_term}")
	public String search (@RequestParam String search_term, Model model) {
		List<Song> list = service.searchByArtist (search_term);
		model.addAttribute("songs", list);
		model.addAttribute("artist", search_term);
		return "views/searchResults.jsp";
	}
	
	@RequestMapping ("/search/topTen")
	public String topTen (Model model) {
		List<Song> songs = service.getTopSongs ();
		System.out.println("TOP SONGS: "+songs);
		model.addAttribute("songs", songs);
		return "views/topSongs.jsp";
	}
	
}
