package br.com.scylla.god.controllers;

import br.com.scylla.god.gateways.responses.PokemonListResponse;
import br.com.scylla.god.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping(path = "/pokemon")
    public Mono<PokemonListResponse> getAll() {
        return this.pokemonService.getAll();
    }

}
