package com.classlion.movie.web;

import com.classlion.movie.service.MovieService;
import com.classlion.movie.web.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieDto> findAll() {
        log.info("Find All");

        return movieService.findAll();
    }

    @GetMapping("/id/{id}")
    public MovieDto findById(@PathVariable("id") Long id) {
        log.info("Find by Id " + id);

        return movieService.findById(id);
    }

    @GetMapping("/name/{name}")
    public MovieDto findByName(@PathVariable("name") String name) {
        log.info("Find by name " + name);

        return movieService.findByName(name);
    }

    @PostMapping
    public Long save(@RequestBody MovieDto movieDto) {
        log.info("Save movie " + movieDto);

        return movieService.save(movieDto);
    }

    @PostMapping("/saveall")
    public boolean saveAll(@RequestBody List<MovieDto> movieDtos) {
        log.info("Save movies " + movieDtos);

        movieService.saveAll(movieDtos);
        return true;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("Delete by Id " + id);

        movieService.delete(id);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable("id") Long id, @RequestBody MovieDto movieDto) {
        log.info("Update movie id " + id + " Movie " + movieDto);

        return movieService.update(id, movieDto);
    }


}
