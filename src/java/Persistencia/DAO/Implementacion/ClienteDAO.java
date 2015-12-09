/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO.Implementacion;

import Persistencia.DAO.Interface.IClienteDAO;
import Persistencia.DAO.Util.GenericDAO;
import Persistencia.Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Angelo
 */
public class ClienteDAO extends GenericDAO<Cliente, Integer> implements IClienteDAO {

    @Override
    public List<Cliente> listar() {
        Session session = getHibernateTemplate();
        List<Cliente> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Cliente").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<Cliente> algunos(String term) {
        Session session = getHibernateTemplate();
        List<Cliente> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Cliente where nombre LIKE :nombre OR apellido LIKE :apellido").setParameter("nombre", term+'%').setParameter("apellido", term+'%').list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}
