package com.crudpessoa.entities.repositories;

import com.crudpessoa.entities.Person;
import com.crudpessoa.repositories.PersonRepositoryImpl;
import com.crudpessoa.validations.ValidateCPF;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@MicronautTest
@ExtendWith(MockitoExtension.class)
class PersonRepositoryImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private ValidateCPF validateCPF;

    @InjectMocks
    private PersonRepositoryImpl sut;

    @Test
    void shouldReturnPersonWhenIdValid() {

        Long id = 5L;
        Person personResponse = new Person("Natali", 30, "VALID_CPF");

        when(entityManager.find(Person.class, id)).thenReturn(personResponse);

        Optional<Person> response = sut.findById(id);
        Person person = response.get();

        assertNotNull(response);
        assertEquals("Natali", person.getName());
        assertEquals(30, person.getAge());
        assertEquals("VALID_CPF", person.getCpf());

        verify(entityManager, times(1)).find(Person.class, id);

    }

    @Test
    void shouldReturnNullWhenIdInvalid() {
        Long id = 5L;

        when(entityManager.find(Person.class, id)).thenReturn(null);

        Optional<Person> response = sut.findById(id);
        assertNotNull(response);
        assertEquals(Optional.empty(), response);

        verify(entityManager, times(1)).find(Person.class, id);

    }

    @Test
    void shouldReturnListPersonWhenExistPerson() {

        TypedQuery<Person> query = mock(TypedQuery.class);

        List<Person> personResponse = new ArrayList<>();
        personResponse.add(new Person("Natali", 45, "VALID_CPF"));
        personResponse.add(new Person("Paulo", 22, "VALID_CPF"));

        when(entityManager.createQuery(any(String.class), eq(Person.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(personResponse);

        List<Person> response = sut.findAll();
        assertNotNull(response);
        assertEquals(2, response.size());

        verify(entityManager, times(1)).createQuery(any(String.class), eq(Person.class));

    }

    @Test
    void shouldReturnListEmptyWhenListEmpty() {

        TypedQuery<Person> query = mock(TypedQuery.class);

        List<Person> personResponse = new ArrayList<>();

        when(entityManager.createQuery(any(String.class), eq(Person.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(personResponse);

        List<Person> response = sut.findAll();
        assertNotNull(response);
        assertEquals(0, response.size());

        verify(entityManager, times(1)).createQuery(any(String.class), eq(Person.class));

    }

    @Test
    void shouldCreatPersonWhenPersonValid() {

        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("Natali", 45, "VALID_CPF"));
        listPerson.add(new Person("Paulo", 22, "VALID_CPF"));

        TypedQuery<Person> typedQuery = mock(TypedQuery.class);

        when(validateCPF.isCpf("09922236605")).thenReturn(true);
        when(validateCPF.doublecpf(eq("09922236605"), any())).thenReturn(false);
        doReturn(typedQuery).when(entityManager).createQuery(anyString(), any());
        when(typedQuery.getResultList()).thenReturn(listPerson);

        Person response = sut.save("Pedro", 30, "09922236605");

        assertNotNull(response);
        assertEquals("Pedro", response.getName());
        assertEquals(30, response.getAge());
        assertEquals("09922236605", response.getCpf());

        verify(validateCPF, times(1)).isCpf("09922236605");
        verify(validateCPF, times(1)).doublecpf("09922236605", listPerson);
        verify(entityManager, times(1)).persist(response);

    }

    @Test
    void shouldReturnNullWhenPersonInvalid() {

        when(validateCPF.isCpf("INVALID_CPF")).thenReturn(false);

        Person response = sut.save("Natali", 30, "INVALID_CPF");
        assertNull(response);

        verify(validateCPF, times(1)).isCpf("INVALID_CPF");
        verify(entityManager, never()).persist(response);

    }

    @Test
    void shouldReturnTrueWhenDeletePerson() {

        Long id = 9L;
        Person personResponse = new Person("Natali", 30, "VALID_CPF");
        sut.findById(id).isPresent();

        when(entityManager.find(Person.class, id)).thenReturn(personResponse);

        boolean response = sut.deleteById(id);
        assertNotNull(response);
        assertEquals(true, response);

        verify(entityManager, times(3)).find(Person.class, id);
        verify(entityManager, times(1)).remove(personResponse);

    }

    @Test
    void shouldReturnFalseWhenNotFoundPerson() {

        Long id = 9L;
        Person personResponse = new Person("Natali", 30, "VALID_CPF");
        sut.findById(id).isPresent();

        when(entityManager.find(Person.class, id)).thenReturn(null);

        boolean response = sut.deleteById(id);
        assertNotNull(response);
        assertEquals(false, response);

        verify(entityManager, times(2)).find(Person.class, id);
        verify(entityManager, never()).remove(personResponse);

    }

    @Test
    void shouldReturn1WhenUpdatePerson() {

        Long id = 15L;
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("Natali", 45, "006.996.000-30"));
        listPerson.add(new Person("Paulo", 22, "100.283.880-03"));

        TypedQuery<Person> typedQuery = mock(TypedQuery.class);
        Query query = mock(Query.class);

        when(validateCPF.isCpf("09922236605")).thenReturn(true);
        doReturn(typedQuery).when(entityManager).createQuery(anyString(), any());
        when(typedQuery.getResultList()).thenReturn(listPerson);
        doReturn(query).when(entityManager).createQuery(any(String.class));
        when(query.setParameter(any(String.class), any())).thenReturn(query);
        when(query.executeUpdate()).thenReturn(1);

        int response = sut.update(id, "Natali", 30, "09922236605");
        assertNotNull(response);
        assertEquals(1, response);

        verify(validateCPF, times(1)).isCpf("09922236605");
        verify(entityManager, times(1)).createQuery(any(String.class));

    }

    @Test
    void shouldReturn0WhenUpdatePerson() {

        Long id = 15L;

        when(validateCPF.isCpf("09922236605")).thenReturn(false);

        int response = sut.update(id, "Natali", 30, "09922236605");
        assertNotNull(response);
        assertEquals(0, response);

        verify(validateCPF, times(1)).isCpf("09922236605");

    }

}
