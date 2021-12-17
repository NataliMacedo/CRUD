package com.crudpessoa.entities.validations;

import com.crudpessoa.validations.ValidateCPF;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

}
