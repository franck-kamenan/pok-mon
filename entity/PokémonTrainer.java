package be.intecbrussel.lambda.pokemon.entity;

import be.intecbrussel.lambda.pokemon.exceptions.NoPokémonFoundException;
import be.intecbrussel.lambda.pokemon.exceptions.NoValidSearchException;
import be.intecbrussel.lambda.pokemon.filter.PokéTypeFilter;
import be.intecbrussel.lambda.pokemon.filter.PokémonStatFilter;
import be.intecbrussel.lambda.pokemon.interfaces.Handler;

import java.util.Arrays;

public class PokémonTrainer {

    private final String nickname;
    private final Pokémon[] team = new Pokémon[6];

    public PokémonTrainer(String nickname) {
        this.nickname = nickname;
    }

    public boolean savePokémon(Pokémon pokémon){
        if (pokémon != null){

            for (int i = 0; i < team.length; i++) {

                if (team[i] == null){
                    team[i] = pokémon;
                    return true;
                }
            }
            System.out.println("Sorry no more place in your team for an extra Pokémon!\nMake Room first!\n");
        } else {
            System.out.println("Please try again with a valid Pokémon!");
        }
        return false;
    }

    public boolean deletePokémon(Pokémon pokémon){

        if (pokémon != null){
            for (int i = 0; i < team.length; i++) {
                if (pokémon.equals(team[i])){
                    team[i] = null;
                    return true;
                }
            }

        }
        return false;
    }

    public Pokémon getPokémonByName(String name){

        if (name != null){

            name = name.replace(" ", "");

            if (!name.isEmpty()){

                for (Pokémon pokémon: team) {

                    if (name.equals(pokémon.getName())){
                        return pokémon;
                    }
                }

                throw new NoPokémonFoundException(name.toUpperCase() + " not found!");
            }
        }
        throw new NoValidSearchException("Not a valid search!");
    }

    public Pokémon[] getTeam(){
        return this.team;
    }

    public void searchStat(PokémonStatFilter filter, Pokémon pokémon){

        if (filter.filterStat(pokémon)){
            System.out.println("Pokémon meets the requirement!");
        } else {
            System.out.println("Pokémon does not meet the requirement!");
        }
    }

    public void searchPokéType(PokéTypeFilter filter){

        Pokémon[] filteredTeam = filter.filterType(team);

        if (filteredTeam != null){

            System.out.println("Pokémon type is found!");

            for (Pokémon p: filteredTeam) {
                if (p != null) {
                    System.out.println(p);
                }
            }
        }

    }

    public void train(Handler handler, Pokémon pokémon){

        handler.handle(pokémon);
    }

    @Override
    public String toString() {
        return "PokémonTrainer{" +
                "nickname='" + nickname + '\'' +
                ", team=" + Arrays.toString(team) +
                '}';
    }
}
