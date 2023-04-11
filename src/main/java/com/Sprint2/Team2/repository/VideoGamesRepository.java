package com.Sprint2.Team2.repository;

import com.Sprint2.Team2.model.VideoGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoGamesRepository extends JpaRepository<VideoGames, Long> {
    VideoGames findByName(String name);

    List<VideoGames> findByGenre(String genre);

    void updateVideoGames(VideoGames videoGames);
    void deleteById(Long id);

}



