/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.DAO.Implementacion.MarcaDAO;
import Persistencia.Modelo.Marca;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ControladorMarca {
    private final MarcaDAO marcaDAO;

    public ControladorMarca() {
        marcaDAO = new MarcaDAO();
    }

    public void guardar(Marca marca) {
        marcaDAO.guardar(marca);
    }

    public void actualizar(Marca marca) {
        marcaDAO.actualizar(marca);
    }

    public void eliminar(Marca marca) {
        marcaDAO.eliminar(marca);
    }

    public List<Marca> getTodos() {
        return marcaDAO.listar();
    }
     public void eliminar(int id) {
        Marca m = new Marca();
        m.setIdMarca(id);
        marcaDAO.eliminar(m);
    }

    public Marca getOne(int id) {
        return marcaDAO.buscar(id);
    }

    public Marca getOne(String marca) {
        return marcaDAO.buscar(marca);
      }

    public List<Marca> getAlgunos(String term) {
        return marcaDAO.algunos(term);
    }
}
