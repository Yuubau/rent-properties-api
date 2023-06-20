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
@Table(name = "property_type")
public class PropertyTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Integer id;

    @Column(name = "designation", length = 5)
    private String designation;

    public PropertyTypeEntity() {

    }

    public PropertyTypeEntity(String designation) {
        this.designation = designation;
    }

    public PropertyTypeEntity(Integer id, String designation) {
        this.id = id;
        this.designation = designation;
    }
}
