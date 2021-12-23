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


    void "retorna status OK quando existem pessoas cadastradas"() {
        given:
        HttpRequest request = HttpRequest.GET ("/person/2")
        when:
        HttpResponse response = client.exchange(request)
        then:
        assertThat(response.status()).isEqualTo(HttpStatus.OK)
    }

//    void "retorna status OK quando não existem pessoas cadastradas"() {
//        given:
//        HttpRequest request = HttpRequest.GET ("/person/")
//        when:
//        HttpResponse response = client.exchange(request)
//        then:
//        assertThat(response.status()).isEqualTo(HttpStatus.OK)
//    }
//
//    //não está encontrando a pessoa
//    void "retorna status OK quando id informado é válido"() {
//        given:
//        HttpRequest request = HttpRequest.GET ("/person/2")
//        when:
//        HttpResponse response = client.exchange(request)
//        then:
//        assertThat(response.status()).isEqualTo(HttpStatus.OK)
//    }
//
//    void "retorna status Not Found quando id informado é inválido"() {
//        given:
//        HttpRequest request = HttpRequest.GET ("/person/20")
//        when:
//        HttpResponse response = client.exchange(request)
//        then:
//        def error = thrown(HttpClientResponseException)
//        error.getResponse().code() == HttpStatus.NOT_FOUND.code
//
//    }
      void "retorna CREAT quando dados para cadastro são válidos"() {
          Person person = new Person()
          person.setName("Tais")
          person.setAge(23)
          person.setCpf("09922236605")

          given:
          HttpRequest request = HttpRequest.POST("/person/", person)
          when:
          HttpResponse response = client.exchange(request)
          then:
          assertThat(response.status()).isEqualTo(HttpStatus.CREATED)

      }

////      void "retorna BAD REQUEST quando dados para cadastro são inválidos"() {
//        Person person = new Person()
//        person.setName("Tais")
//        person.setAge(23)
//
//        given:
//        HttpRequest request = HttpRequest.POST("/person/", Object.class)
//        when:
//        HttpResponse response = client.exchange(request)
//        then:
//        def error = thrown(HttpClientResponseException)
//        error.getResponse().code() == HttpStatus.BAD_REQUEST.code
//      }
//
//      void "retorna BAD REQUEST quando dados para cadastro são inválidos"() {
//        Person person = new Person()
//        person.setName("Tais")
//        person.setAge(23)
//
//        given:
//        HttpRequest request = HttpRequest.POST("/person/", Object.class)
//        when:
//        HttpResponse response = client.exchange(request)
//        then:
//        def error = thrown(HttpClientResponseException)
//        error.getResponse().code() == HttpStatus.BAD_REQUEST.code
//      }

}


