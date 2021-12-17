package com.crudpessoa.entities.services;

import com.crudpessoa.entities.Person;
import com.crudpessoa.repositories.PersonRepository;
import com.crudpessoa.services.PersonService;
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
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@MicronautTest
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonService sut;

    @Test
    void shouldReturnPersonWhenIdValid() {

        Long id = 1L;
        Person personResponse = new Person("Natali", 30, "VALID_CPF");

        when(personRepository.findById(id)).thenReturn(Optional.of(personResponse));

        Person response = sut.showPerson(id);
        assertNotNull(response);
        assertEquals(personResponse, response);
        assertEquals("Natali", response.getName());

        verify(personRepository, times(1)).findById(id);

    }

    @Test
    void shouldReturnNullWhenIdInvalid() {

        Long id = 2L;

        when(personRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        Person response = sut.showPerson(id);
        assertNull(response);

        verify(personRepository, times(1)).findById(id);

    }

    @Test
    void shouldReturnListPersonWhenExistPerson() {

        List<Person> personResponse = new ArrayList<>();
        personResponse.add(new Person("Natali", 45, "VALID_CPF"));

        when(personRepository.findAll()).thenReturn(personResponse);

        List<Person> response = sut.listPerson();
        assertNotNull(response);
        assertEquals(personResponse, response);

        verify(personRepository, times(1)).findAll();

    }

    @Test
    void shouldReturnListEmptyWhenListEmpty() {

        List<Person> personResponse = new ArrayList<>();

        when(personRepository.findAll()).thenReturn(personResponse);

        List<Person> response = sut.listPerson();
        assertNotNull(response);
        assertEquals(0, response.size());

        verify(personRepository, times(1)).findAll();

    }

    @Test
    void shouldCreatePersonWhenValidPerson() {

        Person personRequest = new Person("Natali", 30, "VALID_CPF");
        Person personResponse = new Person("Natali", 30, "VALID_CPF");

        when(personRepository.save("Natali", 30, "VALID_CPF")).thenReturn(personResponse);

        HttpResponse response = sut.savePerson(personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatus());

        Person personBody = (Person) response.getBody().get();
        assertEquals(personResponse, personBody);

        verify(personRepository, times(1)).save("Natali", 30, "VALID_CPF");

    }

    @Test
    void shouldReturnBadRequestWhenInvalidPerson() {

        Person personRequest = new Person("", 30, "VALID_CPF");

        when(personRepository.save("", 30, "VALID_CPF")).thenReturn(null);

        HttpResponse response = sut.savePerson(personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());

        verify(personRepository, times(1)).save("", 30, "VALID_CPF");

    }

    @Test
    void shouldReturnNoContentWhenDeletePerson() {

        Long id = 5L;
        Person personResponse = new Person("Natali", 30, "VALID_CPF");

        when(personRepository.findById(id)).thenReturn(java.util.Optional.of(personResponse));
        when(personRepository.deleteById(id)).thenReturn(false);

        HttpResponse response = sut.deletePerson(id);
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());

        verify(personRepository, times(1)).findById(id);
        verify(personRepository, times(1)).deleteById(id);

    }

    @Test
    void shouldReturnNotFoundWhenNotDeletePerson() {

        Long id = 5L;

        when(personRepository.findById(id)).thenReturn(Optional.ofNullable(null));

        HttpResponse response = sut.deletePerson(id);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatus());

        verify(personRepository, times(1)).findById(id);

    }

    @Test
    void shouldReturnOkWhenUpdateValidPerson() {

        Long id = 6L;
        Person personRequest = new Person("Natali", 30, "VALID_CPF");
        Person personResponse = new Person("Natali", 30, "VALID_CPF");
        personRequest.setId(id);

        when(personRepository.findById(id)).thenReturn(java.util.Optional.of(personResponse));
        when(personRepository.update(id, "Natali", 30, "VALID_CPF")).thenReturn(1);

        HttpResponse response = sut.updatePerson(id, personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatus());

        verify(personRepository, times(1)).findById(id);
        verify(personRepository, times(1)).update(id, "Natali", 30, "VALID_CPF");

    }

    @Test
    void shouldReturnNotFoundWhenIdInvalid() {

        Long id = 6L;
        Person personRequest = new Person("Natali", 30, "VALID_CPF");
        personRequest.setId(9L);

        HttpResponse response = sut.updatePerson(id, personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatus());

        verify(personRepository, never()).findById(id);
        verify(personRepository, never()).update(id, "Natali", 30, "VALID_CPF");

    }

    @Test
    void shouldReturnNotFoundWhenNotFoundPerson() {

        Long id = 6L;
        Person personRequest = new Person("Natali", 30, "VALID_CPF");
        personRequest.setId(id);

        when(personRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(null));

        HttpResponse response = sut.updatePerson(id, personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatus());

        verify(personRepository, times(1)).findById(id);
        verify(personRepository, never()).update(id, "Natali", 30, "VALID_CPF");

    }

    @Test
    void shouldReturnBadRequestWhenInvalidCpf() {

        Long id = 6L;
        Person personRequest = new Person("Natali", 30, "INVALID_CPF");
        Person personResponse = new Person("Natali", 30, "INVALID_CPF");
        personRequest.setId(id);

        when(personRepository.findById(id)).thenReturn(java.util.Optional.of(personResponse));
        when(personRepository.update(id, "Natali", 30, "INVALID_CPF")).thenReturn(0);

        HttpResponse response = sut.updatePerson(id, personRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());

        verify(personRepository, times(1)).findById(id);
        verify(personRepository, times(1)).update(id, "Natali", 30, "INVALID_CPF");

    }

}

