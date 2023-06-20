package fr.esgi.properties.api.error;

import fr.esgi.properties.exception.NotFoundRentalPropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundRentalPropertyException.class)
    public ErrorDto handleNotFoundRentalPropertyException(NotFoundRentalPropertyException notFoundRentalPropertyException) {
        return new ErrorDto(notFoundRentalPropertyException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDto handleMethodArgumentNotValidException() {
        return new ErrorDto("La requête envoyée est invalide");
    }

}
