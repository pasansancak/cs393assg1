package com.example.Assg1cs393;

import java.util.List;

import com.example.Assg1cs393.MODEL.Album;
import com.example.Assg1cs393.MODEL.Artist;
import com.example.Assg1cs393.MODEL.Song;
import com.example.Assg1cs393.SERVICE.RegService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class Assg1cs393ApplicationTests {
	@Autowired
	RegService service;

	@Test
	void testSaveAlbum(){

		List<Song> songs = new ArrayList<>();
		songs.add(new Song("Self Care", 3.41));
		songs.add(new Song("Perfecto", 3.12));

		//service.saveSong(songs.get(0));
		//service.saveSong(songs.get(1));
		//we could also save artist in db.
		Album album = new Album("Swimming", new Artist("Mac Miller"), songs);
		service.saveAlbum(album);

		//System.out.println(service.getAlbumRepo().findById(album.getId()).toString());

		assertEquals(album, service.getAlbumRepo().findById(album.getId()));
	}

	@Test
	void addSongToAlbum(){
		Song s = new Song("Smells like teen spirit", service.getArtistRepo().findById(1), 5.01);
/*
		for(Song song : service.getAlbumRepo().findById(1).getSongs())
			System.out.println(song.getName());*/
		service.addSongToAlbum(1, s);
/*
		for(Song song : service.getAlbumRepo().findById(1).getSongs())
			System.out.println(song.getName());*/
		assertSame(service.getAlbumRepo().findById(1).getId(), s.getAlbum().getId());
	}

	@Test
	void AssignArtistToAlbum(){
		//System.out.println(service.getAlbumRepo().findById(1).
		//		getArtist().getName());
		service.assignArtistToAlbum(1,2);
		//System.out.println(service.getAlbumRepo().findById(1).
		//		getArtist().getName());
		assertSame(service.getAlbumRepo().findById(1).getArtist(), service.getArtistRepo().findById(2));
	}


	@Test
	void deleteSong(){
		//System.out.println(service.getSongRepo().findById(1).getName());
		service.deleteSong(1);
		assertNull(service.getSongRepo().findById(1));
	}

	@Test
	void deleteAlbum(){
		//System.out.println(service.getAlbumRepo().findById(1).getName());
		service.deleteAlbum(1);
		assertNull(service.getAlbumRepo().findById(1));

	}

	@Test
	void findSongsWithArtistID(){
		List<Song> songs = service.findSongsWithArtistId(1);
		/*for(Song x : songs){
			System.out.println(x.getName());
		}*/
		assertNotNull(songs);
	}


}
