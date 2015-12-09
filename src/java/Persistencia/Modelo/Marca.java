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
public class Marca {

    private int idMarca;
    private String nombre;

    public Marca() {
    }

    public Marca(int id, String nombre) {
        this.idMarca = id;
        this.nombre = nombre;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", nombre=" + nombre + '}';
    }

}
