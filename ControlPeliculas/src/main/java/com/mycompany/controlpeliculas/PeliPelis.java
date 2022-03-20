/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlpeliculas;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class PeliPelis {

    private ManejadorPeliculas manejadorPeliculas;
    private ManejadorClientes manejadorClientes;
    public static final PrestamoPelicula[] PRESTAMO_PELICULAS = new PrestamoPelicula[20];
    public static final Scanner scanner = new Scanner(System.in);

    public PeliPelis() {
        this.manejadorPeliculas = new ManejadorPeliculas();
        this.manejadorClientes = new ManejadorClientes();
        menu();
    }

    private void menu() {
        System.out.println("ELIGE UNA OPCION:");
        System.out.println("1. Préstamo de películas");
        System.out.println("2. Devolución de películas");
        System.out.println("3. Mostrar películas");
        System.out.println("4. Ingresar nueva película");
        System.out.println("5. Ordenar películas según su nombre ASC");
        System.out.println("6. Ordenar películas según su nombre DESC");
        System.out.println("7. Ingresar nuevo cliente");
        System.out.println("8. Mostrar Clientes");
        System.out.println("9. Reportes");
        System.out.println("10. SALIR");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                prestamoPeliculas();
                break;
            case 2:
                devolucionPeliculas();
                break;
            case 3:
                mostrarPeliculas();
                break;
            case 4:
                crearPeliculas();
                break;
            case 5:
                ordenarPeliculasPorNombreASC();
                break;
            case 6:
                ordenarPeliculasPorNombreDESC();
                break;
            case 7:
                crearCliente();
                break;
            case 8:
                this.manejadorClientes.mostrarClientes();
                break;
                case 9:
             mostrarReportes();
                break;
                case 10:
               System.exit(0);
                break;
            default:
        }
        menu();
    }

    private void prestamoPeliculas() {
        System.out.println("Ingrese el id del cliente que quier prestar:");
        int idCLiente = scanner.nextInt();
        Cliente buscado = this.manejadorClientes.buscarClientePorID(idCLiente);
        if (buscado == null) {
            System.out.println("CLIENTE NO ENCONTRADO.");
        } else {
            if (buscado.isHaPrestado()) {
                System.out.println("El cliente ya prestó una película, solo puede prestar una a la vez");
            } else {
                System.out.println("Elige la película quer quiere prestar el cliente.");
                System.out.println("PELICULAS DISPONIBLES");
                this.manejadorPeliculas.mostrarPeliculasDisponibles();
                int idPelicula = scanner.nextInt();
                Pelicula pelicula = this.manejadorPeliculas.buscarPeliculaPorID(idPelicula);
                if (pelicula == null) {
                    System.out.println("Película no encontrada");
                } else {
                    System.out.println("Ingrese el número de días de prestamo de la película:");
                    int dias = scanner.nextInt();
                    agregarPrestamo(idCLiente, idPelicula, dias);
                    pelicula.setDisponible(false);
                    pelicula.setVecesPrestado(pelicula.getVecesPrestado() + 1);
                    buscado.setHaPrestado(true);
                    System.out.println("Tarea hecho con éxito.");
                    System.out.println("PRESTAMOS REALIZADOS");
                    verPrestamos();
                }
            }
        }
    }

    private void agregarPrestamo(int idCliente, int idPelicula, int dias) {
        for (int i = 0; i < PRESTAMO_PELICULAS.length; i++) {
            if (PRESTAMO_PELICULAS[i] == null) {
                PRESTAMO_PELICULAS[i] = new PrestamoPelicula(idPelicula, idCliente, dias);
                break;
            }
        }
    }
/**
 * 
 */
    private void devolucionPeliculas() {
        if(hayPrestados()){
        System.out.println("Seleccione la pelicula que desea devolver:");
        System.out.println("Peliculas prestadas");
        verPrestamos();
        int idPeli = scanner.nextInt();
        this.manejadorPeliculas.buscarPeliculaPorID(idPeli).setDisponible(true);
        this.manejadorClientes.buscarClientePorID(buscarPrestamo(idPeli).getIdCliente()).setHaPrestado(false);
        System.out.println("La película ha sido devuelta con éxito.");
        }else{
            System.out.println("No hay películas prestadas.");
        }
       
    }
    
    private void verPrestamos() {
        for (PrestamoPelicula prestamoPelicula : PRESTAMO_PELICULAS) {
            if (prestamoPelicula != null) {
                if(!manejadorPeliculas.buscarPeliculaPorID(prestamoPelicula.getIdPelicula()).isDisponible()){
                System.out.println("ID " + prestamoPelicula.getIdPelicula() + "Nombre película: "
                        + this.manejadorPeliculas.buscarPeliculaPorID(prestamoPelicula.getIdPelicula())
                        + " Nombre del cliente: " + this.manejadorClientes.buscarClientePorID(prestamoPelicula.getIdCliente()));
                }
            }
        }
    }
    
    private boolean hayPrestados(){
        for (PrestamoPelicula prestamoPelicula : PRESTAMO_PELICULAS) {
            if (prestamoPelicula != null) {
                if(!manejadorPeliculas.buscarPeliculaPorID(prestamoPelicula.getIdPelicula()).isDisponible()){
                    return true;
                }
            }
        }
        return false;
    }

    private PrestamoPelicula buscarPrestamo(int idPeli) {
        for (PrestamoPelicula prestamoPelicula : PRESTAMO_PELICULAS) {
            if (prestamoPelicula != null) {
                if (prestamoPelicula.getIdPelicula() == idPeli) {
                    return prestamoPelicula;
                }
            }
        }
        return null;
    }

    private void mostrarPeliculas() {
        this.manejadorPeliculas.mostrarPeliculas();
    }

    private void crearPeliculas() {
        System.out.println("Ingrese la pelicula de la siguiente manera: NOMBRE,AÑO,CATEGORÍA");
        String peliNueva = scanner.next();
        String[] datos = peliNueva.split(",");
        Pelicula pelicula = new Pelicula(
                        datos[0],
                        Integer.parseInt(datos[1]),
                        datos[2], true, 0);
        this.manejadorPeliculas.agregarNuevaPelicula(pelicula);
        this.manejadorPeliculas.agregarCategoriaNuevaPeli(pelicula);
        System.out.println("Película agregado exitosamente.");
    }

    private void ordenarPeliculasPorNombreASC() {
        this.manejadorPeliculas.ordenarPorNombreASC();
        System.out.println("PELICULAS ORDENADAS POR NOMBRE ASCENDENTEMENTE");
        this.manejadorPeliculas.mostrarPeliculas();
    }
    private void ordenarPeliculasPorNombreDESC() {
        System.out.println("PELICULAS ORDENADAS POR NOMBRE DESCENDENTEMENTE");
        this.manejadorPeliculas.ordenarPorNombreDES();
        this.manejadorPeliculas.mostrarPeliculas();
    }

    private void crearCliente() {

        System.out.println("Ingrese el nuevo cliente de la siguiente manera: NOMBRE,TELEFONO");
        String clientNuevo = scanner.next();
        String[] datos = clientNuevo.split(",");
        this.manejadorClientes.agregarNuevoCLiente(
                new Cliente(
                        datos[0],
                        datos[1],
                        false));
        System.out.println("Cliente creado exitosamente.");
    }

    private void mostrarReportes() {
        System.out.println("Elige el reporte que quieres ver");
        System.out.println("1. Cantidad de peliculas por categoría");
        System.out.println("2. Peliculas por categoría");
        System.out.println("3. Peliculas y prestamos");
        System.out.println("4. Película mas prestada");
        System.out.println("5. Película menos prestada");
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("PELICULAS POR CATEGORIA");
                this.manejadorPeliculas.mostrarPeliculasPorCategoria();
                break;
            case 2:
                System.out.println("Seleccione una categoria para ver las peliculas en esta categoría.");
                this.manejadorPeliculas.mostrarCategorias();
                int categoria = scanner.nextInt();
                this.manejadorPeliculas.mostrarPeliculasDeUnaCategoria(manejadorPeliculas.getCategorias()[categoria - 1].getCategoria());
                break;
            case 3:
                System.out.println("Pelicualas y la cantidad de veces prestadas");
                this.manejadorPeliculas.mostrarPeliculasVecesPrestadas();
                break;
            case 4:
                System.out.println("Pelicula más prestada");
                System.out.println(this.manejadorPeliculas.getPeliculaMasPrestada().toString());
                break;
            case 5:
                System.out.println("Película menos prestada");
                System.out.println(this.manejadorPeliculas.getPeliculaMenosPrestada().toString());
                break;
            default:
        }
    }
}
