package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

@Entity(name = "address")
@SecondaryTables({
        @SecondaryTable(name="city"),
        @SecondaryTable(name="country")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private Long id;

    private Long house;

    private String street;

    @Column(table="city")
    private String city;

    @Column(table="city")
    private String state;

    @Column(table="city")
    private String zipCode;

    @Column(table="country")
    private String countryName;

    @Column(table="country")
    private String countryNCode;
}
