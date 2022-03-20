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
public class ManejadorClientes {

    private Cliente[] clientes = new Cliente[20];

    public ManejadorClientes() {
        inicializarClientes();
    }

    private void inicializarClientes() {
        clientes[0] = new Cliente("LUIS", "48987997", false);
        clientes[1] = new Cliente("BASI", "88888888", false);
        clientes[2] = new Cliente("LUIS", "99999999", false);
        clientes[3] = new Cliente("LUIS", "00000000", false);
        clientes[4] = new Cliente("LUIS", "12121212", false);
        clientes[5] = new Cliente("LUIS", "31113133", false);
        clientes[6] = new Cliente("LUIS", "77777888", false);
        clientes[7] = new Cliente("LUIS", "99998431", false);
        clientes[8] = new Cliente("LUIS", "12122222", false);
        clientes[9] = new Cliente("LUIS", "54654664", false);
    }

    public void mostrarClientes() {
        System.out.println("Listado de clientes:d");
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                System.out.println(cliente.toString());
            }
        }
    }

    public Cliente buscarClientePorID(int id) {
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
        }
        return null;
    }

    public void actualizarClientePorID(int id, boolean haPrestado) {
        buscarClientePorID(id).setHaPrestado(haPrestado);
    }

    public void agregarNuevoCLiente(Cliente clienteNUevo) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = clienteNUevo;
                break;
            }

        }
    }
}
