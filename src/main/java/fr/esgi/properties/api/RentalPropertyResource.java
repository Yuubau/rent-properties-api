package fr.esgi.properties.api;

import fr.esgi.properties.domain.RentalPropertyEntity;
import fr.esgi.properties.dto.request.RentalPropertyRequestDto;
import fr.esgi.properties.dto.response.RentalPropertyResponseDto;
import fr.esgi.properties.exception.NotFoundRentalPropertyException;
import fr.esgi.properties.mapper.RentalPropertyDtoMapper;
import fr.esgi.properties.repository.RentalPropertyRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/rent-properties-api")
public class RentalPropertyResource {

    private final RentalPropertyRepository rentalPropertyRepository;
    private final RentalPropertyDtoMapper rentalPropertyDtoMapper;

    public RentalPropertyResource(RentalPropertyRepository rentalPropertyRepository,
                                  RentalPropertyDtoMapper rentalPropertyDtoMapper) {
        this.rentalPropertyRepository = rentalPropertyRepository;
        this.rentalPropertyDtoMapper = rentalPropertyDtoMapper;
    }

    @GetMapping("/rental-properties")
    public List<RentalPropertyResponseDto> getRentalProperties() {
        List<RentalPropertyEntity> rentalProperties = rentalPropertyRepository.findAll();

        return rentalPropertyDtoMapper.mapToDtoList(rentalProperties);
    }

    @GetMapping("/rental-properties/{id}")
    public RentalPropertyResponseDto getRentalPropertyById(@PathVariable String id) {
        return rentalPropertyRepository.findById(UUID.fromString(id))
                .map(rentalPropertyDtoMapper::mapToDto)
                .orElseThrow(() -> new NotFoundRentalPropertyException("Le bien immobilier " + id + " est introuvable"));
    }

    @PostMapping("/rental-properties")
    @ResponseStatus(CREATED)
    public RentalPropertyResponseDto createRentalProperty(@Valid @RequestBody RentalPropertyRequestDto rentalPropertyRequestDto) {
        RentalPropertyEntity rentalPropertyEntity = rentalPropertyDtoMapper.mapToEntity(rentalPropertyRequestDto);

        RentalPropertyEntity savedRentalProperty = rentalPropertyRepository.save(rentalPropertyEntity);

        return rentalPropertyDtoMapper.mapToDto(savedRentalProperty);
    }

}
