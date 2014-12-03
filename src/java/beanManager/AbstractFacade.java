/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanManager;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author jconner
 * @param <T>
 */
public abstract class AbstractFacade<T extends Serializable> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    private static final Logger logger = Logger.getLogger("AbstractFacade");
    protected StringBuilder errorMessage = null;

    public void create(T entity) {
        try {
            getEntityManager().persist(entity);
            getEntityManager().flush();
            errorMessage = null;
        } catch (Exception e) {
            errorMessage = new StringBuilder("Create entity failed - " + e.toString());
            logger.log(Level.SEVERE, errorMessage.toString());
        }
    }

    public void edit(T entity) {
        try {
            getEntityManager().merge(entity);
            getEntityManager().flush();
            errorMessage = null;
        } catch (Exception e) {
            errorMessage = new StringBuilder("Edit entity failed - " + e.toString());
            logger.log(Level.SEVERE, errorMessage.toString());
        }
    }

    public void remove(T entity) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().flush();
            errorMessage = null;
        } catch (Exception e) {
            errorMessage = new StringBuilder("Remove entity failed - " + e.toString());
            logger.log(Level.SEVERE, errorMessage.toString());
        }
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}