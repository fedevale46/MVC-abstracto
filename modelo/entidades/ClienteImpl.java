/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ClienteImpl implements Cliente {
    private String nombre;
    private String DNI;
    private String direccion;
    private List<Factura> facturas;

    public ClienteImpl(String DNI) {
        this(DNI,null,null);
    }

    public ClienteImpl(String DNI, String nombre, String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.facturas=new ArrayList();
    }


    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addFactura(Factura factura){
        this.facturas.add(factura);
    }

    public void removeFactura(Factura factura){
        this.facturas.remove(factura);
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteImpl other = (ClienteImpl) obj;
        if ((this.DNI == null) ? (other.DNI != null) : !this.DNI.equals(other.DNI)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.DNI != null ? this.DNI.hashCode() : 0);
        return hash;
    }

    public String toString(){
        return getNombre();
    }



}
