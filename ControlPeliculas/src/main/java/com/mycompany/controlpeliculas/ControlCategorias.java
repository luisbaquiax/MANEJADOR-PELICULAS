/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlpeliculas;

/**
 *
 * @author luis
 */
public class ControlCategorias {

    private String categoria;
    private int cantidad;

    public ControlCategorias(String categoria, int cantidad) {
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ControlCategorias{" + "categoria=" + categoria + ", cantidad=" + cantidad + '}';
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
