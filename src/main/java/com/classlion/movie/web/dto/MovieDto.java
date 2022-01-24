package com.classlion.movie.web.dto;

import com.classlion.movie.domain.movie.Movie;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MovieDto {
    @NotBlank
    private String name;
    @NotBlank
    private String openDate;
    @NotBlank
    private String explanation;


    public MovieDto() {
    }

    public MovieDto(Movie movie) {
        this.name = movie.getName();
        this.openDate = movie.getOpenDate();
        this.explanation = movie.getExplanation();
    }

    public Movie toEntity() {
        return new Movie(name, openDate, explanation);
    }
}
