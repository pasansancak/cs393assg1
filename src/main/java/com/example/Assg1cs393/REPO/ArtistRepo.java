package com.example.Assg1cs393.REPO;

import com.example.Assg1cs393.MODEL.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Integer> {
    Artist findById(int id);

}
