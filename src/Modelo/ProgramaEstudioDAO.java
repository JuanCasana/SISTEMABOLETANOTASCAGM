package Modelo;

import Controlador.Conexion;
import Controlador.EstudianteControlador;
import Controlador.ProgramaEstudioControlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProgramaEstudioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProgramaEstudios(ProgramaEstudioControlador ProEst) {
        String sql = "INSERT INTO ProgramaEstudios (IdProgramaEstudio, NombreProgramaEstudio, NumeroModulos) VALUES(?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ProEst.getIdProgramaEstudio());
            ps.setString(2, ProEst.getProgramaEstudio());
            ps.setString(3, ProEst.getCantModulos());
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
    
    public List CargarProgramaEstudio(){
        List<ProgramaEstudioControlador> ListaProgramaEstudio = new ArrayList<>();
        
        String sql = "SELECT IdProgramaEstudio, NombreProgramaEstudio, NumeroModulos FROM ProgramaEstudios;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
               ProgramaEstudioControlador ProgramaEstudio = new ProgramaEstudioControlador();
                ProgramaEstudio.setIdProgramaEstudio(rs.getString("IdProgramaEstudio"));
                ProgramaEstudio.setProgramaEstudio(rs.getString("NombreProgramaEstudio"));
                ProgramaEstudio.setCantModulos(rs.getString("NumeroModulos"));

                ListaProgramaEstudio.add(ProgramaEstudio);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaProgramaEstudio;
    }
    
    public void ModificarProgramaEstudio(ProgramaEstudioControlador ProEst) {
        // Crear la consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE ProgramaEstudios SET IdProgramaEstudio = ?, NombreProgramaEstudio = ?, NumeroModulos = ? WHERE IdProgramaEstudio = ?";

        try (Connection con = cn.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, ProEst.getIdProgramaEstudio());
            ps.setString(2, ProEst.getProgramaEstudio());
            ps.setString(3, ProEst.getCantModulos());
            ps.setString(4, ProEst.getIdProgramaEstudio());
            
            // Ejecutar la actualización
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
