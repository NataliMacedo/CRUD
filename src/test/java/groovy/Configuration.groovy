package groovy

trait Configuration {

    Map<String, Object> getConfiguration() {
        Map<String, Object> m = [
                'mockPersonService' : mockPersonService(),
                'mockPersonRepository' : mockPersonRepository(),
                'mockEntityManager' : mockEntityManager(),
                'mockAbstractSessionImpl' : mockAbstractSessionImpl(),
                'mockTransactionalSession' : mockTransactionalSession(),
        ]
    }

    boolean mockPersonService() {
        true
    }

    boolean mockPersonRepository() {
        true
    }

    boolean mockEntityManager() {
        true
    }

    boolean mockAbstractSessionImpl() {
        true
    }

    boolean mockTransactionalSession() {
        true
    }
}