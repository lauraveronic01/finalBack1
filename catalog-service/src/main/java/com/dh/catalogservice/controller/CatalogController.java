package com.dh.catalogservice.controller;


import com.dh.catalogservice.client.IMovieClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    private final IMovieClient movieServiceClient;

    public CatalogController(IMovieClient movieServiceClient) {
        this.movieServiceClient = movieServiceClient;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<IMovieClient.MovieDto>> getGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
    }


}
