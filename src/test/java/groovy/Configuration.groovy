package groovy

trait Configuration {

    Map<String, Object> getConfiguration() {
        Map<String, Object> m = [
                'mockPersonRepositoryImpl' : mockPersonRepositoryImpl()
        ]
    }

    boolean mockPersonRepositoryImpl() {
        true
    }
}