package com.Sprint2.Team2;

import com.Sprint2.Team2.model.VideoGames;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VideoGamesModelTest {

    @Test
    public void testIdGetterAndSetter() {
        Long id = 1L;
        VideoGames videoGames = new VideoGames();
        videoGames.setId(id);
        assertEquals(id, videoGames.getId());
        System.out.println(videoGames.getId());
    }

    @Test
    public void testNameGetterAndSetter() {
        String name = "Super Mario Bros";
        VideoGames videoGames = new VideoGames();
        videoGames.setName(name);
        assertEquals(name, videoGames.getName());
        System.out.println(videoGames.getName());
    }

    @Test
    public void testPlatformsGetterAndSetter() {
        String platforms = "Nintendo Switch";
        VideoGames videoGames = new VideoGames();
        videoGames.setPlatforms(platforms);
        assertEquals(platforms, videoGames.getPlatforms());
        System.out.println(videoGames.getPlatforms());
    }

    @Test
    public void testDevelopersGetterAndSetter() {
        String developers = "Nintendo";
        VideoGames videoGames = new VideoGames();
        videoGames.setDevelopers(developers);
        assertEquals(developers, videoGames.getDevelopers());
        System.out.println(videoGames.getDevelopers());
    }

    @Test
    public void testGenreGetterAndSetter() {
        String genre = "Horror";
        VideoGames videoGames = new VideoGames();
        videoGames.setGenre(genre);
        assertEquals(genre, videoGames.getGenre());
        System.out.println(videoGames.getGenre());
    }
}