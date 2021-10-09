package webscraperapi.service;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public interface WebScraperService {

		public void loadContents() throws MalformedURLException, IOException;
		public Set<String> getAllMovies();
		public Set<String> getAllMovieDirectors();
		public Set<String> getAllMovieGenres();
}
