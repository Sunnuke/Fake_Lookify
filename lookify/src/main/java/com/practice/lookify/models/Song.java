package com.practice.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "song")
public class Song {
	
//	ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 20)
	private String title;
	
	@Size(min = 5, max = 20)
	private String artist;
	
	@Min(1)
	@Max(10)
	private int rating;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
//	Constructors
	public Song() {}
	public Song( String title, String artist, int rating) {
	this.title = title;
	this.artist = artist;
	this.rating = rating;
	}
	
//	PRESETS
	
	@PrePersist
	private void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	private void onUpdate() {
		this.createdAt = new Date();
	}
	
//	METHODS
	
	// Id
	public Long getId() {
		return id;
	}
	
	// Title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	// Artist
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	// Rating
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	// Date/Time
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
}
