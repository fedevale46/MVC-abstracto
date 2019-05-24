/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class FacturaImpl implements Factura {
    private String identifiador;
    private Cliente cliente;
    private Double importe;

    public FacturaImpl(String identificador) {
        this(identificador,null,null);
    }


    public FacturaImpl(String identifiador, Cliente cliente) {
        this(identifiador,cliente,null);
    }

    public FacturaImpl(String identifiador, Cliente cliente, Double importe) {
        this.identifiador = identifiador;
        this.cliente = cliente;
        this.importe = importe;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public String getIdentificador() {
        return identifiador;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    
      
    
    

}
