package groovy.mock

import com.crudpessoa.entities.Person
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment

import javax.persistence.EntityGraph
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction
import javax.persistence.FlushModeType
import javax.persistence.LockModeType
import javax.persistence.Query
import javax.persistence.StoredProcedureQuery
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaDelete
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.CriteriaUpdate
import javax.persistence.metamodel.Metamodel
import static org.mockito.Mockito.mock


@Primary
@Singleton
@Requires(property = "mockEntityManager", value = "true")
class MockEntityManager implements EntityManager {

    @Override
    void persist(Object o) {

    }

    @Override
    def <T> T merge(T t) {
        return null
    }

    @Override
    void remove(Object o) {

    }

    @Override
    def <T> T find(Class<T> aClass, Object o) {
        return null
    }

    @Override
    def <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
        return null
    }

    @Override
    def <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
        return null
    }

    @Override
    def <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
        return null
    }

    @Override
    def <T> T getReference(Class<T> aClass, Object o) {
        return null
    }

    @Override
    void flush() {

    }

    @Override
    void setFlushMode(FlushModeType flushModeType) {

    }

    @Override
    FlushModeType getFlushMode() {
        return null
    }

    @Override
    void lock(Object o, LockModeType lockModeType) {

    }

    @Override
    void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    void refresh(Object o) {

    }

    @Override
    void refresh(Object o, Map<String, Object> map) {

    }

    @Override
    void refresh(Object o, LockModeType lockModeType) {

    }

    @Override
    void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    void clear() {

    }

    @Override
    void detach(Object o) {

    }

    @Override
    boolean contains(Object o) {
        return false
    }

    @Override
    LockModeType getLockMode(Object o) {
        return null
    }

    @Override
    Map<String, Object> getProperties() {
        return null
    }

    @Override
    Query createQuery(String s) {
        return null
    }

    @Override
    def <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return null
    }

    @Override
    Query createQuery(CriteriaUpdate criteriaUpdate) {
        return null
    }

    @Override
    Query createQuery(CriteriaDelete criteriaDelete) {
        return null
    }

    @Override
    def <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
        return null
    }

    @Override
    Query createNamedQuery(String s) {
        return null
    }

    @Override
    def <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
        return null
    }

    @Override
    Query createNativeQuery(String s) {
        return null
    }

    @Override
    Query createNativeQuery(String s, Class aClass) {
        return null
    }

    @Override
    Query createNativeQuery(String s, String s1) {
        return null
    }

    @Override
    StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
        return null
    }

    @Override
    StoredProcedureQuery createStoredProcedureQuery(String s) {
        return null
    }

    @Override
    StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
        return null
    }

    @Override
    StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
        return null
    }

    @Override
    void joinTransaction() {

    }

    @Override
    boolean isJoinedToTransaction() {
        return false
    }

    @Override
    def <T> T unwrap(Class<T> aClass) {
        return null
    }

    @Override
    Object getDelegate() {
        return null
    }

    @Override
    void close() {

    }

    @Override
    boolean isOpen() {
        return false
    }

    @Override
    EntityTransaction getTransaction() {
        return null
    }

    @Override
    EntityManagerFactory getEntityManagerFactory() {
        return null
    }

    @Override
    CriteriaBuilder getCriteriaBuilder() {
        return null
    }

    @Override
    Metamodel getMetamodel() {
        return null
    }

    @Override
    def <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
        return null
    }

    @Override
    EntityGraph<?> createEntityGraph(String s) {
        return null
    }

    @Override
    EntityGraph<?> getEntityGraph(String s) {
        return null
    }

    @Override
    def <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
        return null
    }
}
