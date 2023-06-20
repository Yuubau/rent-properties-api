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
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

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
    public RentalPropertyResponseDto getRentalPropertyById(@PathVariable Integer id) {
        return rentalPropertyRepository.findById(id)
                .map(rentalPropertyDtoMapper::mapToDto)
                .orElseThrow(() -> new NotFoundRentalPropertyException("Le bien immobilier " + id + " est introuvable"));
    }

    @PostMapping("/rental-properties")
    @ResponseStatus(CREATED)
    public RentalPropertyResponseDto createRentalProperty(@Valid @RequestBody RentalPropertyRequestDto rentalPropertyRequestDto) {
        RentalPropertyEntity rentalPropertyEntity = rentalPropertyDtoMapper.mapToEntity(rentalPropertyRequestDto);

        RentalPropertyEntity savedRentalProperty = rentalPropertyRepository.save(rentalPropertyEntity);

        return  rentalPropertyDtoMapper.mapToDto(savedRentalProperty);
    }

    @PutMapping("/rental-properties/{id}")
    public RentalPropertyResponseDto createOrUpdateRentalProperty(@Valid @RequestBody RentalPropertyRequestDto rentalPropertyRequestDto, @Valid @PathVariable Integer id) {
        RentalPropertyEntity entity = rentalPropertyDtoMapper.mapToEntity(rentalPropertyRequestDto);
        entity.setId(id);
        RentalPropertyEntity savedRentalProperty = rentalPropertyRepository.save(entity);
        return  rentalPropertyDtoMapper.mapToDto(savedRentalProperty);
    }

    @PatchMapping("/rental-properties/{id}")
    public RentalPropertyResponseDto updateRentalProperty(@Valid @RequestBody RentalPropertyRequestDto rentalPropertyRequestDto, @Valid @PathVariable Integer id) {
        Optional<RentalPropertyEntity> opEntity = rentalPropertyRepository.findById(id);
        if(opEntity.isPresent()) {
            RentalPropertyEntity savedRentalProperty = rentalPropertyRepository.save(opEntity.get());
            return  rentalPropertyDtoMapper.mapToDto(savedRentalProperty);
        } else {
            throw new NotFoundRentalPropertyException("Le bien immobilier " + id + " est introuvable");
        }

    }

    @DeleteMapping("/rental-properties/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteRentalProperty(@Valid @PathVariable Integer id) {

        Optional<RentalPropertyEntity> res = rentalPropertyRepository.findById(id);
        if(res.isPresent()) {
            rentalPropertyRepository.delete(res.get());
        } else {
            return;
        }
    }

}
