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
public class Pelicula {

    private static int id = 1;
    private int idPelicula;
    private String nombre;
    private int año;
    private String categoria;
    private boolean disponible;
    private int vecesPrestado;

    public Pelicula() {
    }

    public Pelicula(String nombre, int año, String categoria, boolean disponible, int vecesPrestado) {
        this.nombre = nombre;
        this.año = año;
        this.categoria = categoria;
        this.disponible = disponible;
        this.vecesPrestado = vecesPrestado;
        this.idPelicula = id++;
    }
    

    @Override
    public String toString() {
        return "Pelicula{" + "idPelicula=" + idPelicula + ", nombre=" + nombre + ", año=" + año + ", categoria=" + categoria + ", disponible=" + disponible + ", vecesPrestado=" + vecesPrestado + '}';
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * @return the id
     */
    public int getId() {
        return idPelicula;
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
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
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
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the vecesPrestado
     */
    public int getVecesPrestado() {
        return vecesPrestado;
    }

    /**
     * @param vecesPrestado the vecesPrestado to set
     */
    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }

}
