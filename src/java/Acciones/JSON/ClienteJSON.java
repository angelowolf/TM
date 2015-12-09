/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.JSON;

import Controlador.ControladorCliente;
import Persistencia.Modelo.Cliente;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ClienteJSON extends ActionSupport {

    private String term;
    List<JSON> listaClientes;

    @Override
    public String execute() {
        try {
            ControladorCliente md = new ControladorCliente();
            List<Cliente> ls = md.getAlgunos(term);
            listaClientes = new ArrayList<>();
            if (!ls.isEmpty()) {

                for (Cliente m : ls) {
                    Acciones.JSON.JSON j = new JSON();
                    j.setId(m.getIdCliente());
                    j.setValue(m.getApellido() + " " + m.getNombre());
                    listaClientes.add(j);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return SUCCESS;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<JSON> getListaClientes() {
        return listaClientes;
    }

}
