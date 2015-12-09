/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Modelo;

/**
 *
 * @author Angelo
 */
public class Vehiculo {

    private int idVehiculo;
    private Modelo modelo;
    private Cliente cliente;

    public Vehiculo() {
    }

    public Vehiculo(int id, Modelo modelo) {
        this.idVehiculo = id;
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", modelo=" + modelo + ", cliente=" + cliente + '}';
    }

}
