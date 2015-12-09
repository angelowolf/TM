/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.DAO.Implementacion.ClienteDAO;
import Persistencia.Modelo.Cliente;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ControladorCliente {

    private final ClienteDAO clienteDAO;

    public ControladorCliente() {
        clienteDAO = new ClienteDAO();
    }

    public void guardar(Cliente cliente) {
        clienteDAO.guardar(cliente);
    }

    public void actualizar(Cliente cliente) {
        clienteDAO.actualizar(cliente);
    }

    public void eliminar(Cliente cliente) {
        clienteDAO.eliminar(cliente);
    }

    public List<Cliente> getTodos() {
        return clienteDAO.listar();
    }
     public void eliminar(int id) {
        Cliente m = new Cliente();
        m.setIdCliente(id);
        clienteDAO.eliminar(m);
    }

    public Cliente getOne(int id) {
        return clienteDAO.buscar(id);
    }

    public List<Cliente> getAlgunos(String term) {
        return clienteDAO.algunos(term);
    }
}
