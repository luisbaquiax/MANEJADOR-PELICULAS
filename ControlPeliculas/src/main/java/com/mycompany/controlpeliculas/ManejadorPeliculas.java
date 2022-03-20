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
public class ManejadorPeliculas {

    private Pelicula[] peliculas = new Pelicula[20];
    private ControlCategorias[] categorias = new ControlCategorias[20];

    public ManejadorPeliculas() {
        incializarPelciuals();
        agregarCategoria();
    }

    private void incializarPelciuals() {
        peliculas[0] = new Pelicula("avegers 1", 1999, "accion-ficcion", true, 0);
        peliculas[1] = new Pelicula("avegers 2", 1999, "accion-ficcion", true, 10);
        peliculas[2] = new Pelicula("avegers 3", 1999, "accion-ficcion", true, 1);
        peliculas[3] = new Pelicula("avegers 4", 1999, "accion-ficcion", true, 2);
        peliculas[4] = new Pelicula("avegers 5", 1999, "accion-ficcion", true, 3);
        peliculas[5] = new Pelicula("casa de tinieblas", 1999, "terror", true, 4);
        peliculas[6] = new Pelicula("spiderman 1", 1999, "accion-ficcion", true, 5);
        peliculas[7] = new Pelicula("spiderman 2", 1999, "accion-ficcion", true, 6);
        peliculas[8] = new Pelicula("spiderman 3", 1999, "accion-ficcion", true, 7);
    }

    private void agregarCategoria() {
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                if (!yaExisteCategoria(pelicula.getCategoria())) {
                    for (int i = 0; i < categorias.length; i++) {
                        if (categorias[i] == null) {
                            categorias[i] = new ControlCategorias(pelicula.getCategoria(), 1);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < categorias.length; i++) {
                        if (categorias[i].getCategoria().equalsIgnoreCase(pelicula.getCategoria())) {
                            categorias[i].setCantidad(categorias[i].getCantidad() + 1);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void mostrarPeliculasPorCategoria() {
        for (ControlCategorias c : categorias) {
            if (c != null) {
                System.out.println(c.toString());
            }
        }
    }

    public void agregarCategoriaNuevaPeli(Pelicula nueva) {
        if (yaExisteCategoria(nueva.getCategoria())) {
            for (int i = 0; i < categorias.length; i++) {
                if (categorias[i] != null) {
                    if (categorias[i].getCategoria().equalsIgnoreCase(nueva.getCategoria())) {
                        categorias[i].setCantidad(categorias[i].getCantidad() + 1);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < categorias.length; i++) {
                if (categorias[i] == null) {
                    categorias[i] = new ControlCategorias(nueva.getCategoria(), 1);
                    break;
                }
            }
        }

    }

    private boolean yaExisteCategoria(String categoria) {
        for (ControlCategorias c : categorias) {
            if (c != null) {
                if (c.getCategoria().equalsIgnoreCase(categoria)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarPeliculasDisponibles() {
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                if (pelicula.isDisponible()) {
                    System.out.println(pelicula.toString());
                }
            }

        }
    }

    public void mostrarPeliculas() {
        System.out.println("PELICULAS");
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                System.out.println(pelicula.toString());
            }

        }
    }

    public void mostrarPeliculasVecesPrestadas() {
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                System.out.println("Pelicula: " + pelicula.getNombre() + "\tVeces prestadas: " + pelicula.getVecesPrestado());
            }

        }
    }

    public void mostrarPeliculasDeUnaCategoria(String categoria) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                if (categoria.equalsIgnoreCase(pelicula.getCategoria())) {
                    System.out.println(pelicula.toString());
                }
            }

        }
    }

    public Pelicula getPeliculaMasPrestada() {
        Pelicula auxiPelicula = new Pelicula();
        int max = 0;
        int masPrestada = 0;
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                max = peliculas[i].getVecesPrestado();
                for (int j = 0; j < peliculas.length; j++) {
                    if (peliculas[j] != null) {
                        if (max > masPrestada) {
                            auxiPelicula = peliculas[i];
                            masPrestada = max;
                        }
                    }

                }
            }
        }
        return auxiPelicula;
    }

    public Pelicula getPeliculaMenosPrestada() {
        Pelicula auxiPelicula = null;
        int menosPrestada = peliculas[0].getVecesPrestado();
        for (int i = 1; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (menosPrestada > peliculas[i].getVecesPrestado()) {
                    menosPrestada = peliculas[i].getVecesPrestado();
                    auxiPelicula = peliculas[i];
                }
            }
        }

        return auxiPelicula;
    }

    public Pelicula buscarPeliculaPorID(int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                if (pelicula.getId() == id) {
                    return pelicula;
                }
            }
        }
        return null;
    }

    public void agregarNuevaPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] == null) {
                peliculas[i] = pelicula;
                break;
            }
        }
    }

    public void mostrarCategorias() {
        for (int i = 0; i < categorias.length; i++) {
            if (categorias[i] != null) {
                System.out.println("# " + (i + 1) + " " + categorias[i].getCategoria());
            }
        }
    }

    public void ordenarPorNombreASC() {
        Pelicula auxi = null;
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                for (int j = 0; j < peliculas.length - 1; j++) {
                    if (peliculas[j] != null && peliculas[j + 1] != null) {
                        if (peliculas[j].getNombre().compareTo(peliculas[j + 1].getNombre()) > 0) {
                            auxi = peliculas[j];
                            peliculas[j] = peliculas[j + 1];
                            peliculas[j + 1] = auxi;
                        }
                    }
                }
            }
        }
    }

    public void ordenarPorNombreDES() {
        Pelicula auxi = null;
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                for (int j = 0; j < peliculas.length - 1; j++) {
                    if (peliculas[j] != null && peliculas[j + 1] != null) {
                        if (peliculas[j].getNombre().compareTo(peliculas[j + 1].getNombre()) < 0) {
                            auxi = peliculas[j];
                            peliculas[j] = peliculas[j + 1];
                            peliculas[j + 1] = auxi;
                        }
                    }
                }
            }
        }
    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public ControlCategorias[] getCategorias() {
        return categorias;
    }

}
