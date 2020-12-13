package com.practice.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
}
