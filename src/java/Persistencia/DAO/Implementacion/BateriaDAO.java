/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO.Implementacion;

import Persistencia.DAO.Interface.IBateriaDAO;
import Persistencia.DAO.Util.GenericDAO;
import Persistencia.Modelo.Bateria;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Angelo
 */
public class BateriaDAO extends GenericDAO<Bateria, Integer> implements IBateriaDAO {

    @Override
    public List<Bateria> listar() {
        Session session = getHibernateTemplate();
        List<Bateria> objetos = new ArrayList();
        Transaction tx = null;
        try {

            //   tx = session.beginTransaction();
            objetos = session.createQuery("from Bateria").list();
            //   tx.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return objetos;
    }

    public List<Bateria> algunos(String term) {
        Session session = getHibernateTemplate();
        List<Bateria> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Bateria where nombre LIKE :nombre").setParameter("nombre", term + '%').list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}
