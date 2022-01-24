package com.classlion.movie.service;

import com.classlion.movie.domain.movie.Movie;
import com.classlion.movie.domain.movie.MovieRepository;
import com.classlion.movie.web.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<MovieDto> findAll() {
        return movieRepository.findAll().stream().map(MovieDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id) {
        Movie entity = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화가 없습니다. id=" + id));

        return new MovieDto(entity);
    }

    @Transactional(readOnly = true)
    public MovieDto findByName(String name) {
        Movie entity = movieRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화가 없습니다. name=" + name));

        return new MovieDto(entity);
    }

    @Transactional
    public Long save(MovieDto requestDto) {
        return movieRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public boolean saveAll(List<MovieDto> requestDtos) {
        List<Movie> movies = new ArrayList<>();
        for(MovieDto movieDto : requestDtos) {
            movies.add(movieDto.toEntity());
        }
        movieRepository.saveAll(movies);
        return true;
    }

    @Transactional
    public Long update(Long id, MovieDto requestDto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화가 없습니다. id=" + id));

        movie.update(requestDto.getName(), requestDto.getOpenDate(), requestDto.getExplanation());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화가 없습니다. id=" + id));

        movieRepository.delete(movie);
    }
}
