package webscraperapi.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webscraperapi.service.WebScraperService;


@CrossOrigin(origins = "*")//In Production create white list such as: {"htpp://localhost:8080", "htpp://localhost:8081"}
@RestController
@RequestMapping("/api/webscraper")
public class WebScraperController {

	@Autowired
	WebScraperService scraperService;
	
	@GetMapping(value ="/movies", produces = "application/json")
	public Set<String> getAllMovies() {
		return scraperService.getAllMovies();
	}
	
	@GetMapping(value ="/movie-directors", produces = "application/json")
	public Set<String> getAllMovieDirectors() {
		return scraperService.getAllMovieDirectors();
	}
	
	@GetMapping(value = "/movie-genres", produces = "application/json")
	public Set<String> getAllMovieGenres() {
		return scraperService.getAllMovieGenres();
	}
}
