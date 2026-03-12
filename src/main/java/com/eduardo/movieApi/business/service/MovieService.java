package com.eduardo.movieApi.business.service;

import com.eduardo.movieApi.business.converter.MovieConverter;
import com.eduardo.movieApi.business.exceptions.MovieNotFoundException;
import com.eduardo.movieApi.business.exceptions.ServiceUnavailableException;
import com.eduardo.movieApi.client.MovieClient;
import com.eduardo.movieApi.dto.MovieDto;
import com.eduardo.movieApi.model.entity.MovieEntity;
import com.eduardo.movieApi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieClient movieClient;
    private final MovieConverter movieConverter;

    public MovieEntity showingMovie(String title) {
        try {
            return movieRepository.findByTitleIgnoreCase(title)
                    .orElseGet(() -> {
                        MovieDto movieDto = movieClient.getMovie(title);
                        MovieEntity entity = movieConverter.converterToMovieEntity(movieDto);
                        return movieRepository.save(entity);
                    });
        }catch(RestClientException exception) {
            throw new ServiceUnavailableException("OMDb API is currently unavailable");
        }
    }

    public MovieEntity markAsFavorite(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found."));

        movieEntity.setFavorite(true);

        return movieRepository.save(movieEntity);
    }

    public List<MovieEntity> showingFavoriteMovies() {
        return movieRepository.findByFavoriteTrue();
    }

    public List<MovieEntity> showingAllMoviesViewed() {
        return movieRepository.findAll();
    }
}
