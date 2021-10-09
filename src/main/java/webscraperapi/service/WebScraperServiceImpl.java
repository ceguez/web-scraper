package webscraperapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import webscraperapi.model.Movie;
import webscraperapi.util.WebScraperHelper;

@Service
public class WebScraperServiceImpl implements WebScraperService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	private List<Movie> movies = new ArrayList<>();
	
	@Value("${wikipedia.american-films.url}")
	private String movieUrl;
	@Value("${wikipedia.parse.timeout.ms}")
	Integer parseTimeoutMillis;
	@Value("${wikipedia.american-films.directortag}")
	String directorTagName;
	@Value("${wikipedia.american-films.titletag}")
	String titleTagName;
	@Value("${wikipedia.american-films.genretag}")
	String genreTagName;

	@Value("#{'${wikipedia.american-films.searchtags}'.split(',')}")
	List<String> movieLinksSearchTags;
	
	public WebScraperServiceImpl() {
	}
	
	@PostConstruct
	@Override
	public void loadContents() throws IOException {
		LOGGER.info("loadContents()...start");
		movies.clear();
		List<String> movieDetailsSearchTags = Arrays.asList(directorTagName, titleTagName, genreTagName);
		WebScraperHelper scraperHelper = new WebScraperHelper(movieUrl, parseTimeoutMillis, movieDetailsSearchTags, movieLinksSearchTags);
				
		LOGGER.info("Extracting movie details...start");
		
		scraperHelper.fetchAllLinkMetaDetailsFromPage()
		.thenAccept(list->{
			list.stream().filter(map->map.get(titleTagName)!=null && map.get(titleTagName).length()>0)
			.forEach(map->{
				movies.add(new Movie(map.get(titleTagName), map.get(genreTagName), map.get(directorTagName)));
			});
		});
		
		LOGGER.info("loadContents()...completed");
	}
	
	@Override
	public Set<String> getAllMovies() {
		return movies.stream().map(a->a.getTitle().toString())
				.collect(Collectors.toSet());
	}
	
	@Override
	public Set<String> getAllMovieDirectors() {
		return movies.stream().map(a->a.getDirector())
				.collect(Collectors.toSet());
	}
	
	@Override
	public Set<String> getAllMovieGenres() {
		return movies.stream().map(a->a.getGenre())
				.collect(Collectors.toSet());
	}
	
}
