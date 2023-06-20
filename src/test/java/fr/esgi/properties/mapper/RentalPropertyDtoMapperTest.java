package fr.esgi.properties.mapper;

import fr.esgi.properties.domain.PropertyTypeEntity;
import fr.esgi.properties.domain.RentalPropertyEntity;
import fr.esgi.properties.dto.request.RentalPropertyRequestDto;
import fr.esgi.properties.dto.response.RentalPropertyResponseDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.esgi.properties.samples.RentalPropertyDtoSample.oneRentalPropertyResponse;
import static fr.esgi.properties.samples.RentalPropertyEntitySample.oneRentalPropertyEntity;
import static fr.esgi.properties.samples.RentalPropertyEntitySample.rentalPropertyEntities;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RentalPropertyDtoMapperTest {

    @Test
    void shouldMapToDto() {
        RentalPropertyEntity rentalPropertyEntity = oneRentalPropertyEntity();
        RentalPropertyResponseDto expectedRentalPropertyResponseDto = oneRentalPropertyResponse();

        RentalPropertyDtoMapper rentalPropertyDtoMapper = new RentalPropertyDtoMapper();

        RentalPropertyResponseDto rentalPropertyResponseDto = rentalPropertyDtoMapper.mapToDto(rentalPropertyEntity);

        assertThat(rentalPropertyResponseDto).isEqualTo(expectedRentalPropertyResponseDto);
    }

    @Test
    void shouldMapToDtoList() {
        List<RentalPropertyEntity> rentalPropertyEntities = rentalPropertyEntities();

        RentalPropertyDtoMapper rentalPropertyDtoMapper = new RentalPropertyDtoMapper();

        List<RentalPropertyResponseDto> rentalPropertyResponseList = rentalPropertyDtoMapper.mapToDtoList(rentalPropertyEntities);

        assertThat(rentalPropertyResponseList).isNotNull()
                .hasSize(1)
                .extracting("description", "address", "town", "propertyType", "rentAmount", "securityDepositAmount", "area")
                .containsExactlyInAnyOrder(
                        tuple("Appartement spacieux avec vue sur l'ESGI",
                                "77 Rue des roses",
                                "Paris",
                                "Appartement",
                                750.90,
                                1200.90,
                                37.48)
                );
    }

    @Test
    void shouldMapToEntity() {
        RentalPropertyRequestDto dto = new RentalPropertyRequestDto(
                "Test",
                "Paris",
                "242 rue du faubourg saint antoine",
                null,
                1000.00d,
                2000.00d,
                10.00d,
                3,
                2,
                6,
                (char)2003,
                null,
                true,
                true,
                true,
                true
        );

        RentalPropertyDtoMapper rentalPropertyDtoMapper = new RentalPropertyDtoMapper();
        RentalPropertyEntity entity = rentalPropertyDtoMapper.mapToEntity(dto);
        assertThat(entity).hasFieldOrPropertyWithValue("securityDepositAmount", 2000.00d);
    }

}
