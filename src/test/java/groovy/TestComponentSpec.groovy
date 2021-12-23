package groovy

import com.crudpessoa.entities.Person
import groovy.mock.BaseSetup
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
import io.micronaut.http.client.exceptions.HttpClientResponseException

@MicronautTest
class TestComponentSpec extends BaseSetup {


    void "retorna pessoas já cadastradas"() {
        given: "url válida"
        HttpRequest request = HttpRequest.GET ("/person/")
        when: "endpoint é chamado"
        HttpResponse response = client.exchange(request)
        then: "o status code deve ser 200"
        assertThat(response.status()).isEqualTo(HttpStatus.OK)
    }

    void "retorna lista vazia quando nenhuma pessoa cadastrada"() {
        given: "url válida"
        HttpRequest request = HttpRequest.GET ("/person/")
        when: "endpoint é chamado"
        HttpResponse response = client.exchange(request)
        then: "o status code deve ser 200"
        assertThat(response.status()).isEqualTo(HttpStatus.OK)
    }

    void "retorna pessoa cadastrada com id informado"() {
        given: "url com id válido"
        HttpRequest request = HttpRequest.GET ("/person/1")
        when: "endpoint é chamado"
        HttpResponse response = client.exchange(request)
        then: "o status code deve ser 200"
        assertThat(response.status()).isEqualTo(HttpStatus.OK)
    }


    void "retorna Not Found quando id informado é inválido"() {
        given: "url com id inválido"
        HttpRequest request = HttpRequest.GET ("/person/20")
        when: "endpoint é chamado"
        HttpResponse response = client.exchange(request)
        then: "o status code deve ser 404"
        def error = thrown(HttpClientResponseException)
        error.getResponse().code() == HttpStatus.NOT_FOUND.code

    }
      void "retorna pessoa criada quando dados para cadastro são válidos"() {
          Person person = new Person()
          person.setName("Tais")
          person.setAge(23)
          person.setCpf("09922236605")

          given: "url com dados válidos de pessoa"
          HttpRequest request = HttpRequest.POST("/person/", person)
          when: "endpoint é chamado"
          HttpResponse response = client.exchange(request)
          then: "o status code deve ser 201"
          assertThat(response.status()).isEqualTo(HttpStatus.CREATED)

      }

      void "retorna BAD REQUEST quando dados para cadastro são inválidos"() {
        Person person = new Person()
        person.setName("Tais")
        person.setAge(23)

        given: "url com dados inválidos de pessoa"
        HttpRequest request = HttpRequest.POST("/person/", person)
        when: "endpoint é chamado"
        HttpResponse response = client.exchange(request)
        then: "o status code deve ser 400"
        def error = thrown(HttpClientResponseException)
        error.getResponse().code() == HttpStatus.BAD_REQUEST.code
      }

      void "retorna No Contet quando id é válido"() {

         given: "url com id válido"
         HttpRequest request = HttpRequest.DELETE("/person/1")
         when: "endpoint é chamado"
            HttpResponse response = client.exchange(request)
            then: "o status code deve ser 204"
            assertThat(response.status()).isEqualTo(HttpStatus.NO_CONTENT)

        }

        void "retorna Not Found quando id é inválido"() {

            given: "url com id inválido"
            HttpRequest request = HttpRequest.DELETE("/person/100")
            when: "endpoint é chamado"
            HttpResponse response = client.exchange(request)
            then: "o status code deve ser 404"
            assertThat(response.status()).isEqualTo(HttpStatus.NOT_FOUND)

        }



}


