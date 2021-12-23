package groovy.stubs


import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock

@Singleton(strict = false)
class WiremockConfig {

    WireMockServer wireMockServer;

    WiremockConfig() {
        wireMockServer = new WireMockServer(8080)
    }

    void start() {
        if (!wireMockServer.isRunning()) {
            wireMockServer.start()
        }
    }

    void stop() {
        if (wireMockServer.isRunning()) {
            wireMockServer.stop()
        }
    }



}