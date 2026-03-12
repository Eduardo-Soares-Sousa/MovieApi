package com.eduardo.movieApi.repository;

import com.eduardo.movieApi.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findByFavoriteTrue();
}
