package com.mindfirelabs.curso.controller;

import com.mindfirelabs.curso.business.CatSalonesBusiness;
import com.mindfirelabs.curso.entity.CatSalones;
import com.mindfirelabs.curso.view.CatSalonesView;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named(value = "catSalonesController")
public class CatSalonesController implements Serializable {
    
    @Inject
    private CatSalonesBusiness business;
    
    private CatSalonesView view;

    @PostConstruct
    public void init() {
        view = new CatSalonesView();
        mostrarLista();
    }
    
    public void accionGuardar() {
        business.guardar(view.getEntity());
        mostrarLista();
    }
    
    public void accionEliminar(CatSalones entity) {
        business.eliminar(entity);
        view.setListEntity(null);
        mostrarLista();
    }
    
    public void accionBuscar() {
        view.setEntity(null);
        view.setListEntity(null);
        view.setListEntity(business.busquedaSalonesActivos(view.getTextoBusqueda()));
    }
    
    public void mostrarNuevo() {
        view.setListEntity(null);
        view.setEntity(new CatSalones(0));
    }
    
    /**
     * Establece el valor de la listEntity a null y el valor de la entity con la
     * entity recibida.
     * @param entity Una instancia de CatSalones para establecerla como la entity.
     */
    public void mostrarEditar(CatSalones entity) {
        view.setListEntity(null);
        view.setEntity(entity);
    }
    
    /**
     * Establece el valor de la entity a null y establece el valor de la
     * listEntity con los resultados de los salones activos.
     */
    public void mostrarLista() {
        view.setEntity(null);
        view.setListEntity(business.obtenerSalonesActivos());
    }

    public CatSalonesView getView() {
        return view;
    }
    
}
