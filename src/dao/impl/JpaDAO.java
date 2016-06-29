package dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public abstract class JpaDAO {
    protected Class entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public JpaDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[1];
    }

    public <E> void persist(E entity) {
        entityManager.persist(entity);
    }

    public <E> void merge(E entity) {
        entityManager.merge(entity);
    }
    
    public <E> void remove(E id) {
        entityManager.remove(id);
    }

    public List findSince(Date date) {
        Query q = entityManager.createQuery(
                "SELECT e FROM " + entityClass.getName() + " e WHERE  date >= :date_since");
        q.setParameter("date_since", date);
        return q.getResultList();
    }

    public List findAll() {
        Query q = entityManager.createQuery(
                "SELECT e FROM " + entityClass.getName() + " e");
        return q.getResultList();
    }

    public <E, K> E findById(K id) {
        return (E) entityManager.find(entityClass, id);
    }

   
    
    // TODO add NamedQueries
}
