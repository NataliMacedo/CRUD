package groovy.mock

import com.crudpessoa.repositories.PersonRepositoryImpl
import com.crudpessoa.validations.ValidateCPF
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment

import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager


@Primary
@Singleton
@Requires(env = Environment.TEST)
@Requires(property = "mockPersonRepositoryImpl", value = "true")
class MockPersonRepositoryImpl extends PersonRepositoryImpl {


    @Inject
    public ValidateCPF validateCPF;

    MockPersonRepositoryImpl(ValidateCPF validateCPF) {
        super(new MockEntityManager(), validateCPF)
    }
}
