package ru.edu.penzgtu.lab.shopsandshopkeepers.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @ManyToMany
    @JoinTable(
            name = "shopkeepers_shops",
            joinColumns = @JoinColumn(name = "shopkeeper_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("shops")
    private List<Shopkeeper> shopkeepers;
}
