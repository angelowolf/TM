/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Modelo;

import java.io.Serializable;

/**
 *
 * @author Angelo
 */
public class Bateria implements Serializable {

    private int idBateria;
    private String nombre;
    private float precio;

    public Bateria() {
    }

    public Bateria(int id, String nombre, float precio) {
        this.idBateria = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdBateria() {
        return idBateria;
    }

    public void setIdBateria(int idBateria) {
        this.idBateria = idBateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Bateria{" + "idBateria=" + idBateria + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

}
