package Modelo;

import Controlador.Conexion;
import Controlador.EstudianteControlador;
import Controlador.UsuarioControlador;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EstudianteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEstudiante(EstudianteControlador estudiante) {
        String sql = "INSERT INTO Alumno (IdAlumno, Dni, ApPaterno, ApMaterno, Nombres, Email, Celular,Sexo, AnioIngreso) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getIdAlumno());
            ps.setString(2, estudiante.getDniAlumno());
            ps.setString(3, estudiante.getApPaternoAlumno());
            ps.setString(4, estudiante.getApMaternoAlumno());
            ps.setString(5, estudiante.getNombresAlumno());
            ps.setString(6, estudiante.getEmailAlumno());
            ps.setString(7, estudiante.getCelularAlumno());
            ps.setString(9, estudiante.getAneoIngresoAlumno());
            ps.setString(8, estudiante.getSexoAlumno());
            ps.execute();
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
    
    public List CargarEstudiante(){
        List<EstudianteControlador> ListaEstudiantes = new ArrayList<>();
        
        String sql = "SELECT IdAlumno, Dni, ApPaterno, ApMaterno, Nombres, Email, Celular, Sexo, AnioIngreso FROM Alumno;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                EstudianteControlador estudiante = new EstudianteControlador();
                estudiante.setIdAlumno(rs.getString("IdAlumno"));
                estudiante.setDniAlumno(rs.getString("Dni"));
                estudiante.setApPaternoAlumno(rs.getString("ApPaterno"));
                estudiante.setApMaternoAlumno(rs.getString("ApMaterno"));
                estudiante.setNombresAlumno(rs.getString("Nombres"));
                estudiante.setEmailAlumno(rs.getString("Email"));
                estudiante.setCelularAlumno(rs.getString("Celular"));
                estudiante.setSexoAlumno(rs.getString("Sexo"));
                estudiante.setAneoIngresoAlumno(rs.getString("AnioIngreso"));
                
                ListaEstudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaEstudiantes;
    }
    
    public void ModificarEstudiante(EstudianteControlador estudiante) {
        // Crear la consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE Alumno SET Dni = ?, ApPaterno = ?, ApMaterno = ?, Nombres = ?, Email = ?, Celular = ? WHERE IdAlumno = ?";

        try (Connection con = cn.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, estudiante.getDniAlumno());
            ps.setString(2, estudiante.getApPaternoAlumno());
            ps.setString(3, estudiante.getApMaternoAlumno());
            ps.setString(4, estudiante.getNombresAlumno());
            ps.setString(5, estudiante.getEmailAlumno());
            ps.setString(6, estudiante.getCelularAlumno());
            
            ps.setString(7, estudiante.getIdAlumno());

            // Ejecutar la actualización
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
