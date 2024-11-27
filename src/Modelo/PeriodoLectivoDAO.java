package Modelo;

import Controlador.Conexion;
import Controlador.PeriodoLectivoControlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PeriodoLectivoDAO {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarPeriodoLectivo(PeriodoLectivoControlador PerioLect) {
        String sql = "INSERT INTO PeriodoLectivo (IdPeriodoLectivo, AnioPeriodoLectivo, NumeroPeriodoLectivo) VALUES(?,?,?)";
        try {   
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, PerioLect.getIdPeriodoLectivo());
            ps.setString(2, PerioLect.getAnioPeriodoLectivo());
            ps.setString(3, PerioLect.getNumeroPeriodoLectivo());
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
    
    public List CargarPeriodoLectivo(){
        List<PeriodoLectivoControlador> ListaPeriodoLectivo = new ArrayList<>();
        
        String sql = "SELECT IdPeriodoLectivo, AnioPeriodoLectivo, NumeroPeriodoLectivo FROM PeriodoLectivo;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                PeriodoLectivoControlador PeriodoLectivo = new PeriodoLectivoControlador();
                PeriodoLectivo.setIdPeriodoLectivo(rs.getString("IdPeriodoLectivo"));
                PeriodoLectivo.setAnioPeriodoLectivo(rs.getString("AnioPeriodoLectivo"));
                PeriodoLectivo.setNumeroPeriodoLectivo(rs.getString("NumeroPeriodoLectivo"));

                ListaPeriodoLectivo.add(PeriodoLectivo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPeriodoLectivo;
    }
    
    public void ModificarPeriodoLectivo(PeriodoLectivoControlador PerioLect) {
        // Crear la consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE PeriodoLectivo SET IdPeriodoLectivo = ?, AnioPeriodoLectivo = ?, NumeroPeriodoLectivo = ? WHERE IdPeriodoLectivo = ?";

        try (Connection con = cn.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, PerioLect.getIdPeriodoLectivo());
            ps.setString(2, PerioLect.getAnioPeriodoLectivo());
            ps.setString(3, PerioLect.getNumeroPeriodoLectivo());
            ps.setString(4, PerioLect.getIdPeriodoLectivo());
            
            // Ejecutar la actualización
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
