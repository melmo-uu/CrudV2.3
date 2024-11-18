package Controlador;

import Modelo.Conexion;
import Modelo.Pais;
import Vista.Ventana;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class PaisOperaciones {
    
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Pais p = new Pais();
    Ventana vista = new Ventana();
    
    
    public int agregar(Pais pais) {  
        int r=0;
        String sql="insert into pais(codigoPais,nombrePais,continentePais,poblacionPais, tipoGobierno)values(?,?,?,?,?)";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,pais.getCodigo());
            ps.setString(2,pais.getNombre());
            ps.setString(3,pais.getContinente());
            ps.setInt(4,pais.getPoblacion());
            ps.setInt(5, pais.getTipoGobierno());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
            }catch(Exception e)
            {
                  JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        return r;
    }
    public int modificar(Pais pais) {  
        int r=0;
        String sql = "UPDATE pais SET nombrePais = ?, continentePais = ?, poblacionPais = ?, tipoGobierno = ? WHERE codigoPais = ?";
            try{
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, pais.getNombre());
                ps.setString(2, pais.getContinente());
                ps.setInt(3, pais.getPoblacion());
                ps.setInt(4, pais.getTipoGobierno());  
                ps.setString(5, pais.getCodigo());
                r = ps.executeUpdate();

                if (r == 1) {
                    return 1;
                    
                } else {
                    return 0;
                }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Se Produjo un error al intentar modificar el país.", "Error", JOptionPane.ERROR_MESSAGE);

        }
        return r;
    }
    public int eliminar(String codigo){
        int r=0;
        String sql = "Delete From pais "
                + "where codigoPais = ?";
        try{
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);  
        ps.setString(1,codigo);
        r = ps.executeUpdate();
        if(r == 1){
            return 1;
            
        }
        else{
            return 0;
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el país: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        
        return r;
    }
    public List<Pais> Consultar(String nombre){
        List<Pais> paises = new ArrayList<>();
        String sql = "SELECT * FROM pais WHERE nombrePais = ?";
            try {
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                rs = ps.executeQuery();
                
                    while (rs.next()) {
                        Pais pais = new Pais();
                        pais.setCodigo(rs.getString("codigoPais"));
                        pais.setNombre(rs.getString("nombrePais"));
                        pais.setContinente(rs.getString("continentePais"));
                        pais.setPoblacion(rs.getInt("poblacionPais"));
                        pais.setTipoGobierno(rs.getInt("tipoGobierno"));
                        paises.add(pais);
                    }
                    
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el país: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            return paises;
    }
}