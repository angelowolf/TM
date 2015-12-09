/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO.Implementacion;

import Persistencia.DAO.Interface.IVehiculoDAO;
import Persistencia.DAO.Util.GenericDAO;
import Persistencia.Modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Angelo
 */
public class VehiculoDAO extends GenericDAO<Vehiculo, Integer> implements IVehiculoDAO {

    @Override
    public List<Vehiculo> listar() {
        Session session = getHibernateTemplate();
        List<Vehiculo> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Vehiculo").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public void eliminarTodos(int idCliente) {
        Session session = getHibernateTemplate();
        try {
            session.createSQLQuery("delete from vehiculo where id_cliente = :id").setParameter("id", idCliente).executeUpdate();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
