package com.crudpessoa.entities.entities;

import com.crudpessoa.entities.Person;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class PersonTest {

    Person person;

    @Test
    public void shouldCreatePersonEmpthWhenEmpty() {
        person = new Person();
        assertNotNull(person);
    }

    @Test
    public void shouldCreatePersonWhenPersonValid() {

        person = new Person("natali", 13, "VALID_CPF");

        assertNotNull(person);
        assertEquals("natali", person.getName());
        assertEquals(13, person.getAge());
        assertEquals("VALID_CPF", person.getCpf());
    }
    /*
    @Test // ?????
    public void shouldReturnNullWhenPersonInvalid() {
        person = new Person("", 15, "09922236605");
        assertNull(person);
    }
   */
}
