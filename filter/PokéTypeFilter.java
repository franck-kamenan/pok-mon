package be.intecbrussel.lambda.pokemon.filter;

import be.intecbrussel.lambda.pokemon.entity.Pokémon;

@FunctionalInterface
public interface PokéTypeFilter {

    Pokémon[] filterType(Pokémon[] team);
}
