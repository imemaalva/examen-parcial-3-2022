package edu.uaslp.objetos.shoppingcart;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException (String message) {
        super(message);
    }
}
