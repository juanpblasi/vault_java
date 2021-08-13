package com.examenes.vault.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locations")
public class LocationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    Long locationId;
    @Column(name="street_address")
    String streetAddress;
    @Column(name="postal_code")
    String postalCode;
    @Column(name="city")
    String city;
    @Column(name="state_province")
    String stateProvince;
    @ManyToOne(targetEntity = CountryModel.class,cascade = CascadeType.ALL)
    @JoinColumn(name="country_id", nullable=false, updatable=false)
    CountryModel country;
}
