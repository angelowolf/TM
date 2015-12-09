/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.JSON;

import Controlador.ControladorBateria;
import Persistencia.Modelo.Bateria;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Angelo
 */
public class BateriaJSON extends ActionSupport {

    private String term;
    List<JSON> listaBaterias;

    @Override
    public String execute() {
        try {
            ControladorBateria md = new ControladorBateria();
            List<Bateria> ls = md.getAlgunos(term);
            listaBaterias = new ArrayList<>();
            if (!ls.isEmpty()) {

                for (Bateria m : ls) {
                    Acciones.JSON.JSON j = new JSON();
                    j.setId(m.getIdBateria());
                    j.setValue(m.getNombre());
                    listaBaterias.add(j);
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

    public List<JSON> getListaBaterias() {
        return listaBaterias;
    }

}
