package com.eduardo.movieApi.client;

import com.eduardo.movieApi.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class MovieClient {
    @Value("${openmovie.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://www.omdbapi.com/";

    public MovieDto getMovie(String title) {
        String url = UriComponentsBuilder
                .fromUriString(BASE_URL)
                .queryParam("apikey", apiKey)
                .queryParam("t", title)
                .queryParam("plot", "full")
                .toUriString();

        return restTemplate.getForObject(url, MovieDto.class);
    }
}
