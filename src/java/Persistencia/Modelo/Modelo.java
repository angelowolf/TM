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
public class Modelo {

    private int idModelo;
    private String nombre;
    private Marca marca;
    private String nombreCompleto;

    public Modelo() {
    }

    public Modelo(int id, String nombre, Marca marca) {
        this.idModelo = id;
        this.nombre = nombre;
        this.marca = marca;
        this.cargarNombreCompleto();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
        this.cargarNombreCompleto();
    }

    @Override
    public String toString() {
        return "Modelo{" + "idModelo=" + idModelo + ", nombre=" + nombre + ", marca=" + marca + '}';
    }

    private void cargarNombreCompleto() {
        this.nombreCompleto = this.getMarca().getNombre() + " " + this.getNombre();
    }
}
