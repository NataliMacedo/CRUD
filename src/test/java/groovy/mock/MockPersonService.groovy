package groovy.mock

import com.crudpessoa.entities.Person
import com.crudpessoa.repositories.PersonRepository
import com.crudpessoa.services.PersonService
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires

@Primary
@Singleton(strict = false)
@Requires(property = "mockPersonService", value = "true")
class MockPersonService extends PersonService {

    MockPersonService(PersonRepository personRepository) {
        super (personRepository)
    }

    @Override
    public Person showPerson(Long id) {
        return null
    }
}
