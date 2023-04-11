package com.Sprint2.Team2.controller;

import com.Sprint2.Team2.model.VideoGames;
import com.Sprint2.Team2.service.VideoGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videogames")
public class VideoGamesController {
    @Autowired
    public VideoGamesService videoGamesService;

    @PostMapping("/add")
    public String add(@RequestBody VideoGames videoGames){
        videoGamesService.saveVideoGames(videoGames);
        return "New game added";
    }

    @GetMapping("/getAll")
    public List<VideoGames> getAllVideoGames(){
        return videoGamesService.getAllVideoGames();
    }

    @GetMapping("/getById/{id}")
    public VideoGames getById(@PathVariable Long id){
        return videoGamesService.getById(id);
    }


}
