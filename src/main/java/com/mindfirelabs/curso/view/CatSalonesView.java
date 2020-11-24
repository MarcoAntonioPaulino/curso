package com.mindfirelabs.curso.view;

import com.mindfirelabs.curso.entity.CatSalones;
import java.util.List;

public class CatSalonesView {

    private CatSalones entity;
    private List<CatSalones> listEntity;
    private String textoBusqueda;

    public CatSalones getEntity() {
        return entity;
    }

    public void setEntity(CatSalones entity) {
        this.entity = entity;
    }

    public List<CatSalones> getListEntity() {
        return listEntity;
    }

    public void setListEntity(List<CatSalones> listEntity) {
        this.listEntity = listEntity;
    }

    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    public void setTextoBusqueda(String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }
    
}
