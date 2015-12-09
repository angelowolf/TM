/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO.Implementacion;

import Persistencia.DAO.Interface.IVentaDAO;
import Persistencia.DAO.Util.GenericDAO;
import Persistencia.Modelo.Venta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Angelo
 */
public class VentaDAO extends GenericDAO<Venta, Integer> implements IVentaDAO {

    @Override
    public List<Venta> listar() {
        Session session = getHibernateTemplate();
        List<Venta> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Venta").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}
