/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.List;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface Cliente extends Entidad{

    String getDNI();

    String getDireccion();

    String getNombre();

    void setDNI(String DNI);

    void setDireccion(String direccion);

    void setNombre(String nombre);

    List<Factura> getFacturas();

    void setFacturas(List<Factura> facturas);

    void addFactura(Factura factura);

    void removeFactura(Factura factura);
}
