package fr.esgi.properties.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "energy_classification")
public class EnergyClassificationEntity {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "designation", length = 1)
    private String designation;

    public EnergyClassificationEntity() {

    }

    public EnergyClassificationEntity(String designation) {
        this.designation = designation;
    }

    public EnergyClassificationEntity(Integer id, String designation) {
        this.id = id;
        this.designation = designation;
    }

}
