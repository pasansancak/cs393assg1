package com.example.Assg1cs393.REPO;

import com.example.Assg1cs393.MODEL.Album;
import com.example.Assg1cs393.MODEL.Artist;
import com.example.Assg1cs393.MODEL.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
    Song findById(int id);
}
