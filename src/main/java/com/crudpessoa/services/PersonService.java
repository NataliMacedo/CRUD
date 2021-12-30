package com.crudpessoa.services;

import com.crudpessoa.entities.Person;
import com.crudpessoa.repositories.PersonRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import jakarta.inject.Singleton;

import javax.validation.Valid;
import java.util.List;

@Singleton
public class PersonService {

    protected final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person showPerson(Long id) {
        return personRepository
                .findById(id)
                .orElse(null);
    }

    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    public HttpResponse updatePerson(Long id, @Body @Valid Person person) {
        if (id == person.getId()) {
            if (personRepository.findById(id).isPresent()) {
                String cpf = person.getCpf().replaceAll("[./-]", "");
                int validcpf = personRepository.update(person.getId(), person.getName(), person.getAge(), cpf);
                if (validcpf > 0) {
                    Person pessoacpf = new Person(person.getName(), person.getAge(), cpf);
                    return HttpResponse.ok(pessoacpf);
                }
                return HttpResponse.badRequest("O cpf informado é inválido ou já se encontra cadastrado.");
            }
            return HttpResponse.notFound();
        }
        return HttpResponse.notFound().body("O id informado no body não corresponde ao id informado na url.");
    }

//    public HttpResponse updatePerson(Long id, @Body @Valid Person person) {
//        if (id == person.getId()) {
//            if (personRepository.findById(id).isPresent()) {
//                String cpf = person.getCpf().replaceAll("[./-]", "");
//                int validcpf = personRepository.update(person.getId(), person.getName(), person.getAge(), cpf);
//                if (validcpf > 0) {
//                    Person pessoacpf = new Person(person.getName(), person.getAge(), cpf);
//                    return HttpResponse.ok(pessoacpf);
//                }
//                return HttpResponse.badRequest("O cpf informado é inválido ou já se encontra cadastrado.");
//            }
//            return HttpResponse.notFound();
//        }
//        return HttpResponse.notFound().body("O id informado no body não corresponde ao id informado na url.");
//    }

    public HttpResponse savePerson(@Body @Valid Person person) {
        Person newPerson = personRepository.save(person.getName(), person.getAge(), person.getCpf());
        if (newPerson == null) {
            return HttpResponse.badRequest("O cpf informado é inválido ou já se encontra cadastrado.");
        } else return HttpResponse.created(newPerson);
    }

    public HttpResponse deletePerson(Long id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            return HttpResponse.noContent();
        } else {
            return HttpResponse.notFound().body("Não foi possível deletar a pessoa de id " + id + ", pois ela não foi encontrada.");
        }
    }
}

