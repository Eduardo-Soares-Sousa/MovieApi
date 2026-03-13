package com.eduardo.movieApi.controller;

import com.eduardo.movieApi.business.service.MovieService;
import com.eduardo.movieApi.model.entity.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/search")
    public ResponseEntity<MovieEntity> getMovie(@RequestParam String title) {
        return ResponseEntity.ok(movieService.showingMovie(title));
    }

    @GetMapping("/{id}/favorite")
    public ResponseEntity<MovieEntity> markAsFavorite(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.markAsFavorite(id));
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<MovieEntity>> favoriteMovies() {
        return ResponseEntity.ok(movieService.showingFavoriteMovies());
    }

    @GetMapping
    public ResponseEntity<List<MovieEntity>> viewAllMovies() {
        return ResponseEntity.ok(movieService.showingAllMoviesViewed());
    }
}
