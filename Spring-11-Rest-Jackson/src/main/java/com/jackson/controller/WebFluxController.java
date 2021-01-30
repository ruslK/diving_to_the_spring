package com.jackson.controller;

import com.jackson.entities.Genre;
import com.jackson.entities.MovieCinema;
import com.jackson.repositories.GenreRepository;
import com.jackson.repositories.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class WebFluxController {

    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private final MovieCinemaRepository movieRepository;
    private final GenreRepository genreRepository;


    public WebFluxController(MovieCinemaRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux(){
        return Flux.fromIterable(movieRepository.findAll());
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> movieCinema(@PathVariable("id") Long id) {
        return Mono.just(movieRepository.findById(id).get());
    }

    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByIdRequestParam(@RequestParam("id") Long id) {
        return Mono.just(movieRepository.findById(id).get());
    }

    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre body) {
        return Mono.just(genreRepository.save(body));
    }

    @PutMapping("/update-genre/{id}")
    public Mono<Genre> updateGenre(@PathVariable("id") Long id, @RequestBody Genre genre) {
        Genre foundGenre = genreRepository.findById(id).get();
        genre.setId(foundGenre.getId());
        return Mono.just(genreRepository.save(genre));
    }

    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id) {
        genreRepository.deleteById(id);
        return Mono.empty();
    }


    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){
        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id) {
        return webClient.get()
                .uri("/mono-movie-cinema/{id}", id)
                .header(MediaType.APPLICATION_JSON_VALUE, HttpHeaders.CONTENT_TYPE)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

    @GetMapping("mono-rp")
    public Mono<MovieCinema> readMonoWithWebClientRequestParam(@RequestParam("id") Long id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/mono-movie-cinema")
                        .queryParam("id", id).build())
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }


    @PostMapping("/create")
    public Mono<Genre> createWebClient(@RequestBody Genre genre) {
        return webClient.post()
                .uri("/create-genre")
                .body(Mono.just(genre), Genre.class)
                .retrieve()
                .bodyToMono(Genre.class);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteWebClient(@PathVariable("id") Long id) {
        return webClient.delete()
                .uri("/delete-genre", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
