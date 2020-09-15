package be.intecbrussel.lambda.pokemon.filter;

import be.intecbrussel.lambda.pokemon.entity.Pokémon;

@FunctionalInterface
public interface PokémonStatFilter {

    boolean filterStat(Pokémon pokémon);
}
