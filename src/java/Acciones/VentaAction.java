/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Acciones.JSON.JSON;
import Controlador.ControladorBateria;
import Controlador.ControladorCliente;
import Controlador.ControladorVenta;
import Persistencia.Modelo.Bateria;
import Persistencia.Modelo.Cliente;
import Persistencia.Modelo.Venta;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Angelo
 */
public class VentaAction extends ActionSupport implements ModelDriven<Venta> {

    private Venta venta = new Venta();
    private List<Venta> ventaLista = new ArrayList<>();
    private final ControladorVenta controladorVenta = new ControladorVenta();
    private final ControladorBateria controladorBateria = new ControladorBateria();
    private final ControladorCliente controladorCliente = new ControladorCliente();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private int cantidad;
    private int idCliente, idBateria;

    private boolean validar() {
        boolean f = true;
        if (idBateria == 0) {
//            addFieldError("venta.bateria.nombre", "Ingrese una bateria");
            addFieldError("", "Ingrese una bateria");
            f = false;
        }
        if (idCliente == 0) {
//            addFieldError("venta.cliente.nombreCompleto", "Ingrese un cliente");
            addFieldError("", "Ingrese un cliente");
            f = false;
        }
        if (venta.getCantidad() == 0) {
//            addFieldError("venta.cantidad", "Ingrese la cantidad");
            addFieldError("", "Ingrese la cantidad");
            f = false;
        }
        Calendar calendario = new GregorianCalendar();
        Date hoy = calendario.getTime();
        if (venta.getFecha() == null || venta.getFecha().after(hoy)) {
            addFieldError("", "La fecha debe ser anterior al dia actual");
            f = false;
        }
        return f;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        Bateria b = controladorBateria.getOne(idBateria);
        Cliente c = controladorCliente.getOne(idCliente);
        venta.setBateria(b);
        venta.setCliente(c);
        venta.setPrecio(b.getPrecio());

        System.out.println(venta.getFecha().toString());
        if (venta.getIdVenta() != 0) {
            controladorVenta.actualizar(venta);
            sesion.put("mensaje", "Venta Modificado.");
        } else {
            controladorVenta.guardar(venta);;
            sesion.put("mensaje", "Venta Agregado.");
        }
        return SUCCESS;
    }

    public String list() {
        ventaLista = controladorVenta.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        controladorVenta.eliminar(Integer.parseInt(request.getParameter("idVenta")));
        sesion.put("mensaje", "Venta Eliminado.");
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        venta = controladorVenta.getOne(Integer.parseInt(request.getParameter("idVenta")));
        idBateria = venta.getBateria().getIdBateria();
        idCliente = venta.getCliente().getIdCliente();
        venta.getCliente().cargarNombreCompleto();
        return SUCCESS;
    }

    public String nuevo() {
        return "nuevo";
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdBateria() {
        return idBateria;
    }

    public void setIdBateria(int idBateria) {
        this.idBateria = idBateria;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getVentaLista() {
        return ventaLista;
    }

    public void setVentaLista(List<Venta> ventaLista) {
        this.ventaLista = ventaLista;
    }

    @Override
    public Venta getModel() {
        return venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private int bateria, cliente;

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
}
