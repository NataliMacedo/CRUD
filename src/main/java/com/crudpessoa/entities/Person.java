package com.crudpessoa.entities;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
@Introspected

public class Person {

    public Person() {
    }

    public Person(@NotBlank @NotNull String name, @NotNull int age, @NotNull String cpf) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "name", nullable = false)
    public String name;

    @Min(1)
    @NotNull
    @Column(name = "age", nullable = false)
    private int age;

    @NotNull
    @Column(name = "cpf", nullable = false)
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

