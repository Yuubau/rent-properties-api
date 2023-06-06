package fr.esgi.properties.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "rental_property")
public class RentalPropertyEntity {

    public RentalPropertyEntity() {

    }

    public RentalPropertyEntity(String description,
                                String town,
                                String address,
                                PropertyTypeEntity propertyType,
                                double rentAmount,
                                double securityDepositAmount,
                                double area,
                                int numberOfBedrooms,
                                int floorNumber,
                                int numberOfFloors,
                                char constructionYear,
                                EnergyClassificationEntity energyClassification,
                                boolean hasElevator,
                                boolean hasIntercom,
                                boolean hasBalcony,
                                boolean hasParkingSpace) {
        this.description = description;
        this.town = town;
        this.address = address;
        this.propertyType = propertyType;
        this.rentAmount = rentAmount;
        this.securityDepositAmount = securityDepositAmount;
        this.area = area;
        this.numberOfBedrooms = numberOfBedrooms;
        this.floorsNumber = floorNumber;
        this.numberOfFloors = numberOfFloors;
        this.constructionYear = constructionYear;
        this.energyClassification = energyClassification;
        this.hasElevator = hasElevator;
        this.hasIntercom = hasIntercom;
        this.hasBalcony = hasBalcony;
        this.hasParkingSpace = hasParkingSpace;
    }

    public RentalPropertyEntity(Integer id,
                                String description,
                                String town,
                                String address,
                                PropertyTypeEntity propertyType,
                                double rentAmount,
                                double securityDepositAmount,
                                double area,
                                int numberOfBedrooms,
                                int floorNumber,
                                int numberOfFloors,
                                char constructionYear,
                                EnergyClassificationEntity energyClassification,
                                boolean hasElevator,
                                boolean hasIntercom,
                                boolean hasBalcony,
                                boolean hasParkingSpace) {
        this.id = id;
        this.description = description;
        this.town = town;
        this.address = address;
        this.propertyType = propertyType;
        this.rentAmount = rentAmount;
        this.securityDepositAmount = securityDepositAmount;
        this.area = area;
        this.numberOfBedrooms = numberOfBedrooms;
        this.floorsNumber = floorNumber;
        this.numberOfFloors = numberOfFloors;
        this.constructionYear = constructionYear;
        this.energyClassification = energyClassification;
        this.hasElevator = hasElevator;
        this.hasIntercom = hasIntercom;
        this.hasBalcony = hasBalcony;
        this.hasParkingSpace = hasParkingSpace;
    }

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "description")
    private String description;


    @Column(name = "town")
    private String town;


    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_type_id")
    private PropertyTypeEntity propertyType;


    @Column(name = "rent_amount")
    private Double rentAmount;


    @Column(name = "security_deposit_amount")
    private Double securityDepositAmount;


    @Column(name = "area")
    private Double area;


    @Column(name = "number_of_bedrooms")
    private Integer numberOfBedrooms;


    @Column(name = "floors_number")
    private Integer floorsNumber;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @Column(name = "construction_year", length = 4)
    private Character constructionYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "energy_classification_id")
    private EnergyClassificationEntity energyClassification;

    @Column(name = "has_elevator")
    private Boolean hasElevator;

    @Column(name = "has_intercom")
    private Boolean hasIntercom;

    @Column(name = "has_balcony")
    private Boolean hasBalcony;

    @Column(name = "has_parking_space")
    private Boolean hasParkingSpace;
}
