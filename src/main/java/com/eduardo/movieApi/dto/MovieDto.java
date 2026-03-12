package com.eduardo.movieApi.dto;

public record MovieDto(
        String title,
        Integer year,
        String released,
        String runtime,
        String genre,
        String director,
        String writer,
        String actors,
        String plot,
        String poster
) { }
