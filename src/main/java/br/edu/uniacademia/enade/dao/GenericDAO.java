/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.dao;

import br.edu.uniacademia.enade.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

/**
 *
 * @author tassi
 */
public abstract class GenericDAO<T, I extends Serializable> {

   protected EntityManager entityManager;

   private Class<T> persistedClass;
   
   public static GenericDAO genericDAO;

   protected GenericDAO() {
   }

   public GenericDAO(Class<T> persistedClass) {
       this();
       this.persistedClass = persistedClass;
       entityManager = PersistenceUtil.getEntityManager();
   }

    public T persist(@Valid T entity) {
        try {
            EntityTransaction t = entityManager.getTransaction();
            t.begin();
            entityManager.merge(entity);
            entityManager.flush();
            t.commit();
            Logger.getLogger (PersistenceUtil.class.getName()).log(
                        Level.INFO, "Salvar o(a) " + persistedClass.getSimpleName() + "!");
            return entity;
        } catch (Exception e) {
            if(e.getMessage().contains("ConstraintViolationException")){
                Logger.getLogger (PersistenceUtil.class.getName()).log(
                        Level.WARNING, "Não foi possível salvar o(a) " + persistedClass.getSimpleName() + ", por não ser único!",
                        e.getMessage());
            } else {
                Logger.getLogger (PersistenceUtil.class.getName()).log(
                        Level.WARNING, "Não foi possível salvar o(a) " + persistedClass.getSimpleName() + "!",
                        e.getMessage());
            }
            return null;
        }
    }

    public void remove(I id) {
        try {
            T entity = find(id);
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            T mergedEntity = entityManager.merge(entity);
            entityManager.remove(mergedEntity);
            entityManager.flush();
            tx.commit();
            Logger.getLogger (PersistenceUtil.class.getName()).log(
                        Level.INFO, persistedClass.getSimpleName() + " removido(a) com sucesso!");
        } catch (Exception e) {
            Logger.getLogger (PersistenceUtil.class.getName()).log(
                        Level.WARNING, "Não foi possível remover o(a) " + persistedClass.getSimpleName() + ", por estar sendo utilizado!");
        }
    }

    public List<T> getList() {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(persistedClass);
            query.from(persistedClass);
            return entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            Logger.getLogger (PersistenceUtil.class.getName()).log(
                        Level.WARNING, "Não foram encontrados(as) " + persistedClass.getSimpleName() + "s!");
            return null;
        }
    }

    public T find(I id) {
        try {
            return entityManager.find(persistedClass, id);
        } catch (Exception e) {
            Logger.getLogger (PersistenceUtil.class.getName()).log(
                        Level.WARNING, "Não foram encontrados(as) " + persistedClass.getSimpleName() + "s!");
            return null;
        }
    }
    
    public List<T> find(String namedQuery, List<List> parameters) {
        Query query = entityManager.createNamedQuery(namedQuery, persistedClass);
        for (List<String> a: parameters) {
            query.setParameter(a.get(0), a.get(1));
        }
        return query.getResultList();
    }
   
}