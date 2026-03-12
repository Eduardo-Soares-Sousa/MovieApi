package com.eduardo.movieApi.repository;

import com.eduardo.movieApi.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findByFavoriteTrue();

    Optional<MovieEntity> findByTitleIgnoreCase(String title);
}
