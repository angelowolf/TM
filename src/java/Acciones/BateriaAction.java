/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorBateria;
import Persistencia.Modelo.Bateria;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Angelo
 */
public class BateriaAction extends ActionSupport implements ModelDriven<Bateria> {

    private Bateria bateria = new Bateria();
    private List<Bateria> bateriaLista = new ArrayList<>();
    private final ControladorBateria controladorBateria = new ControladorBateria();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();

    @Override
    public Bateria getModel() {
        return bateria;
    }

    private boolean validar() {
        if (bateria.getNombre().trim().isEmpty()) {
            addFieldError("bateria.nombre", "Ingrese un nombre.");
            return false;
        }      
        return true;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (bateria.getIdBateria() != 0) {
            controladorBateria.actualizar(bateria);
            sesion.put("mensaje", "Bateria Modificado.");
        } else {
            controladorBateria.guardar(bateria);;
            sesion.put("mensaje", "Bateria Agregado.");
        }
        return SUCCESS;
    }

    public String list() {
        bateriaLista = controladorBateria.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        controladorBateria.eliminar(Integer.parseInt(request.getParameter("idBateria")));
        sesion.put("mensaje", "Bateria Eliminado.");
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        bateria = controladorBateria.getOne(Integer.parseInt(request.getParameter("idBateria")));
        return SUCCESS;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    public List<Bateria> getBateriaLista() {
        return bateriaLista;
    }

    public void setBateriaLista(List<Bateria> bateriaLista) {
        this.bateriaLista = bateriaLista;
    }

}
