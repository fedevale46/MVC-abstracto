/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import vista.cliente.ClienteView;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ClienteControllerImpl extends AbstractControllerImpl<ClienteModel, ClienteView, String> implements ClienteController{
    
    protected Cliente generaEntidad(List<String> datos){
        String DNI=datos.get(0);
        String nombre=datos.get(1);
        String direccion=datos.get(2);
        Cliente c=new ClienteImpl(DNI);
        c.setNombre(nombre);
        c.setDireccion(direccion);
        return c;

    }
    protected Cliente generaEntidad(String pk){
        return new ClienteImpl(pk);
    }

}
