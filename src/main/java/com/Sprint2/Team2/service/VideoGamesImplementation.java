package com.Sprint2.Team2.service;

import com.Sprint2.Team2.model.VideoGames;
import com.Sprint2.Team2.repository.VideoGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGamesImplementation {
    @Autowired
    private VideoGamesRepository videoGamesRepository;

    @Override
    public VideoGames saveVideoGames(VideoGames videoGames){
        return videoGamesRepository.save(videoGames);
    }

    @Override
    public List<VideoGames> getAllVideoGames(){
        return videoGamesRepository.findAll();
    }
}
