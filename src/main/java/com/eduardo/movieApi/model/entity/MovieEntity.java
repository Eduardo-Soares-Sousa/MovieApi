package com.eduardo.movieApi.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String title;

    private String year;
    private String released;
    private String runtime;

    @Column(length = 255)
    private String genre;

    private String director;

    @Column(length = 500)
    private String writer;

    @Column(length = 500)
    private String actors;

    @Column(columnDefinition = "TEXT")
    private String plot;

    @Column(length = 500)
    private String poster;

    private boolean favorite;
}
