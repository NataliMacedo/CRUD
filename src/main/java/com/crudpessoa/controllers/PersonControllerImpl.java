package com.crudpessoa.controllers;

import com.crudpessoa.entities.Person;
import com.crudpessoa.services.PersonService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/person")
public class PersonControllerImpl implements PersonController {

    protected final PersonService personService;

    public PersonControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Person show(Long id) {
        return personService.showPerson(id);
    }

    @Override
    public List<Person> list() {
        return personService.listPerson();
    }

    @Override
    public HttpResponse save(@Valid Person person) {
        return personService.savePerson(person);
    }

    @Override
    public HttpResponse update(Long id, @Valid Person person) {
        return personService.updatePerson(id, person);
    }

    @Override
    public HttpResponse delete(Long id) {
        return personService.deletePerson(id);
    }

}

