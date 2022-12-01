package com.example.Assg1cs393.SERVICE;

import com.example.Assg1cs393.MODEL.Album;
import com.example.Assg1cs393.MODEL.Song;
import com.example.Assg1cs393.REPO.SongRepo;
import com.example.Assg1cs393.REPO.AlbumRepo;
import com.example.Assg1cs393.REPO.ArtistRepo;
import com.example.Assg1cs393.REPO.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class RegService {

    @Autowired
    ArtistRepo artistRepo;
    @Autowired
    SongRepo songRepo;
    @Autowired
    PlaylistRepo playlistRepo;
    @Autowired
    AlbumRepo albumRepo;


    public void saveAlbum(Album album){
        albumRepo.save(album);
    }

    public void addSongToAlbum(int albumId, Song song){

        Album a = albumRepo.findById(albumId);

        try{
            if(Objects.equals(song.getArtist().getName(), a.getArtist().getName())){
                a.getSongs().add(song);
                song.setAlbum(a);
            }
            else
                System.out.println("This song doesn't belongs this artist.");

        }
        catch (Exception e){
            System.out.println("This song doesn't have an artist therefore song didn't added to the album");
        }

        songRepo.save(song);
    }

    public void assignArtistToAlbum(int albumId, int artistId){
        albumRepo.findById(albumId).setArtist(artistRepo.findById(artistId));
    }

    public void deleteAlbum(int albumId){
        List<Song> songs = albumRepo.findById(albumId).getSongs();
        albumRepo.deleteById(albumId);
        songRepo.saveAll(songs);
    }

    public void deleteSong(int songId){
        songRepo.deleteById(songId);
    }

    public List<Song> findSongsWithArtistId(int id){
        return artistRepo.findById(id).getSongs();
    }


    public ArtistRepo getArtistRepo() {
        return artistRepo;
    }

    public void setArtistRepo(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }

    public SongRepo getSongRepo() {
        return songRepo;
    }

    public void setSongRepo(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public PlaylistRepo getPlaylistRepo() {
        return playlistRepo;
    }

    public void setPlaylistRepo(PlaylistRepo playlistRepo) {
        this.playlistRepo = playlistRepo;
    }

    public AlbumRepo getAlbumRepo() {
        return albumRepo;
    }

    public void setAlbumRepo(AlbumRepo albumRepo) {
        this.albumRepo = albumRepo;
    }

}
