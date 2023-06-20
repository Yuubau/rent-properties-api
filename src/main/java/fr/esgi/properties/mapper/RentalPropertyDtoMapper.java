package fr.esgi.properties.mapper;

import fr.esgi.properties.domain.EnergyClassificationEntity;
import fr.esgi.properties.domain.PropertyTypeEntity;
import fr.esgi.properties.domain.RentalPropertyEntity;
import fr.esgi.properties.dto.request.RentalPropertyRequestDto;
import fr.esgi.properties.dto.response.RentalPropertyResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalPropertyDtoMapper {

    public List<RentalPropertyResponseDto> mapToDtoList(List<RentalPropertyEntity> rentalProperties) {
        return rentalProperties.stream()
                .map(this::mapToDto)
                .toList();
    }

    public RentalPropertyResponseDto mapToDto(RentalPropertyEntity rentalProperty) {
        return new RentalPropertyResponseDto(
                rentalProperty.getDescription(),
                rentalProperty.getAddress(),
                rentalProperty.getTown(),
                rentalProperty.getPropertyType().getDesignation(),
                rentalProperty.getRentAmount(),
                rentalProperty.getSecurityDepositAmount(),
                rentalProperty.getArea());
    }

    public RentalPropertyEntity mapToEntity(RentalPropertyRequestDto rentalPropertyRequestDto) {
        return new RentalPropertyEntity(
                rentalPropertyRequestDto.description(),
                rentalPropertyRequestDto.town(),
                rentalPropertyRequestDto.address(),
                new PropertyTypeEntity(rentalPropertyRequestDto.propertyType()),
                rentalPropertyRequestDto.rentAmount(),
                rentalPropertyRequestDto.securityDepositAmount(),
                rentalPropertyRequestDto.area(),
                rentalPropertyRequestDto.bedroomsCount(),
                rentalPropertyRequestDto.floorNumber(),
                rentalPropertyRequestDto.numberOfFloors(),
                Character.forDigit(rentalPropertyRequestDto.constructionYear(), 10) ,
                new EnergyClassificationEntity(rentalPropertyRequestDto.energyClassification()),
                rentalPropertyRequestDto.hasElevator(),
                rentalPropertyRequestDto.hasIntercom(),
                rentalPropertyRequestDto.hasBalcony(),
                rentalPropertyRequestDto.hasParkingSpace());
    }

}
