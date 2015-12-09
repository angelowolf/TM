/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorCliente;
import Controlador.ControladorVehiculo;
import Persistencia.Modelo.Cliente;
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
public class ClienteAction extends ActionSupport implements ModelDriven<Cliente> {

    private Cliente cliente = new Cliente();
    private List<Cliente> clienteLista = new ArrayList<>();
    private final ControladorCliente controladorCliente = new ControladorCliente();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();

    @Override
    public Cliente getModel() {
        return cliente;
    }

    private boolean validar() {
        if (cliente.getNombre().trim().isEmpty()) {
            addFieldError("cliente.nombre", "Ingrese un nombre.");
            return false;
        }
        return true;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (cliente.getIdCliente() != 0) {
            controladorCliente.actualizar(cliente);
            sesion.put("mensaje", "Cliente Modificado.");
        } else {
            controladorCliente.guardar(cliente);;
            sesion.put("mensaje", "Cliente Agregado.");
        }
        return SUCCESS;
    }

    public String list() {
        clienteLista = controladorCliente.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        ControladorVehiculo controladorVehiculo = new ControladorVehiculo();
        controladorVehiculo.eliminarTodos(idCliente);
        controladorCliente.eliminar(idCliente);
        sesion.put("mensaje", "Cliente Eliminado.");
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        cliente = controladorCliente.getOne(Integer.parseInt(request.getParameter("idCliente")));
        return SUCCESS;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClienteLista() {
        return clienteLista;
    }

    public void setClienteLista(List<Cliente> clienteLista) {
        this.clienteLista = clienteLista;
    }

}
