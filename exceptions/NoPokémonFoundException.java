package be.intecbrussel.lambda.pokemon.exceptions;

public class NoPokémonFoundException extends NullPointerException {

    public NoPokémonFoundException() {
    }

    public NoPokémonFoundException(String s) {
        super(s);
    }
}
