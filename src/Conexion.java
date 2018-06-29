
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Horacio Ramírez
 */
public class Conexion {

    private String rutaBBDD;
    private String usuario;
    private String clave = "";
    private Connection conexion;

    public Conexion() {
        
        this.rutaBBDD = "jdbc:mysql://localhost:3306/feelgood";
        this.usuario = "root";
        this.clave = ""; 
        this.conexion = null;
    }

    public String getRutaBBDD() {
        return rutaBBDD;
    }

    public void setRutaBBDD(String rutaBBDD) {
        this.rutaBBDD = rutaBBDD;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    public Connection conectar(){
         try {
            conexion = DriverManager.getConnection(rutaBBDD, usuario, clave);
            
        } catch (SQLException ex) {
            System.exit(0);
        }
         return conexion;
    }
}
