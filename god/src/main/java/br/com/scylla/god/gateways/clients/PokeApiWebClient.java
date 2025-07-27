package br.com.scylla.god.gateways.clients;

import br.com.scylla.god.gateways.responses.PokemonListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
@Slf4j
public class PokeApiWebClient {

    public Mono<PokemonListResponse> getAll(){

        return WebClient.create()
                .get()
                .uri("https://pokeapi.co/api/v2/pokemon?limit=151")
                .retrieve()
                .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse
                                .bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new RuntimeException("Erro da API: " + errorBody)))
                )
                .bodyToMono(PokemonListResponse.class)
                .doOnNext(response -> log.info("Chamada com sucesso: {}", response));


    }

}
