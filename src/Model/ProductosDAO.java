
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ProductosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProducto(Productos pr){
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getCodigo());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getProveedor());
            ps.setInt(4, pr.getStock());            
            ps.setDouble(5, pr.getPrecio());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
            return false;
        }finally{
            try {
                con.close();     
                
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            
        }
    }
    
    public List ListarProductos(){
        List <Productos> ListaPr = new ArrayList();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Productos pr = new Productos();
                pr.setId(rs.getInt("id"));
                pr.setCodigo(rs.getString("codigo"));
                pr.setNombre(rs.getString("nombre"));                
                pr.setProveedor(rs.getString("proveedor"));
                pr.setStock(rs.getInt("stock"));
                pr.setPrecio(rs.getDouble("precio"));
                ListaPr.add(pr);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPr;
    }
    
    public void ConsultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre FROM proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                proveedor.addItem(rs.getString("nombre"));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public boolean EliminarProducto(int id) throws SQLException{
        String sql = "DELETE FROM productos WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            con.close();
        }
    }
    
    public boolean ModificarProducto(Productos pro){
        String sql = "UPDATE productos SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());            
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
    
    public Config BuscarDatos(){
        Config config = new Config();
        String sql = "SELECT * FROM config";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                config.setId(rs.getInt("id"));
                config.setCuil(rs.getString("cuil"));
                config.setNombre(rs.getString("nombre"));                
                config.setTelefono(rs.getInt("telefono"));
                config.setDireccion(rs.getString("direccion"));                
                config.setRazon(rs.getString("razon"));                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return config;
    }
    
    public boolean ModificarDatos(Config config){
        String sql = "UPDATE config SET cuil=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, config.getCuil());
            ps.setString(2, config.getNombre());
            ps.setInt(3, config.getTelefono());
            ps.setString(4, config.getDireccion());
            ps.setString(5, config.getRazon());            
            ps.setInt(6, config.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean RegistrarDatos(Config config){
        String sql = "INSERT INTO config (cuil, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, config.getCuil());
            ps.setString(2, config.getNombre());
            ps.setInt(3, config.getTelefono());
            ps.setString(4, config.getDireccion());            
            ps.setString(5, config.getRazon());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
            return false;
        }finally{
            try {
                con.close();     
                
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            
        }
    }
    
}


