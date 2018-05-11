package com.gerardo.lookify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.lookify.models.Song;
import com.gerardo.lookify.services.SongService;

@Controller
public class IndexController {
	
	private SongService service;
	
	public IndexController (SongService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Song> songs = service.getAllSongs();
		model.addAttribute("songs", songs);
		return "views/index.jsp";
	}

}
