package com.eduardo.movieApi.business.converter;

import com.eduardo.movieApi.dto.MovieDto;
import com.eduardo.movieApi.model.entity.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {

    public MovieEntity converterToMovieEntity(MovieDto movieDto) {
        return MovieEntity.builder()
                .title(movieDto.title())
                .year(movieDto.year())
                .released(movieDto.released())
                .runtime(movieDto.runtime())
                .genre(movieDto.genre())
                .director(movieDto.director())
                .writer(movieDto.writer())
                .actors(movieDto.actors())
                .plot(movieDto.plot())
                .poster(movieDto.poster())
                .build();
    }
}
