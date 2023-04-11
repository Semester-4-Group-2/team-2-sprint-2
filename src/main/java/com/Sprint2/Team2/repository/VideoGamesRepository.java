package com.Sprint2.Team2.repository;

import com.Sprint2.Team2.model.VideoGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGamesRepository extends JpaRepository<VideoGames, Long> {
    VideoGames getById(Long id);
    
}
