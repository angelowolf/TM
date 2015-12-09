/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorCliente;
import Controlador.ControladorModelo;
import Controlador.ControladorVehiculo;
import Persistencia.Modelo.Cliente;
import Persistencia.Modelo.Modelo;
import Persistencia.Modelo.Vehiculo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Angelo
 */
public class VehiculoAction extends ActionSupport {

    private Vehiculo vehiculo = new Vehiculo();
    private List<Vehiculo> vehiculoLista = new ArrayList<>();
    private final ControladorVehiculo controladorVehiculo = new ControladorVehiculo();
    private final ControladorModelo controladorModelo = new ControladorModelo();
    private final ControladorCliente controladorCliente = new ControladorCliente();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();

    private int idCliente, idModelo;

    private boolean validar() {
        boolean flag = true;
        if (idModelo == 0) {
            addFieldError("acModelo", "Ingrese un modelo");
            flag = false;
        }
        if (idCliente == 0) {
            addFieldError("acCliente", "Ingrese un cliente");
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        Modelo m = controladorModelo.getOne(idModelo);
        vehiculo.setModelo(m);
        Cliente c = controladorCliente.getOne(idCliente);
        vehiculo.setCliente(c);
        c.addVehiculo(vehiculo);
        if (vehiculo.getIdVehiculo() != 0) {
            controladorVehiculo.actualizar(vehiculo);
//             controladorCliente.actualizar(c);
            sesion.put("mensaje", "Vehiculo Modificado.");
        } else {
            controladorVehiculo.guardar(vehiculo);
//            controladorCliente.actualizar(c);
//            controladorCliente.guardar(c);
            sesion.put("mensaje", "Vehiculo Agregado.");
        }
        return SUCCESS;
    }

    public String list() {
        vehiculoLista = controladorVehiculo.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        controladorVehiculo.eliminar(Integer.parseInt(request.getParameter("idVehiculo")));
        sesion.put("mensaje", "Vehiculo Eliminado.");
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        vehiculo = controladorVehiculo.getOne(Integer.parseInt(request.getParameter("idVehiculo")));
        vehiculo.getCliente().cargarNombreCompleto();
        idModelo = vehiculo.getModelo().getIdModelo();
        idCliente = vehiculo.getCliente().getIdCliente();
        return SUCCESS;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Vehiculo> getVehiculoLista() {
        return vehiculoLista;
    }

    public void setVehiculoLista(List<Vehiculo> vehiculoLista) {
        this.vehiculoLista = vehiculoLista;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

}
