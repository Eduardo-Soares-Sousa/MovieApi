package com.eduardo.movieApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MovieDto(
        @JsonProperty("Title")
        String title,

        @JsonProperty("Year")
        String year,

        @JsonProperty("Released")
        String released,

        @JsonProperty("Runtime")
        String runtime,

        @JsonProperty("Genre")
        String genre,

        @JsonProperty("Director")
        String director,

        @JsonProperty("Writer")
        String writer,

        @JsonProperty("Actors")
        String actors,

        @JsonProperty("Plot")
        String plot,

        @JsonProperty("Poster")
        String poster,

        @JsonProperty("Response")
        String response,

        @JsonProperty("Error")
        String error
) { }
