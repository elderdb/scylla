package br.com.scylla.god.services;

import br.com.scylla.god.gateways.clients.PokeApiWebClient;
import br.com.scylla.god.gateways.responses.PokemonListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonService {

    private final PokeApiWebClient pokeApiWebClient;

    public Mono<PokemonListResponse> getAll() {
        return this.pokeApiWebClient.getAll()
                .doOnError(throwable -> log.error("Erro: {}", throwable.getMessage()));
    }

}
