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
public class Cliente {

    private int id;
    private String nombre;
    private static int idStatic = 1;
    private String telefono;
    private boolean haPrestado;

    public Cliente(String nombre, String telefono, boolean haPrestado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.haPrestado = haPrestado;
        this.id = idStatic++;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", haPrestado=" + haPrestado + '}';
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the haPrestado
     */
    public boolean isHaPrestado() {
        return haPrestado;
    }

    /**
     * @param haPrestado the haPrestado to set
     */
    public void setHaPrestado(boolean haPrestado) {
        this.haPrestado = haPrestado;
    }

}
