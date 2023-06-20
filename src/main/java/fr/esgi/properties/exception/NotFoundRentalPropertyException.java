package fr.esgi.properties.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundRentalPropertyException extends RuntimeException {

    public String message;
    public NotFoundRentalPropertyException(String message) {
        super(message);
        this.message = message;
    }
}
