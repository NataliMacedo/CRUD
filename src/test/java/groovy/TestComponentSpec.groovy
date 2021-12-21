package groovy

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import static org.assertj.core.api.Assertions.assertThat
import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class TestComponentSpec extends Specification {

    @AutoCleanup
    @Shared
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @AutoCleanup
    @Shared
    ApplicationContext applicationContext = embeddedServer.applicationContext

    @AutoCleanup
    @Shared
    HttpClient httpClient = applicationContext.createBean(HttpClient, embeddedServer.URL)

    BlockingHttpClient getClient() { httpClient.toBlocking() }


    void "retorna pessoa com sucesso"() {
        given:
        HttpRequest request = HttpRequest.GET ("localhost:8080/person/2")

        when:
        HttpResponse response = client.toBlocking().exchange(request)

        then:
        assertThat(response.status()).isEqualTo(HttpStatus.OK)
    }

}


