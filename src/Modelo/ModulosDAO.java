/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Conexion;
import Controlador.ModulosControlador;
import Controlador.ProgramaEstudioControlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN CASANA
 */
public class ModulosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarModulos(ModulosControlador Modu) {
        String sql = "INSERT INTO Modulo (IdModulo, NombreModulo, IdProgramaEstudios) VALUES(?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Modu.getIdModulo());
            ps.setString(2, Modu.getNombreModulo());
            ps.setString(3, Modu.getIdProgramaEstudios());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                    con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    
    public List CargarModulos(){
        List<ModulosControlador> ListaModulos = new ArrayList<>();
        
        String sql = "SELECT IdModulo, NombreModulo, IdProgramaEstudios FROM Modulo;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                ModulosControlador mod = new ModulosControlador();
                mod.setIdModulo(rs.getString("IdModulo"));
                mod.setNombreModulo(rs.getString("NombreModulo"));
                mod.setIdProgramaEstudios(rs.getString("IdProgramaEstudios"));      
            
                ListaModulos.add(mod);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaModulos;
    }
    
    public void ModificarModulos(ModulosControlador Modu) {
        // Crear la consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE Modulo SET IdModulo = ?, NombreModulo = ? WHERE IdModulo = ?";

        try (Connection con = cn.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, Modu.getIdModulo());
            ps.setString(2, Modu.getNombreModulo());
            //ps.setString(3, Modu.getIdProgramaEstudios());
            ps.setString(3, Modu.getIdModulo());
            

            // Ejecutar la actualización
            ps.execute();

            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
