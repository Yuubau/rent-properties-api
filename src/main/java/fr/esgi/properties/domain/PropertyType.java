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
@Table(name = "property_type")
public class PropertyType {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "designation", length = 5)
    private String designation;
}
