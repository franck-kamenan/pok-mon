package be.intecbrussel.lambda.pokemon.application;

import be.intecbrussel.lambda.pokemon.entity.PokéType;
import be.intecbrussel.lambda.pokemon.entity.Pokémon;
import be.intecbrussel.lambda.pokemon.entity.PokémonTrainer;

public class PokémonApp {

    public static void main(String[] args) {

        Pokémon bulbasaur = new Pokémon("Bulbasaur", PokéType.GRASS);
        Pokémon charmander = new Pokémon("Charmander", PokéType.FIRE);
        Pokémon squirtle = new Pokémon("Squirtle", PokéType.WATER);

        PokémonTrainer alex = new PokémonTrainer("Alex");

        if (alex.savePokémon(bulbasaur)){
            System.out.println("Pokémon is saved.");
        } else{
            System.out.println("Something went wrong!");
        }

        alex.savePokémon(charmander);
        alex.savePokémon(squirtle);

        Pokémon searchResult = alex.getPokémonByName("Bulbasaur");
        System.out.println("\nPokémon found!\n" + searchResult);

        System.out.println(alex);


    }
}
