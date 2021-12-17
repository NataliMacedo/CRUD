package com.crudpessoa.controllers;

import com.crudpessoa.entities.Person;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface PersonController {

    @Get("/{id}")
    Person show(Long id);

    @Get("/")
    List<Person> list();

    @Post("/")
    HttpResponse save(@Body @Valid Person person);

    @Put("/{id}")
    HttpResponse update(Long id, @Body @Valid Person person);

    @Delete("/{id}")
    HttpResponse delete(Long id);

}

