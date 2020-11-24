package com.mindfirelabs.curso.util;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class SystemEntityManager<Entity> {

    private static Logger LOG = Logger.getLogger(SystemEntityManager.class.getName());
    
    protected abstract Persistence getPersistence();

    /**
     * Guarda o actualiza una entity 
     * @param entity Una entity que 
     * @param id Representa el id de la entity
     * @return La entity recibida.
     */
    public Entity saveOrEdit(Entity entity, Object id) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Entity>> constraintViolations = validator.validate(entity);
        if (!constraintViolations.isEmpty()) {
            Iterator<ConstraintViolation<Entity>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<Entity> constraintViolation = iterator.next();
                LOG.log(Level.SEVERE, "Error en la entidad {0}: ", constraintViolation.getPropertyPath());
                LOG.log(Level.SEVERE, "Error en la entidad {0}: ", constraintViolation.getMessage());
            }
        }
        if (id.equals(0)) {
            getPersistence().getMySQL().persist(entity);
        } else {
            getPersistence().getMySQL().merge(entity);
        }
        getPersistence().getMySQL().flush();
        return entity;
    }

    /**
     * Acualiza una entity para que sea eliminada de manera logica de la base de
     * datos.
     * @param entity La entity que se eliminara de manera logica de la base de
     * datos
     */
    public void eliminarLogicamente(Entity entity) {
        getPersistence().getMySQL().merge(entity);
    }
    
    /**
     * Elimina una entity para que sea eliminada de manera fisica de la base de 
     * datos.
     * @param entity La entity que se eliminara de manera fisica de la base de datos
     */
    public void eliminarFisicamente(Entity entity) {
        getPersistence().getMySQL().remove(getPersistence().getMySQL().merge(entity));
    }

}
