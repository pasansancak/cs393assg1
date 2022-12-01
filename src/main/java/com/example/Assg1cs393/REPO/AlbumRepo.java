package com.example.Assg1cs393.REPO;

import com.example.Assg1cs393.MODEL.Album;
import com.example.Assg1cs393.MODEL.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository <Album, Integer> {
    Album findById(int id);

}
