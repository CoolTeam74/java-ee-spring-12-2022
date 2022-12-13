package org.example.enity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("I")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @NotNull
    private String title;
    @Size(min = 10, max = 1000)
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id; // depends on conditions
    private Double price;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "tags")
    private List<String> tags = new ArrayList<>();
}
