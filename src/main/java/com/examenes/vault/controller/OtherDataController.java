package com.examenes.vault.controller;

import com.examenes.vault.client.PersonClient;
import com.examenes.vault.dto.PersonDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("data")
@AllArgsConstructor
public class OtherDataController {

    private PersonClient personClient;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonDto findAll() {
        return personClient.findAll();
    }

}
