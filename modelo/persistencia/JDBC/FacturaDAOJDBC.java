/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import modelo.persistencia.FacturaDAO;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class FacturaDAOJDBC implements FacturaDAO {

    public List<Factura> listByCliente(String dni) {
        List<Factura> facturas = new ArrayList<Factura>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vfacturas where DNI="+dni);
            String nombre,direccion, id_factura;
            Double importe;
            while (res.next()) {
                //DNI = res.getString("DNI");
                nombre=res.getString("nombre");
                direccion=res.getString("direccion");
                id_factura = res.getString("identificador");
                importe = res.getDouble("importe");

                //creo cliente
                Cliente cliente = new ClienteImpl(dni,nombre,direccion);
                //Añado la factura
                facturas.add(new FacturaImpl(id_factura, cliente, importe));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return facturas;
    }

    public void create(Factura entidad) {
        String sql = "insert into facturas(identificador,id_cliente,importe) values (?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getIdentificador());
            stm.setString(2, entidad.getCliente().getDNI());
            stm.setDouble(3, entidad.getImporte());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Factura read(String pk) {
        Factura f = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM facturas where identificador=" + pk);
            String identificador, id_cliente;
            Double importe;
            if (res.next()) {
                identificador = res.getString("identificador");
                id_cliente = res.getString("id_cliente");
                importe = res.getDouble("importe");
                //Leo el Cliente
                Cliente cliente = (new ClienteDAOJDBC()).read(id_cliente);
                //Creo la factura
                f = new FacturaImpl(identificador, cliente, importe);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return f;
    }

    public void update(Factura entidad) {
        String sql = "update facturas set id_cliente=?, importe=? where identificador like ?";
        
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(3, entidad.getIdentificador());
            stm.setString(1, entidad.getCliente().getDNI());
            stm.setDouble(2, entidad.getImporte());
        
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Factura entidad) {
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM facturas where identificador=" + entidad.getIdentificador());



        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Factura> list() {
        List<Factura> facturas = new ArrayList<Factura>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vfacturas");
            String DNI,nombre,direccion, id_factura;
            Double importe;
            while (res.next()) {
                DNI = res.getString("DNI");
                nombre=res.getString("nombre");
                direccion=res.getString("direccion");
                id_factura = res.getString("identificador");
                importe = res.getDouble("importe");

                //creo cliente
                Cliente cliente = new ClienteImpl(DNI,nombre,direccion);
                //Añado la factura
                facturas.add(new FacturaImpl(id_factura, cliente, importe));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return facturas;
    }
}
