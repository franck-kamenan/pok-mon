package be.intecbrussel.lambda.pokemon.application;

import be.intecbrussel.lambda.pokemon.entity.PokéType;
import be.intecbrussel.lambda.pokemon.entity.Pokémon;
import be.intecbrussel.lambda.pokemon.entity.PokémonTrainer;
import be.intecbrussel.lambda.pokemon.filter.PokémonStatFilter;

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

        alex.searchStat(new PokémonStatFilter() {
            @Override
            public boolean filterStat(Pokémon pokémon) {
                return pokémon.getAtk() > 25;
            }
        }, bulbasaur);

        alex.searchStat(new PokémonStatFilter() {
            @Override
            public boolean filterStat(Pokémon pokémon) {
                if (pokémon.getHp() > 20){
                    System.out.println(pokémon);
                    return true;
                }
                return false;
            }
        }, bulbasaur);

        alex.searchStat(pokémon -> pokémon.getAtk() > 25, bulbasaur);
        alex.searchStat(pokémon -> pokémon.getHp() > 20, bulbasaur);
    }
}
