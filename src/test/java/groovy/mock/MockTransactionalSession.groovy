package groovy.mock

import io.micronaut.configuration.hibernate.jpa.TransactionalSession$Intercepted
import io.micronaut.context.BeanContext
import io.micronaut.context.Qualifier
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires

@Primary
@Singleton(strict = false)
@Requires(property = "mockTransactionalSession", value = "true")
class MockTransactionalSession extends TransactionalSession$Intercepted {
    MockTransactionalSession(BeanContext beanContext, Qualifier qualifier, List list) {
        super(beanContext, qualifier, list)
    }
}
