package com.mindfirelabs.curso.business;

import com.mindfirelabs.curso.dao.CatSalonesDAO;
import com.mindfirelabs.curso.entity.CatSalones;
import com.mindfirelabs.curso.util.GestionStrings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CatSalonesBusiness {
    
    @Inject
    private CatSalonesDAO dao;
    
    /**
     * Este metodo guarda un registro en la base datos si el id de la entity
     * es igual a cero, en caso de que el id sea diferente de cero actualiza 
     * el registro que tenga el mismo id que la entity.
     * @param entity una entity de tipo CatSalones
     * @return la instancia de la entity que se guardo en la base de datos 
     */
    public CatSalones guardar(CatSalones entity) {
        if(entity.getId().equals(0)) {
            entity.setFechaRegistro(new Date());
        } else {
            entity.setFechaModifico(new Date());
        }
        return dao.saveOrEdit(entity, entity.getId());
    }
    
    /**
     * Elimina de manera logica la entity recibida de la base de datos
     * @param entity una instancia de tipo CatSalones
     */
    public void eliminar(CatSalones entity) {
        entity.setFechaElimino(new Date());
        dao.eliminarLogicamente(entity);
    }
    
    /**
     * Este metodo obtiene una lista de los salones que se encuentran en la
     * base de datos y que no esten eliminados logicamente.
     * @return Una lista de CatSalones con todos los resultados encontrados
     */
    public List<CatSalones> obtenerSalonesActivos() {
        return dao.obtenerSalonesActivos();
    }
    
    /**
     * Este metodo realiza una busqueda por nombre o descripcion de los salones 
     * que se encuentran en la base de datos y que no han sido eliminados
     * logicamente, si el texto de busqueda es una cadena vacia obtiene todos los
     * salones activos, si no se encuentra ningun resultado simplemente retorna una
     * lista vacia.
     * @param textoBuscar Una cadena de texto que contiene el nombre o descripcion
     * de una entity CatSalones para realizar la busqueda.
     * @return Una lista de entidades de tipo CatSalon con los resultados de la busqueda
     */
    public List<CatSalones> busquedaSalonesActivos(String textoBuscar) {
        if(textoBuscar.isEmpty()) {
            return dao.obtenerSalonesActivos();
        }
        if(!dao.obtenerSalonesActivosPorNombre(textoBuscar).isEmpty()) {
            return dao.obtenerSalonesActivosPorNombre(textoBuscar);
        }
        if(!dao.obtenerSalonesActivosPorDescripcion(textoBuscar).isEmpty()) {
            return dao.obtenerSalonesActivosPorDescripcion(textoBuscar);
        }
        return new ArrayList<>();
    }

    /**
     * Obtiene una entity de tipo CatSalon por medio de un id
     * @param id
     * @return Una entity de tipo CatSalon si se encuentra algun resultado o null
     * en caso de no encontrar nada.
     */
    public CatSalones obtenerSalonPorId(Integer id) {
        return dao.obtenerSalonPorId(id);
    }
    
    private void validar(CatSalones entity) {
        if(entity.getNombre() != null) {
            if(GestionStrings.validarCadena(entity.getNombre()) != null) {
                return;
            }
        }
        if(entity.getDescripcion() != null) {
            if(GestionStrings.validarCadena(entity.getDescripcion()) != null) {
                return;
            }
        }
    }
}
