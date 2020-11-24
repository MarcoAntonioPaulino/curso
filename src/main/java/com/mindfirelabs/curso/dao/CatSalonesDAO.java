package com.mindfirelabs.curso.dao;

import com.mindfirelabs.curso.entity.CatSalones;
import com.mindfirelabs.curso.util.Persistence;
import com.mindfirelabs.curso.util.SystemEntityManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CatSalonesDAO extends SystemEntityManager<CatSalones> {
    @Inject
    private Persistence persistence;

    @Override
    protected Persistence getPersistence() {
        return persistence;
    }
    
    /**
     * 
     * @return 
     */
    public List<CatSalones> obtenerSalonesActivos() {
        return persistence.getMySQL().createNamedQuery("CatSalones.findAll").getResultList();
    }
    
    /**
     * 
     * @param textoBusqueda
     * @return 
     */
    public List<CatSalones> obtenerSalonesActivosPorNombre(String textoBusqueda) {
        return persistence.getMySQL().createNamedQuery("CatSalones.findByNombre")
                .setParameter("nombre", '%' + textoBusqueda + '%')
                .getResultList();
    }
    
    /**
     * 
     * @param textoBusqueda Una cadena de texto que contiene el
     * @return 
     */
    public List<CatSalones> obtenerSalonesActivosPorDescripcion(String textoBusqueda) {
        return persistence.getMySQL().createNamedQuery("CatSalones.findByDescripcion")
                .setParameter("descripcion", '%' + textoBusqueda + '%')
                .getResultList();
    }
    
    /**
     * Realiza una busqueda
     * @param id Un Integer que representa el id de una entity CatSalones
     * @return CatSalones 
     */
    public CatSalones obtenerSalonPorId(Integer id) {
        return (CatSalones) persistence.getMySQL().createNamedQuery("CatSalones.findById")
                .setParameter("id", id)
                .getSingleResult();
    }

}
