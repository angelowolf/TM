/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.DAO.Implementacion.BateriaDAO;
import Persistencia.Modelo.Bateria;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ControladorBateria {

    private final BateriaDAO bateriaDAO;

    public ControladorBateria() {
        bateriaDAO = new BateriaDAO();
    }

    public void guardar(Bateria bateria) {
        bateriaDAO.guardar(bateria);
    }

    public void actualizar(Bateria bateria) {
        bateriaDAO.actualizar(bateria);
    }

    public void eliminar(Bateria bateria) {
        bateriaDAO.eliminar(bateria);
    }

    public List<Bateria> getTodos() {
        return bateriaDAO.listar();
    }
     public void eliminar(int id) {
        Bateria m = new Bateria();
        m.setIdBateria(id);
        bateriaDAO.eliminar(m);
    }

    public Bateria getOne(int id) {
        return bateriaDAO.buscar(id);
    }

    public List<Bateria> getAlgunos(String term) {
       return bateriaDAO.algunos(term);
    }

}
