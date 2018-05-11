package com.gerardo.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.lookify.models.Song;
import com.gerardo.lookify.services.SongService;

@Controller
public class SongsController {
	
	private SongService service;
	
	public SongsController (SongService service) {
		this.service = service;
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
}
