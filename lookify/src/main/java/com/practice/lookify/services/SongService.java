package com.practice.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.lookify.models.Song;
import com.practice.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
//	RETRIEVE
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}

	}
	
//	CREATE
	public Song createLanguage(Song song) {
		return songRepository.save(song);
		
	}
	
//	UPDATE	
	public Song updateLanguage(Song song, Long id) {
		Song songOg = this.findSong(id);
		songOg.setTitle(song.getTitle());
		songOg.setArtist(song.getArtist());
		songOg.setRating(song.getRating());
		songRepository.save(this.findSong(id));
		return this.findSong(id);
	}
	
//	DELETE
	public void deleteSong(Long id) {
		songRepository.deleteById(id);;
	}
	
}
