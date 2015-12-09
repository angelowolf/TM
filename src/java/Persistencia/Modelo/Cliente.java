/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class Cliente {

    private int idCliente;
    private long telefonoUno, telefonoDos;
    private String nombre, apellido, nombreCompleto;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int id, long telefonoUno, long telefonoDos, String nombre, String apellido) {
        this.idCliente = id;
        this.telefonoUno = telefonoUno;
        this.telefonoDos = telefonoDos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargarNombreCompleto();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void addVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public long getTelefonoUno() {
        return telefonoUno;
    }

    public void setTelefonoUno(long telefonoUno) {
        this.telefonoUno = telefonoUno;
    }

    public long getTelefonoDos() {
        return telefonoDos;
    }

    public void setTelefonoDos(long telefonoDos) {
        this.telefonoDos = telefonoDos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + idCliente + ", telefonoUno=" + telefonoUno + ", telefonoDos=" + telefonoDos + ", nombre=" + nombre + ", apellido=" + apellido + ", vehiculos=" + vehiculos + '}';
    }

    public void cargarNombreCompleto() {
        this.nombreCompleto = this.getApellido() + " " + this.getNombre();
    }

}
