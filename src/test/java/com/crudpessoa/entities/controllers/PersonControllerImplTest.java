package com.crudpessoa.entities.controllers;

import com.crudpessoa.controllers.PersonControllerImpl;
import com.crudpessoa.services.PersonService;
import com.crudpessoa.entities.Person;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@MicronautTest
@ExtendWith(MockitoExtension.class)
public class PersonControllerImplTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonControllerImpl sut;

    @Test
    void shouldReturnPersonWhenIdValid() {

        Long id = 1L;
        Person personResponse = new Person("Natali", 30, "VALID_CPF");

        when(personService.showPerson(id)).thenReturn(personResponse);

        Person response = sut.show(id);
        assertNotNull(response);
        assertEquals(personResponse, response);
        assertEquals("Natali", response.getName());
        assertEquals(30, response.getAge());
        assertEquals("VALID_CPF", response.getCpf());

        verify(personService, times(1)).showPerson(id);

    }

    @Test
    void shouldReturnNullWhenIdInvalid() {

        Long id = 2L;

        when(personService.showPerson(id)).thenReturn(null);

        Person response = sut.show(id);
        assertNull(response);

        verify(personService, times(1)).showPerson(id);

    }

    @Test
    void shouldReturnListWhenListNoEmpty() {

        List<Person> personResponse = new ArrayList<>();
        personResponse.add(new Person("Natali", 45, "VALID_CPF"));
        personResponse.add(new Person("João", 27, "VALID_CPF"));

        when(personService.listPerson()).thenReturn(personResponse);

        List<Person> response = sut.list();
        assertNotNull(response);
        assertEquals(personResponse, response);
        assertEquals(2, response.size());

        verify(personService, times(1)).listPerson();

    }

    @Test
    void shouldReturnListEmptytWhenListEmpty() {

        List<Person> personResponse = new ArrayList<>();

        when(personService.listPerson()).thenReturn(personResponse);

        List<Person> response = sut.list();
        assertNotNull(response);
        assertEquals(0, response.size());

        verify(personService, times(1)).listPerson();

    }

    @Test
    void shoulCreatPersonWhenValidPerson() {

        Person personRequest = new Person("Natali", 30, "VALID_CPF");

        when(personService.savePerson(personRequest)).thenReturn(HttpResponse.created(personRequest));

        HttpResponse response = sut.save(personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatus());

        verify(personService, times(1)).savePerson(personRequest);

    }

    @Test
    void shouldReturnBadRequestWhenInvalidPerson() {

        Person personRequest = new Person("Natali", 30, "");

        when(personService.savePerson(personRequest)).thenReturn(HttpResponse.badRequest(personRequest));

        HttpResponse response = sut.save(personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());

        verify(personService, times(1)).savePerson(personRequest);

    }

    @Test
    void shouldReturnOkWhenUpdatePerson() {

        Long id = 3L;
        Person personRequest = new Person("Natali", 30, "VALID_CPF");

        when(personService.updatePerson(id, personRequest)).thenReturn(HttpResponse.ok(personRequest));

        HttpResponse response = sut.update(id, personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatus());

        verify(personService, times(1)).updatePerson(id, personRequest);

    }

    @Test
    void shouldReturnBadRequestWhenInvalidCpf() {

        Long id = 5L;
        Person personRequest = new Person("Maria", 12, "");

        when(personService.updatePerson(id, personRequest)).thenReturn(HttpResponse.badRequest(personRequest));

        HttpResponse response = sut.update(id, personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());

        verify(personService, times(1)).updatePerson(id, personRequest);

    }

    @Test
    void shouldReturnNotFoundWhenNotFoundPerson() {

        Long id = 5L;
        Person personRequest = new Person("Maria", 12, "VALID_CPF");

        when(personService.updatePerson(id, personRequest)).thenReturn(HttpResponse.notFound(personRequest));

        HttpResponse response = sut.update(id, personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatus());

        verify(personService, times(1)).updatePerson(id, personRequest);

    }

    @Test
    void shouldReturnNoContentWhenDeletePerson() {

        Long id = 5L;

        when(personService.deletePerson(id)).thenReturn(HttpResponse.noContent());

        HttpResponse response = sut.delete(id);
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());

        verify(personService, times(1)).deletePerson(id);

    }

    @Test
    void shouldReturnNotFoundWhenNotDeletePerson() {

        Long id = 5L;

        when(personService.deletePerson(id)).thenReturn(HttpResponse.notFound());

        HttpResponse response = sut.delete(id);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatus());

        verify(personService, times(1)).deletePerson(id);

    }

}

