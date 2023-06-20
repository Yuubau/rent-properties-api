package fr.esgi.properties.samples;

import fr.esgi.properties.domain.EnergyClassificationEntity;
import fr.esgi.properties.domain.PropertyTypeEntity;
import fr.esgi.properties.domain.RentalPropertyEntity;

import java.util.List;
import java.util.UUID;

public class RentalPropertyEntitySample {

    public static List<RentalPropertyEntity> rentalPropertyEntities() {
        RentalPropertyEntity rentalProperty = oneRentalPropertyEntity();

        return List.of(rentalProperty);
    }

    public static RentalPropertyEntity oneRentalPropertyEntity() {
        return new RentalPropertyEntity(
                1,
                "Appartement spacieux avec vue sur l'ESGI",
                "Paris",
                "77 Rue des roses",
                new PropertyTypeEntity( "Appartement"),
                750.90,
                1200.90,
                37.48,
                2,
                1,
                3,
                (char) 1990,
                new EnergyClassificationEntity( "B"),
                false,
                false,
                true,
                false);
    }

}
