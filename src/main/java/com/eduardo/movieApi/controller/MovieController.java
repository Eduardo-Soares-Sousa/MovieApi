package com.eduardo.movieApi.controller;

import com.eduardo.movieApi.business.service.MovieService;
import com.eduardo.movieApi.model.entity.MovieEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Search for a movie by title",
            description = "Searches for a movie by its title. If the movie is not already stored in the database, " +
                    "the system fetches it from an external API and saves it."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie found and returned successfully"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/search")
    public ResponseEntity<MovieEntity> getMovie(@RequestParam String title) {
        return ResponseEntity.ok(movieService.showingMovie(title));
    }

    @Operation(
            summary = "Mark a movie as favorite",
            description = "Marks a movie stored in the database as a favorite."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully marked as favorite"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    @GetMapping("/{id}/favorite")
    public ResponseEntity<MovieEntity> markAsFavorite(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.markAsFavorite(id));
    }

    @Operation(
            summary = "List favorite movies",
            description = "Returns all movies marked as favorite in the database."
    )
    @ApiResponse(responseCode = "200", description = "List of favorite movies returned successfully")
    @GetMapping("/favorites")
    public ResponseEntity<List<MovieEntity>> favoriteMovies() {
        return ResponseEntity.ok(movieService.showingFavoriteMovies());
    }

    @Operation(
            summary = "List all viewed movies",
            description = "Returns all movies that have been searched and stored in the database."
    )
    @ApiResponse(responseCode = "200", description = "List of stored movies returned successfully")
    @GetMapping
    public ResponseEntity<List<MovieEntity>> viewAllMovies() {
        return ResponseEntity.ok(movieService.showingAllMoviesViewed());
    }
}
