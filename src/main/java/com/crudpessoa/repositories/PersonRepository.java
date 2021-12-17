package com.crudpessoa.repositories;

import com.crudpessoa.entities.Person;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Optional<Person> findById(@NotNull Long id);

    List<Person> findAll();

    Person save(@NotBlank String name, @NotBlank int age, @NotNull String cpf);

    boolean deleteById(@NotNull Long id);

    int update(Long id, @NotBlank String name, @NotNull int age, @NotNull String cpf);

}

