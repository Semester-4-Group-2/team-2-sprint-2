package com.Sprint2.Team2.service;

import com.Sprint2.Team2.model.VideoGames;
import com.Sprint2.Team2.repository.VideoGamesRepository;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint2.Team2.model.VideoGames;
import com.Sprint2.Team2.repository.VideoGamesRepository;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import java.util.List;
import java.util.stream.Collectors;

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
    public List<VideoGames> getByName(String name) {
        List<VideoGames> videoGames = videoGamesRepository.findAll();
        System.out.println("Total video games: " + videoGames.size());
        List<VideoGames> searchResults = new ArrayList<>();

        // Set up the analyzer, index, and writer.
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer;
        try {
            writer = new IndexWriter(index, config);

            // Add your video games to the index.
            for (VideoGames videoGame : videoGames) {
                Document doc = new Document();
                // Assuming you have a `name` field in your VideoGame class.
                doc.add(new TextField("name", videoGame.getName(), Field.Store.YES));
                writer.addDocument(doc);
                System.out.println("Indexed: " + videoGame.getName()); // Add this line
            }
            writer.close();

            // Perform the fuzzy search.
            Query query = new QueryParser("name", analyzer).parse(name + "~");
            DirectoryReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(query, videoGames.size());

            // Collect the search results.
            for (ScoreDoc scoreDoc : docs.scoreDocs) {
                Document doc = searcher.doc(scoreDoc.doc);
                String foundName = doc.get("name");
                // Assuming you have a method to find a video game by name.
                VideoGames foundVideoGame = findVideoGameByName(foundName);
                if (foundVideoGame != null) {
                    System.out.println("Found: " + foundVideoGame.getName());
                    searchResults.add(foundVideoGame);
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    private VideoGames findVideoGameByName(String foundName) {
        return videoGamesRepository.findByName(foundName).orElse
                (null);
    }

    @Override
    public List<VideoGames> getByGenre(String genre){
        return videoGamesRepository.findByGenre(genre);
    }

    @Override
    public List<VideoGames> getByPlatforms(String platforms){return videoGamesRepository.findByPlatforms(platforms);}


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
