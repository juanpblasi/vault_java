package com.examenes.vault.repository.model;

import com.examenes.vault.domain.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country")
public class CountryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    Long countryId;
    @Column(name = "country_name")
    String countryName;
    @ManyToOne(targetEntity = RegionModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "regionFK", referencedColumnName = "region_id", nullable = false, updatable = false)
    RegionModel region;
    @OneToMany
    List<LocationModel> location;

}
