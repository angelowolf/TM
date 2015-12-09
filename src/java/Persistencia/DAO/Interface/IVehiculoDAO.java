/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DAO.Interface;

import Persistencia.DAO.Util.IGenericDAO;
import Persistencia.Modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author Angelo
 */
public interface IVehiculoDAO extends IGenericDAO<Vehiculo, Integer> {

    public List<Vehiculo> listar();
}
