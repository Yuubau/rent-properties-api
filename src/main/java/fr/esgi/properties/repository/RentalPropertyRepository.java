package fr.esgi.properties.repository;

import fr.esgi.properties.domain.RentalPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentalPropertyRepository extends JpaRepository<RentalPropertyEntity, Integer> {

}
