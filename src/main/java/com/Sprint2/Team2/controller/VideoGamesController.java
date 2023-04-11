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

    @GetMapping("/getById/{id}")
    public VideoGames getById(@PathVariable Long id){
        return videoGamesService.getById(id);
    }

    @GetMapping("/getAll")
    public List<VideoGames> getAllVideoGames(){
        return videoGamesService.getAllVideoGames();
    }

    @GetMapping("/getByName/{name}")
    public VideoGames getByName(@PathVariable String name){
        return videoGamesService.getByName(name);
    }

    @GetMapping("/getByGenre/{genre}")
    public List<VideoGames> getByGenre(@PathVariable String genre){
        return videoGamesService.getByGenre(genre);
    }

    @GetMapping("/getByPlatform")
    public List<VideoGames> getByPlatform(@RequestParam(value = "platform") List<String> platforms){
        return videoGamesService.getByPlatforms(platforms);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody VideoGames videoGames){
        VideoGames videoGamesToUpdate = videoGamesService.getById(id);
        videoGamesToUpdate.setName(videoGames.getName());
        videoGamesToUpdate.setPlatforms(videoGames.getPlatforms());
        videoGamesToUpdate.setDevelopers(videoGames.getDevelopers());
        videoGamesToUpdate.setGenre(videoGames.getGenre());
        videoGamesService.saveVideoGames(videoGamesToUpdate);
        return "Game updated";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        videoGamesService.deleteVideoGames(id);
        return "Game deleted";
    }

}
