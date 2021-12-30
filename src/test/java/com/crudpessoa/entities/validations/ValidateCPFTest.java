package com.crudpessoa.entities.validations;

import com.crudpessoa.entities.Person;
import com.crudpessoa.validations.ValidateCPF;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@MicronautTest
@ExtendWith(MockitoExtension.class)
class ValidateCPFTest {

    @InjectMocks
    private ValidateCPF sut;

    @Test
    public void shouldReturnTrueWhenCpfValid() {
        String cpf = "09922236605";
        assertTrue(sut.isCpf(cpf));
    }

    @Test
    public void shouldReturnFalseWhenCpfInvalid() {
        String cpf = "09922236435";
        assertFalse(sut.isCpf(cpf));
    }

    @Test
    public void shouldReturnFalseWhenCpfIsNotDouble() {
        String cpf = "09922236435";
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("Natali", 45, "VALID_CPF"));
        listPerson.add(new Person("Paulo", 22, "VALID_CPF"));

        assertFalse(sut.doublecpf(cpf, listPerson));
    }

    @Test
    public void shouldReturnTrueWhenCpfIsDouble() {
        String cpf = "09922236435";
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("Natali", 45, "09922236435"));
        listPerson.add(new Person("Paulo", 22, "VALID_CPF"));

        assertTrue(sut.doublecpf(cpf, listPerson));
    }

}
