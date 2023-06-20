package fr.esgi.properties.api.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
public class ErrorDto {
    private String message;
    public ErrorDto(String message) {
        this.message = message;
    }



}
