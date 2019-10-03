/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author Itihell
 */
public class Conexion {

    static Connection contacto = null;
    // Nuevas Variables agregadas
    public static String usuario;
    public static String password;
    public static boolean status = false;

    public static Connection getConextion() {
        status = false;
        String url = "jdbc:sqlserver://DESKTOP-V5SGHNR:1433;databaseName=curso";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion revisar driver " + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE
            );
        }
        try {
            contacto = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
            status = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }

    //Nuevo m´etodo agregado
    public static void setcuenta(String usuario, String password) {        
        Conexion.usuario = usuario;
        Conexion.password = password;
    }

    public static boolean getstatus() {
        return status;
    }

    public static ResultSet Consulta(String consulta) {
        Connection con = getConextion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
