/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorMarca;
import Controlador.ControladorModelo;
import Persistencia.Modelo.Marca;
import Persistencia.Modelo.Modelo;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class ModeloAction extends ActionSupport implements ModelDriven<Modelo> {

    private Modelo modelo = new Modelo();
    private List<Modelo> modeloLista = new ArrayList<>();
    private final ControladorModelo controladorModelo = new ControladorModelo();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private String nombre;

    @Override
    public Modelo getModel() {
        return modelo;
    }

    private boolean validar() {
        boolean flag = true;
        if (modelo.getNombre().trim().isEmpty()) {
            addFieldError("modelo.nombre", "Ingrese un nombre.");
            flag = false;
        }
        if (modelo.getMarca().getIdMarca() == 0) {
            addFieldError("modelo.marca.nombre", "Ingrese una marca");
            flag = false;
        }
        if (controladorModelo.existe(modelo)) {
            addFieldError("modelo.nombre", "El modelo ya existe.");
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        ControladorMarca cm = new ControladorMarca();
        Marca m = cm.getOne(modelo.getMarca().getIdMarca());
        if (modelo.getIdModelo() != 0) {
            System.out.println(modelo.toString());
            modelo.setMarca(m);
            controladorModelo.actualizar(modelo);
            sesion.put("mensaje", "Modelo Modificado.");
        } else {
            modelo.setMarca(m);
            controladorModelo.guardar(modelo);
            sesion.put("mensaje", "Modelo Agregado.");
        }
        return SUCCESS;
    }

    public String list() {
        modeloLista = controladorModelo.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        controladorModelo.eliminar(Integer.parseInt(request.getParameter("idModelo")));
        sesion.put("mensaje", "Modelo Eliminado.");
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        modelo = controladorModelo.getOne(Integer.parseInt(request.getParameter("idModelo")));
        return SUCCESS;
    }

    public String nuevo() {
        return SUCCESS;
    }

    public List<Modelo> getModeloLista() {
        return modeloLista;
    }

    public void setModeloLista(List<Modelo> modeloLista) {
        this.modeloLista = modeloLista;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
