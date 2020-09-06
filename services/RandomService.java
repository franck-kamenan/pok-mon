package be.intecbrussel.lambda.pokemon.services;

import java.util.Random;

public class RandomService
{
    private static Random random = null;

    private RandomService()
    {

    }

    public static Random getInstance()
    {
        if (random == null)
            random = new Random(42);

        return random;

        //return (random == null) ? random = new Random(42) : random;
    }
}
