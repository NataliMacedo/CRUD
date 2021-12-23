package groovy.mock

import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import org.hibernate.Criteria
import org.hibernate.Filter
import org.hibernate.HibernateException
import org.hibernate.IdentifierLoadAccess
import org.hibernate.LobHelper
import org.hibernate.LockMode
import org.hibernate.LockOptions
import org.hibernate.MultiIdentifierLoadAccess
import org.hibernate.NaturalIdLoadAccess
import org.hibernate.Query
import org.hibernate.ReplicationMode
import org.hibernate.ScrollMode
import org.hibernate.SessionEventListener
import org.hibernate.SharedSessionBuilder
import org.hibernate.SimpleNaturalIdLoadAccess
import org.hibernate.TypeHelper
import org.hibernate.UnknownProfileException
import org.hibernate.collection.spi.PersistentCollection
import org.hibernate.engine.query.spi.sql.NativeSQLQuerySpecification
import org.hibernate.engine.spi.ActionQueue
import org.hibernate.engine.spi.EntityEntry
import org.hibernate.engine.spi.EntityKey
import org.hibernate.engine.spi.LoadQueryInfluencers
import org.hibernate.engine.spi.PersistenceContext
import org.hibernate.engine.spi.QueryParameters
import org.hibernate.engine.spi.SessionFactoryImplementor
import org.hibernate.engine.spi.SessionImplementor
import org.hibernate.graph.spi.RootGraphImplementor
import org.hibernate.internal.AbstractSessionImpl
import org.hibernate.internal.SessionCreationOptions
import org.hibernate.internal.SessionFactoryImpl
import org.hibernate.loader.custom.CustomQuery
import org.hibernate.persister.entity.EntityPersister
import org.hibernate.query.spi.ScrollableResultsImplementor
import org.hibernate.stat.SessionStatistics

import javax.persistence.EntityManagerFactory
import javax.persistence.FlushModeType
import javax.persistence.LockModeType
import javax.persistence.StoredProcedureQuery
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.metamodel.Metamodel
import java.sql.Connection

@Primary
@Singleton(strict = false)
@Requires(env = [Environment.TEST, Environment.MICRONAUT, Environment.DEVELOPMENT])
@Requires(property = "mockAbstractSessionImpl", value = "true")
class MockAbstractSessionImpl extends AbstractSessionImpl{
    protected MockAbstractSessionImpl(SessionFactoryImpl factory, SessionCreationOptions options) {
        super(factory, options)
    }

    @Override
    SharedSessionBuilder sessionWithOptions() {
        return null
    }

    @Override
    SessionFactoryImplementor getSessionFactory() {
        return null
    }

    @Override
    void cancelQuery() throws HibernateException {

    }

    @Override
    boolean isDirty() throws HibernateException {
        return false
    }

    @Override
    boolean isDefaultReadOnly() {
        return false
    }

    @Override
    void setDefaultReadOnly(boolean b) {

    }

    @Override
    Serializable getIdentifier(Object o) {
        return null
    }

    @Override
    boolean contains(String s, Object o) {
        return false
    }

    @Override
    void evict(Object o) {

    }

    @Override
    def <T> T load(Class<T> aClass, Serializable serializable, LockMode lockMode) {
        return null
    }

    @Override
    def <T> T load(Class<T> aClass, Serializable serializable, LockOptions lockOptions) {
        return null
    }

    @Override
    Object load(String s, Serializable serializable, LockMode lockMode) {
        return null
    }

    @Override
    Object load(String s, Serializable serializable, LockOptions lockOptions) {
        return null
    }

    @Override
    def <T> T load(Class<T> aClass, Serializable serializable) {
        return null
    }

    @Override
    Object load(String s, Serializable serializable) {
        return null
    }

    @Override
    void load(Object o, Serializable serializable) {

    }

    @Override
    void replicate(Object o, ReplicationMode replicationMode) {

    }

    @Override
    void replicate(String s, Object o, ReplicationMode replicationMode) {

    }

    @Override
    Serializable save(Object o) {
        return null
    }

    @Override
    Serializable save(String s, Object o) {
        return null
    }

    @Override
    void saveOrUpdate(Object o) {

    }

    @Override
    void saveOrUpdate(String s, Object o) {

    }

    @Override
    void update(Object o) {

    }

    @Override
    void update(String s, Object o) {

    }

    @Override
    Object merge(Object o) {
        return null
    }

    @Override
    Object merge(String s, Object o) {
        return null
    }

    @Override
    void persist(Object o) {

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
    void setFlushMode(FlushModeType flushModeType) {

    }

    @Override
    void lock(Object o, LockModeType lockModeType) {

    }

    @Override
    void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    void persist(String s, Object o) {

    }

    @Override
    void delete(Object o) {

    }

    @Override
    void delete(String s, Object o) {

    }

    @Override
    void lock(Object o, LockMode lockMode) {

    }

    @Override
    void lock(String s, Object o, LockMode lockMode) {

    }

    @Override
    LockRequest buildLockRequest(LockOptions lockOptions) {
        return null
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
    void refresh(String s, Object o) {

    }

    @Override
    void refresh(Object o, LockMode lockMode) {

    }

    @Override
    void refresh(Object o, LockOptions lockOptions) {

    }

    @Override
    void refresh(String s, Object o, LockOptions lockOptions) {

    }

    @Override
    LockMode getCurrentLockMode(Object o) {
        return null
    }

    @Override
    Query createFilter(Object o, String s) {
        return null
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
    def <T> T get(Class<T> aClass, Serializable serializable) {
        return null
    }

    @Override
    def <T> T get(Class<T> aClass, Serializable serializable, LockMode lockMode) {
        return null
    }

    @Override
    def <T> T get(Class<T> aClass, Serializable serializable, LockOptions lockOptions) {
        return null
    }

    @Override
    Object get(String s, Serializable serializable) {
        return null
    }

    @Override
    Object get(String s, Serializable serializable, LockMode lockMode) {
        return null
    }

    @Override
    Object get(String s, Serializable serializable, LockOptions lockOptions) {
        return null
    }

    @Override
    String getEntityName(Object o) {
        return null
    }

    @Override
    IdentifierLoadAccess byId(String s) {
        return null
    }

    @Override
    def <T> MultiIdentifierLoadAccess<T> byMultipleIds(Class<T> aClass) {
        return null
    }

    @Override
    MultiIdentifierLoadAccess byMultipleIds(String s) {
        return null
    }

    @Override
    def <T> IdentifierLoadAccess<T> byId(Class<T> aClass) {
        return null
    }

    @Override
    NaturalIdLoadAccess byNaturalId(String s) {
        return null
    }

    @Override
    def <T> NaturalIdLoadAccess<T> byNaturalId(Class<T> aClass) {
        return null
    }

    @Override
    SimpleNaturalIdLoadAccess bySimpleNaturalId(String s) {
        return null
    }

    @Override
    def <T> SimpleNaturalIdLoadAccess<T> bySimpleNaturalId(Class<T> aClass) {
        return null
    }

    @Override
    Filter enableFilter(String s) {
        return null
    }

    @Override
    Filter getEnabledFilter(String s) {
        return null
    }

    @Override
    void disableFilter(String s) {

    }

    @Override
    SessionStatistics getStatistics() {
        return null
    }

    @Override
    boolean isReadOnly(Object o) {
        return false
    }

    @Override
    void setReadOnly(Object o, boolean b) {

    }

    @Override
    def <T> RootGraphImplementor<T> createEntityGraph(Class<T> aClass) {
        return null
    }

    @Override
    RootGraphImplementor<?> createEntityGraph(String s) {
        return null
    }

    @Override
    RootGraphImplementor<?> getEntityGraph(String s) {
        return null
    }

    @Override
    Connection disconnect() {
        return null
    }

    @Override
    void reconnect(Connection connection) {

    }

    @Override
    boolean isFetchProfileEnabled(String s) throws UnknownProfileException {
        return false
    }

    @Override
    void enableFetchProfile(String s) throws UnknownProfileException {

    }

    @Override
    void disableFetchProfile(String s) throws UnknownProfileException {

    }

    @Override
    TypeHelper getTypeHelper() {
        return null
    }

    @Override
    LobHelper getLobHelper() {
        return null
    }

    @Override
    void addEventListeners(SessionEventListener... sessionEventListeners) {

    }

    @Override
    boolean isFlushBeforeCompletionEnabled() {
        return false
    }

    @Override
    ActionQueue getActionQueue() {
        return null
    }

    @Override
    Object instantiate(EntityPersister entityPersister, Serializable serializable) throws HibernateException {
        return null
    }

    @Override
    void forceFlush(EntityEntry entityEntry) throws HibernateException {

    }

    @Override
    void merge(String s, Object o, Map map) throws HibernateException {

    }

    @Override
    void persist(String s, Object o, Map map) throws HibernateException {

    }

    @Override
    void persistOnFlush(String s, Object o, Map map) {

    }

    @Override
    void refresh(String s, Object o, Map map) throws HibernateException {

    }

    @Override
    void delete(String s, Object o, boolean b, Set set) {

    }

    @Override
    void removeOrphanBeforeUpdates(String s, Object o) {

    }

    @Override
    PersistenceContext getPersistenceContext() {
        return null
    }

    @Override
    void setAutoClear(boolean b) {

    }

    @Override
    void initializeCollection(PersistentCollection persistentCollection, boolean b) throws HibernateException {

    }

    @Override
    Object internalLoad(String s, Serializable serializable, boolean b, boolean b1) throws HibernateException {
        return null
    }

    @Override
    Object immediateLoad(String s, Serializable serializable) throws HibernateException {
        return null
    }

    @Override
    List list(String s, QueryParameters queryParameters) throws HibernateException {
        return null
    }

    @Override
    Iterator iterate(String s, QueryParameters queryParameters) throws HibernateException {
        return null
    }

    @Override
    ScrollableResultsImplementor scroll(String s, QueryParameters queryParameters) throws HibernateException {
        return null
    }

    @Override
    ScrollableResultsImplementor scroll(Criteria criteria, ScrollMode scrollMode) {
        return null
    }

    @Override
    List list(Criteria criteria) {
        return null
    }

    @Override
    List listFilter(Object o, String s, QueryParameters queryParameters) throws HibernateException {
        return null
    }

    @Override
    Iterator iterateFilter(Object o, String s, QueryParameters queryParameters) throws HibernateException {
        return null
    }

    @Override
    EntityPersister getEntityPersister(String s, Object o) throws HibernateException {
        return null
    }

    @Override
    Object getEntityUsingInterceptor(EntityKey entityKey) throws HibernateException {
        return null
    }

    @Override
    Serializable getContextEntityIdentifier(Object o) {
        return null
    }

    @Override
    String bestGuessEntityName(Object o) {
        return null
    }

    @Override
    String guessEntityName(Object o) throws HibernateException {
        return null
    }

    @Override
    Object instantiate(String s, Serializable serializable) throws HibernateException {
        return null
    }

    @Override
    List listCustomQuery(CustomQuery customQuery, QueryParameters queryParameters) throws HibernateException {
        return null
    }

    @Override
    ScrollableResultsImplementor scrollCustomQuery(CustomQuery customQuery, QueryParameters queryParameters) throws HibernateException {
        return null
    }

    @Override
    int getDontFlushFromFind() {
        return 0
    }

    @Override
    int executeUpdate(String s, QueryParameters queryParameters) throws HibernateException {
        return 0
    }

    @Override
    int executeNativeUpdate(NativeSQLQuerySpecification nativeSQLQuerySpecification, QueryParameters queryParameters) throws HibernateException {
        return 0
    }

    @Override
    Connection connection() {
        return null
    }

    @Override
    void flush() {

    }

    @Override
    boolean isEventSource() {
        return false
    }

    @Override
    void afterScrollOperation() {

    }

    @Override
    boolean shouldAutoClose() {
        return false
    }

    @Override
    boolean isAutoCloseSessionEnabled() {
        return false
    }

    @Override
    LoadQueryInfluencers getLoadQueryInfluencers() {
        return null
    }

    @Override
    PersistenceContext getPersistenceContextInternal() {
        return null
    }

    @Override
    Criteria createCriteria(Class aClass) {
        return null
    }

    @Override
    Criteria createCriteria(Class aClass, String s) {
        return null
    }

    @Override
    Criteria createCriteria(String s) {
        return null
    }

    @Override
    Criteria createCriteria(String s, String s1) {
        return null
    }

    @Override
    SessionImplementor getSession() {
        return null
    }

    @Override
    LockOptions getLockRequest(LockModeType lockModeType, Map<String, Object> map) {
        return null
    }

    @Override
    void afterTransactionBegin() {

    }

    @Override
    void flushBeforeTransactionCompletion() {

    }
}
