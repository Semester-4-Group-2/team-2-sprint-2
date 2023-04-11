package com.Sprint2.Team2.service;


import com.Sprint2.Team2.model.VideoGames;

import java.util.List;

public interface VideoGamesService {
    public VideoGames saveVideoGames(VideoGames videoGames);
    public List<VideoGames> getAllVideoGames();
}
