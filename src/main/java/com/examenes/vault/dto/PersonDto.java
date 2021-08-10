package com.examenes.vault.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    Long id;
    @JsonProperty("Name")
    String name;
    @JsonProperty("Rating")
    Boolean rating;
}
