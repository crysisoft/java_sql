/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Itihell
 */
public class Procedimientos {

    public static void EntradaArticulo(String a, String b, String c)
            throws SQLException {
        CallableStatement entrada
                = Conexion.getConextion().prepareCall("{call EntradaArticulo(?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.execute();
    }
}
