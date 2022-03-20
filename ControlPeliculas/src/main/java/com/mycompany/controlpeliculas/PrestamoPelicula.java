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
public class PrestamoPelicula {

    private int idPelicula;
    private int idCliente;
    private int diasPrestamo;

    public PrestamoPelicula(int idPelicula, int idCliente, int diasPrestamo) {
        this.idPelicula = idPelicula;
        this.idCliente = idCliente;
        this.diasPrestamo = diasPrestamo;
    }

    /**
     * @return the idPelicula
     */
    public int getIdPelicula() {
        return idPelicula;
    }

    /**
     * @param idPelicula the idPelicula to set
     */
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the diasPrestamo
     */
    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    /**
     * @param diasPrestamo the diasPrestamo to set
     */
    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

}
