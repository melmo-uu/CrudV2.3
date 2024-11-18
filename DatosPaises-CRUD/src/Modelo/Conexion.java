package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    private String ip = "10.160.0.127"; 
    private String bd = "Jailolito";
    private String url="jdbc:mysql://"+ip+":3306/"+bd;
    private String user="alumnos"; 
    private String pass="alumnos"; 
    
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {         
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return con;
    }
}
