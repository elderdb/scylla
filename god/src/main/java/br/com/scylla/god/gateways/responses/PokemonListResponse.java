package br.com.scylla.god.gateways.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonListResponse {

    private int count;
    private String next;
    private String previous;

    @JsonProperty("results")
    private List<PokemonSummary> results;
}