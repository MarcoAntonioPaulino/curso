package com.mindfirelabs.curso.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Persistence {
    
    @PersistenceContext(unitName = "com.mindfirelabs_curso_war_1.0-SNAPSHOTPU")
    private EntityManager mysql;
    
    /**
     * 
     * @return 
     */
    public EntityManager getMySQL() {
        return mysql;
    }
    
    public EntityManager getMySQL(Integer tenant) {
        mysql.setProperty("tenant.id", tenant);
        return mysql;
    }
    
}
