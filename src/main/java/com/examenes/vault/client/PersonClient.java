package com.examenes.vault.client;

import com.examenes.vault.dto.PersonDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonClient {

    public PersonDto findAll() {
        ResponseEntity<PersonDto> values = new RestTemplate().exchange("https://retoolapi.dev/wNZKQD/data/1", HttpMethod.GET, null, PersonDto.class);

        return values.getBody();
    }
}
