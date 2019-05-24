/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Factura;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface FacturaModel extends Model<FacturaController,Factura,String>{
    List<Factura> listarPorCliente(String nombre);

}
