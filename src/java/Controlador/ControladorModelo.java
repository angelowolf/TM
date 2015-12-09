/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.DAO.Implementacion.ModeloDAO;
import Persistencia.Modelo.Modelo;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ControladorModelo {

    private final ModeloDAO modeloDAO;

    public ControladorModelo() {
        modeloDAO = new ModeloDAO();
    }

    public void guardar(Modelo modelo) {
        modeloDAO.guardar(modelo);
    }

    public void actualizar(Modelo modelo) {
        modeloDAO.actualizar(modelo);
    }

    public void eliminar(Modelo modelo) {
        modeloDAO.eliminar(modelo);
    }

    public List<Modelo> getTodos() {
        return modeloDAO.listar();
    }

    public void eliminar(int id) {
        Modelo m = new Modelo();
        m.setIdModelo(id);
        modeloDAO.eliminar(m);
    }

    public Modelo getOne(int id) {
        return modeloDAO.buscar(id);
    }

    public Modelo getOne(String nombre) {
        return modeloDAO.buscar(nombre);
    }

    public boolean existe(Modelo modelo) {
        List<Modelo> lista = modeloDAO.getTodos(modelo.getNombre());
        for (Modelo m : lista) {
            if (m.getMarca().getNombre().equals(modelo.getMarca().getNombre())) {
                return m.getIdModelo() != modelo.getIdModelo();
            }
        }
        return false;
    }

    public List<Modelo> getAlgunos(String term) {
        return modeloDAO.algunos(term);
    }

}
