package com.crudpessoa.repositories;

import com.crudpessoa.entities.Person;
import com.crudpessoa.validations.ValidateCPF;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
public class PersonRepositoryImpl implements PersonRepository {

    public EntityManager entityManager;

    public ValidateCPF validateCPF;

    public PersonRepositoryImpl(EntityManager entityManager,
                                ValidateCPF validateCPF) {
        this.entityManager = entityManager;
        this.validateCPF = validateCPF;
    }

    @Override
    @ReadOnly
    public Optional<Person> findById(@NotNull Long id) {
        Person person = entityManager.find(Person.class, id);
        return Optional.ofNullable(person);
    }

    @Override
    @ReadOnly
    public List<Person> findAll() {
        String qlString = "SELECT e FROM Person as e";
        TypedQuery<Person> query = entityManager.createQuery(qlString, Person.class);
        query.setMaxResults(50);
        return query.getResultList();
    }


    @Override
    @TransactionalAdvice
    public Person save(@NotBlank String name, @NotNull int age, String CPF) {
        if (validateCPF.isCpf(CPF)) {
            String cpf = CPF.replaceAll("[./-]", "");
            Person pessoa = new Person(name, age, CPF);
            entityManager.persist(pessoa);
            return pessoa;
        }
        return null;
    }


    @Override
    @TransactionalAdvice

    public boolean deleteById(@NotNull Long id) {
        if (findById(id).isPresent()) {
            Person person = entityManager.find(Person.class, id);
            entityManager.remove(person);
            return true;
        }
        return false;
    }


    @Override
    @TransactionalAdvice
    public int update(Long id, @NotBlank String name, @NotNull int age, @NotNull String CPF) {
        if (validateCPF.isCpf(CPF)) {
            String cpf = CPF.replaceAll("[./-]", "");
            return entityManager.createQuery("UPDATE Person p SET name = :name, age =: age, cpf =: cpf where id = :id")
                    .setParameter("name", name)
                    .setParameter("id", id)
                    .setParameter("age", age)
                    .setParameter("cpf", cpf)
                    .executeUpdate();
        }
        return 0;
    }
}

