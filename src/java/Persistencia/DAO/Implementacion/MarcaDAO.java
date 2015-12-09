/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO.Implementacion;

import Persistencia.DAO.Interface.IMarcaDAO;
import Persistencia.DAO.Util.GenericDAO;
import Persistencia.Modelo.Marca;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Angelo
 */
public class MarcaDAO extends GenericDAO<Marca, Integer> implements IMarcaDAO {

    @Override
    public List<Marca> listar() {
        Session session = getHibernateTemplate();
        List<Marca> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Marca").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public Marca buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<Marca> objetos = new ArrayList<>();
        try {
            String sql = "from Marca where nombre = :nombre";

            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos.get(0);
    }

    public List<Marca> algunos(String term) {
        Session session = getHibernateTemplate();
        List<Marca> objetos = new ArrayList();
        try {
            objetos = session.createQuery("from Marca where nombre LIKE :nombre").setParameter("nombre", term + '%').list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}
