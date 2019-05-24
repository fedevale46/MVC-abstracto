/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import modelo.entidades.Cliente;
import controlador.ClienteController;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.ClienteDAOJDBC;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ClienteModelImpl extends AbstractModelImpl<ClienteController,Cliente,String> implements ClienteModel{

    protected GenericDAO obtenerImplementacionDAO(){
        return new ClienteDAOJDBC();
        //return new ClienteDAOJPA();
    }

}
