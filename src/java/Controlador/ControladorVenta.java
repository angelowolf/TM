/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.DAO.Implementacion.VentaDAO;
import Persistencia.Modelo.Venta;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ControladorVenta {

    private final VentaDAO ventaDAO;

    public ControladorVenta() {
        ventaDAO = new VentaDAO();
    }

    public void guardar(Venta venta) {
        ventaDAO.guardar(venta);
    }

    public void actualizar(Venta venta) {
        ventaDAO.actualizar(venta);
    }

    public void eliminar(Venta venta) {
        ventaDAO.eliminar(venta);
    }

    public List<Venta> getTodos() {
        return ventaDAO.listar();
    }

    public void eliminar(int id) {
        Venta m = new Venta();
        m.setIdVenta(id);
        ventaDAO.eliminar(m);
    }

    public Venta getOne(int id) {
        return ventaDAO.buscar(id);
    }
}
