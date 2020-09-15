package be.intecbrussel.lambda.pokemon.entity;

import be.intecbrussel.lambda.pokemon.services.RandomService;

import java.util.Objects;
import java.util.Random;

public class Pokémon
{
    private final String name;
    private final PokéType pokéType;

    private int hp;
    private int atk;
    private int def;

    private static final int MAX_STAT = 50;
    private Random rand = RandomService.getInstance();

    public Pokémon(String name, PokéType pokéType)
    {
        this.name = name;
        this.pokéType = pokéType;
        this.hp = generateStat();
        this.atk = generateStat();
        this.def = generateStat();
    }

    public PokéType getPokéType()
    {
        return pokéType;
    }

    private int generateStat()
    {
        return rand.nextInt(MAX_STAT) + 1;
    }



    public String getName()
    {
        return name;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getAtk()
    {
        return atk;
    }

    public void setAtk(int atk)
    {
        this.atk = atk;
    }

    public int getDef()
    {
        return def;
    }

    public void setDef(int def)
    {
        this.def = def;
    }

    public void evolve()
    {
        setDef(getDef() + 5);
        setAtk(getAtk() + 5);
        setHp(getHp() + 5);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokémon pokémon = (Pokémon) o;
        return hp == pokémon.hp &&
                atk == pokémon.atk &&
                def == pokémon.def &&
                name.equals(pokémon.name) &&
                pokéType == pokémon.pokéType;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, pokéType, hp, atk, def);
    }

    @Override
    public String toString() {
        return "Pokémon name:" + name + "\n" +
                "Pokémon type:" + pokéType + "\n" +
                "Pokémon HP:" + hp + "\n" +
                "Pokémon ATTACK:" + atk + "\n" +
                "Pokémon DEF:" + def + "\n";
    }
}
