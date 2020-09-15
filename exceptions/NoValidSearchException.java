package be.intecbrussel.lambda.pokemon.exceptions;

import java.util.InputMismatchException;

public class NoValidSearchException extends InputMismatchException {

    public NoValidSearchException() {
    }

    public NoValidSearchException(String s) {
        super(s);
    }
}
