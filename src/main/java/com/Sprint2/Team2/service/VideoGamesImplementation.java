package com.Sprint2.Team2.service;

import com.Sprint2.Team2.model.VideoGames;
import com.Sprint2.Team2.repository.VideoGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGamesImplementation implements VideoGamesService{
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

    @Override
    public VideoGames getById(Long id){
        return videoGamesRepository.getById(id);
    }

    @Override
    public VideoGames getByName(String name){
        return videoGamesRepository.findByName(name);
    }

    @Override
    public List<VideoGames> getByGenre(String genre){
        return videoGamesRepository.findByGenre(genre);
    }

    @Override
    public VideoGames updateVideoGames(VideoGames videoGames){
        return videoGamesRepository.save(videoGames);
    }

    @Override
    public void deleteVideoGames(Long id) {
        videoGamesRepository.deleteById(id);
    }

    @Override
    public List<VideoGames> getByDevelopers(String developers) {
        return videoGamesRepository.getByDevelopers(developers);
    }


}
