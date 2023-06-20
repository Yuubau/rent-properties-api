package fr.esgi.properties.api.error;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrorDtoTest {
    @Test
    public void shouldContainMessage() {
        String message = "Test";
        ErrorDto error = new ErrorDto(message);
        Assertions.assertEquals(message, error.getMessage());
    }
}
