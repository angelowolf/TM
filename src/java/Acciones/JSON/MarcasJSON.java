/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.JSON;

import Controlador.ControladorMarca;
import Persistencia.Modelo.Marca;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Angelo
 */
public class MarcasJSON extends ActionSupport {

    private String term;
    List<JSON> listaMarcas;

    @Override
    public String execute() {
        try {
            ControladorMarca md = new ControladorMarca();
            List<Marca> ls = md.getAlgunos(term);
            listaMarcas = new ArrayList<>();
            if (!ls.isEmpty()) {
                for (Marca m : ls) {
                    Acciones.JSON.JSON j = new JSON();
                    j.setId(m.getIdMarca());
                    j.setValue(m.getNombre());
                    listaMarcas.add(j);
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

    public List<JSON> getListaMarcas() {
        return listaMarcas;
    }

}
