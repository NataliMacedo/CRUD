package groovy.mock

import groovy.Configuration
import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import groovy.stubs.WiremockConfig

abstract class BaseSetup extends Specification implements Configuration {

    @AutoCleanup
    @Shared
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer, configuration)

    @AutoCleanup
    @Shared
    ApplicationContext applicationContext = embeddedServer.applicationContext

    @AutoCleanup
    @Shared
    HttpClient httpClient = applicationContext.createBean(HttpClient, embeddedServer.URL)

    BlockingHttpClient getClient() { httpClient.toBlocking() }

    void setup() {
        WiremockConfig.getInstance().start()
    }

    void cleanup() {
        WiremockConfig.getInstance().stop()
    }

}
