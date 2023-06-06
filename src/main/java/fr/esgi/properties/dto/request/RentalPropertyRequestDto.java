package fr.esgi.properties.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RentalPropertyRequestDto(
        @NotNull String description,
        @NotNull String town,
        @NotNull String address,
        @NotNull String propertyType,
        @NotNull double rentAmount,
        @NotNull double securityDepositAmount,
        @NotNull double area,
        @NotNull int bedroomsCount,
        int floorNumber,
        int numberOfFloors,
        @NotNull char constructionYear,
        @NotNull String energyClassification,
        @NotNull boolean hasElevator,
        @NotNull boolean hasIntercom,
        @NotNull boolean hasBalcony,
        @NotNull boolean hasParkingSpace) {

}
