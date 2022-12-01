package com.example.Assg1cs393.REPO;

import com.example.Assg1cs393.MODEL.Album;
import com.example.Assg1cs393.MODEL.Artist;
import com.example.Assg1cs393.MODEL.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo extends JpaRepository<Playlist, Integer> {
    Playlist findById(int id);
}
