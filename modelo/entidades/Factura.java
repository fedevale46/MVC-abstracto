/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface Factura extends Entidad{

    Cliente getCliente();

    String getIdentificador();

    Double getImporte();

    void setImporte(Double importe);



}
