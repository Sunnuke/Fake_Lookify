package com.practice.lookify.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.lookify.models.Song;
import com.practice.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongService songService;
	
//  RENDER
	@RequestMapping("/")
	public String welcome() {
		return "/songs/index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dash(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/songs/dashboard.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String song(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/songs/song.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong() {
		return "/songs/newSong.jsp";
	}
	@RequestMapping("/search/topTen")
	public String topten(Model model) {
		List<Song> songs = songService.allSongs();
		List<Song> top10 = new ArrayList<Song>();
		songs.sort(Comparator.comparing(Song::getRating));
		for (int i = 0; i < 10; i++) {
			Song x = songs.get(i);
			top10.add(x);
		}
		model.addAttribute("songs", top10);
		return "/songs/topTen.jsp";
	}
	@RequestMapping("/search/{term}")
	public String search(@PathVariable("term") String term, Model model) {
		List<Song> songs = songService.allSongs();
		List<Song> artist = new ArrayList<Song>();
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getArtist() == term) {
				Song x = songs.get(i);
				artist.add(x);			}
		}
		return "/songs/topTen.jsp";
	}
	
//	CREATE
	
	
//	UPDATE
	
	
//	DELETE
	
	
}
