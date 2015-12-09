/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorMarca;
import Persistencia.Modelo.Marca;
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
public class MarcaAction extends ActionSupport implements ModelDriven<Marca> {

    private Marca marca = new Marca();
    private List<Marca> marcaLista = new ArrayList<>();
    private final ControladorMarca controladorMarca = new ControladorMarca();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();

    @Override
    public Marca getModel() {
        return marca;
    }

    private boolean validar() {
        if (marca.getNombre().trim().isEmpty()) {
            addFieldError("marca.nombre", "Ingrese un nombre.");
            return false;
        }
        return true;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (marca.getIdMarca() != 0) {
            controladorMarca.actualizar(marca);
            sesion.put("mensaje", "Marca Modificado.");
        } else {
            controladorMarca.guardar(marca);;
            sesion.put("mensaje", "Marca Agregado.");
        }
        return SUCCESS;
    }

    public String list() {
        marcaLista = controladorMarca.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        controladorMarca.eliminar(Integer.parseInt(request.getParameter("idMarca")));
        sesion.put("mensaje", "Marca Eliminado.");
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        marca = controladorMarca.getOne(Integer.parseInt(request.getParameter("idMarca")));
        return SUCCESS;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getMarcaLista() {
        return marcaLista;
    }

    public void setMarcaLista(List<Marca> marcaLista) {
        this.marcaLista = marcaLista;
    }

}
