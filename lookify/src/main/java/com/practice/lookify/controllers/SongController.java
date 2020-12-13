package com.practice.lookify.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.lookify.models.Song;
import com.practice.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongService songService;
	
//  RENDER/READ
	@RequestMapping("/")
	public String welcome() {
		return "/index.jsp";
	}
	// Dashboard
	@RequestMapping("/dashboard")
	public String dash(@ModelAttribute("song") String search ,Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/dashboard.jsp";
	}
	// Selected Song
	@RequestMapping("/songs/{id}")
	public String song(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/song.jsp";
	}
	// New Song
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/newSong.jsp";
	}
	// Top Ten
	@RequestMapping("/search/topTen")
	public String topten(Model model) {
		List<Song> songs = songService.allSongs();
		List<Song> top10 = new ArrayList<Song>();
		songs.sort(Comparator.comparing(Song::getRating).reversed());
		if (songs.size() > 0) {
			for (int i = 0; i < 10; i++) {
				Song x = songs.get(i);
				top10.add(x);
			}
			model.addAttribute("songs", top10);
		}
		
		return "/topTen.jsp";
	}
	// Search start
	@RequestMapping(value = "/search/", method = RequestMethod.GET)
	public String search(@RequestParam(name="artist") String term, Model model) {
		List<Song> songs = songService.allSongs();
		List<Song> artist = new ArrayList<Song>();
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getArtist().equals(term)) {
				Song x = songs.get(i);
				artist.add(x);
			}
		}
		model.addAttribute("songs", artist);
		model.addAttribute("search", term);
		return "/search.jsp";
	}
	
//	CREATE
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String newSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/songs/new";
		} else {
			songService.createLanguage(song);
			return "redirect:/dashboard";
		}	
	}
	
//	DELETE
	@RequestMapping("/songs/{id}/delete")
	public String deletSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	
}
