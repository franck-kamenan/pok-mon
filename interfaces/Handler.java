package be.intecbrussel.lambda.pokemon.interfaces;

import be.intecbrussel.lambda.pokemon.entity.Pokémon;
@FunctionalInterface
public interface Handler {
    void handle(Pokémon pokémon);
}
