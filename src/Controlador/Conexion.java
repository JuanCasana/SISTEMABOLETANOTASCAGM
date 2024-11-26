/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    Connection con;
        String url = "jdbc:sqlserver://localhost\\JUANCASANA:1433;databaseName=PruebaBoletaNotas;instance=MSSQLSERVER;encrypt=false;trustServerCertificate=true;";
    private static final String usuario = "jcasana";
    private static final String contrasena = "jcasana0803";
    
    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = (Connection) DriverManager.getConnection(url, usuario, contrasena);
            //JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            
        } catch (ClassNotFoundException | SQLException e)  {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
         }
         return con;
        }
}