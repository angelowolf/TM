/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.JSON;

import Controlador.ControladorModelo;
import Persistencia.Modelo.Modelo;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ModeloJSON extends ActionSupport {

    private String term;
    List<JSON> listaModelos;

    @Override
    public String execute() {
        try {
            ControladorModelo cm = new ControladorModelo();
            List<Modelo> ls = cm.getAlgunos(term);
            listaModelos = new ArrayList<>();
            if (!ls.isEmpty()) {

                for (Modelo m : ls) {
                    Acciones.JSON.JSON j = new JSON();
                    j.setId(m.getIdModelo());
                    j.setValue(m.getNombreCompleto());
                    listaModelos.add(j);
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

    public List<JSON> getListaModelos() {
        return listaModelos;
    }

}
