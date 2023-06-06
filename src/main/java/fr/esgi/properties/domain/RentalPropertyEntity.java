package fr.esgi.properties.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_property")
public class RentalPropertyEntity {

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
    private PropertyType propertyType;


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


    @Column(name = "construction_year", length = 4)
    private Character constructionYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "energy_classification_id")
    private EnergyClassification energyClassification;

    @Column(name = "has_elevator")
    private Boolean hasElevator;

    @Column(name = "has_intercom")
    private Boolean hasIntercom;

    @Column(name = "has_balcony")
    private Boolean hasBalcony;

    @Column(name = "has_parking_space")
    private Boolean hasParkingSpace;
}
