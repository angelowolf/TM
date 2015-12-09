/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.DAO.Implementacion.VehiculoDAO;
import Persistencia.Modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ControladorVehiculo {
    private final VehiculoDAO vehiculoDAO;

    public ControladorVehiculo() {
        vehiculoDAO = new VehiculoDAO();
    }

    public void guardar(Vehiculo vehiculo) {
        vehiculoDAO.guardar(vehiculo);
    }

    public void actualizar(Vehiculo vehiculo) {
        vehiculoDAO.actualizar(vehiculo);
    }

    public void eliminar(Vehiculo vehiculo) {
        vehiculoDAO.eliminar(vehiculo);
    }

    public List<Vehiculo> getTodos() {
        return vehiculoDAO.listar();
    }
     public void eliminar(int id) {
        Vehiculo m = new Vehiculo();
        m.setIdVehiculo(id);
        vehiculoDAO.eliminar(m);
    }

    public Vehiculo getOne(int id) {
        return vehiculoDAO.buscar(id);
    }

    public void eliminarTodos(int idCliente) {
        vehiculoDAO.eliminarTodos(idCliente);
    }
}
