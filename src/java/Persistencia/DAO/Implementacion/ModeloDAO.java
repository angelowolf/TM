/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO.Implementacion;

import Persistencia.DAO.Interface.IModeloDAO;
import Persistencia.DAO.Util.GenericDAO;
import Persistencia.Modelo.Modelo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Angelo
 */
public class ModeloDAO extends GenericDAO<Modelo, Integer> implements IModeloDAO {

    @Override
    public List<Modelo> listar() {
        Session session = getHibernateTemplate();
        List<Modelo> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Modelo").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public Modelo buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<Modelo> objetos = new ArrayList<>();
        try {
            String sql = "from Modelo where nombre = :nombre";

            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos.get(0);
    }

    public List<Modelo> getTodos(String nombre) {
        Session session = getHibernateTemplate();
        List<Modelo> objetos = new ArrayList<>();
        try {
            String sql = "from Modelo where nombre = :nombre";

            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<Modelo> algunos(String term) {
        Session session = getHibernateTemplate();
        List<Modelo> objetos = new ArrayList();
        try {
            objetos = session.createSQLQuery("select * from Modelo m left join Marca ma ON m.marca = ma.id_marca WHERE m.nombre LIKE :nombre OR ma.nombre LIKE :nombre").addEntity(Modelo.class).setParameter("nombre", term + '%').list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}
