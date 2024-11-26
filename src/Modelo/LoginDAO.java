package Modelo;

import Controlador.Conexion;
import Controlador.LoginControlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashSet;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public LoginControlador log(String Dni, String Contrasenea){
        LoginControlador l = new LoginControlador();
        String sql = "SELECT Dni, Contraseña FROM Usuario WHERE Dni = ? AND Contraseña = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Dni);
            ps.setString(2, Contrasenea);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                l.setDni(rs.getString("Dni"));
                l.setContrasenea(rs.getString("Contraseña"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error en el login: " + e.toString());
        }
        return l;
    }
    
}
