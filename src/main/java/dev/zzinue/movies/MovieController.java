package dev.zzinue.movies;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    @PostConstruct
    public void init() {
        System.out.println("MovieController is loaded!");
    }
    @PostConstruct
    public void testFindAll() {
        List<Movie> movies = movieRepository.findAll();
        System.out.println("Movies in Repository at startup: " + movies.size());
    }
@GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
    List<Movie> movies = movieRepository.findAll();
    System.out.println("Movies in Repository: " + movies.size());
    return new ResponseEntity<>(movies, HttpStatus.OK);
}
    @GetMapping("/test")
    public ResponseEntity<Movie> testMovie() {
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        movie.setImdbId("tt1234567");
        movie.setReleaseDate("2025-01-01");
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

}

