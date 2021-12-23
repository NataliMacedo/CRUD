package groovy.mock

import com.crudpessoa.entities.Person
import com.crudpessoa.repositories.PersonRepository
import com.crudpessoa.repositories.PersonRepositoryImpl
import com.crudpessoa.validations.ValidateCPF
import com.sun.istack.NotNull
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment

import javax.persistence.EntityManager
import static org.mockito.Mockito.mock

@Primary
@Singleton(strict = false)
@Requires(env = [Environment.TEST, Environment.MICRONAUT, Environment.DEVELOPMENT])
@Requires(property = "mockPersonRepository", value = "true")
class MockPersonRepository extends PersonRepositoryImpl {

    MockPersonRepository(EntityManager entityManager, ValidateCPF validateCPF) {
        super(entityManager, validateCPF)
    }



    @Override
    Optional<Person> findById(@NotNull Long id) {
        return null
    }

}
