/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import vista.factura.FacturaView;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class FacturaControllerImpl extends AbstractControllerImpl<FacturaModel, FacturaView, Serializable> implements FacturaController{
    
    protected Factura generaEntidad(List<Serializable> datos){
        String identificador=(String)datos.get(0);
        Cliente cliente=(Cliente)datos.get(1);
        Double importe=new Double((String)datos.get(2));
        Factura f=new FacturaImpl(identificador,cliente);
        f.setImporte(importe);
        
        return f;

    }
    protected Factura generaEntidad(Serializable pk){
        return new FacturaImpl((String)pk);
    }

}
