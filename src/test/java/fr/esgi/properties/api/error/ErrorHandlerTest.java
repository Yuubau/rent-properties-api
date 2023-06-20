package fr.esgi.properties.api.error;

import fr.esgi.properties.exception.NotFoundRentalPropertyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorHandlerTest {

    @Test
    void shouldHandleNotFoundRentalPropertyException() {
        String message = "";

        ErrorHandler errorHandler = new ErrorHandler();

        ErrorDto errorDto = errorHandler.handleNotFoundRentalPropertyException(new NotFoundRentalPropertyException(message));

        Assertions.assertEquals(errorDto.message(), message);
    }

    @Test
    void shouldHandleMethodArgumentNotValidException() {
        String message = "La requête envoyée est invalide";

        ErrorHandler errorHandler = new ErrorHandler();

        ErrorDto errorDto = errorHandler.handleMethodArgumentNotValidException();

        Assertions.assertEquals(errorDto.message(), message);
    }

}
