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
    //jdbc:sqlserver://localhost\MSSQLSERVER:1433;databaseName=PruebaBoletaNotas;encrypt=false;trustServerCertificate=true;
    String url = "jdbc:sqlserver://localhost\\DESKTOP-FUJUMR7:1433; databaseName=PruebaBoletaNotas;instance=MSSQLSERVER;encrypt=false;trustServerCertificate=true;";
    private static final String usuario = "sa";
    private static final String contrasena = "root";

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = (Connection) DriverManager.getConnection(url, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar con la base de datos:" + e.getMessage());
        }
        return con;
    }
}
