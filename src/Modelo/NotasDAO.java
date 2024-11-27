package Modelo;

import Controlador.Conexion;
import Controlador.NotasControlador;
import Controlador.UsuarioControlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarNota(NotasControlador not) {
        String sql = "INSERT INTO Notas (IdMatricula, IdUnidadDidactica, Nota, FechaRegistro) VALUES(?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, not.getIdMatricula());
            ps.setString(2, not.getIdUnidadDidactica());
            ps.setInt(3, not.getNota());
            LocalDateTime fechaActual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaRegistroNotas = fechaActual.format(formato);

            ps.setString(4, fechaRegistroNotas);
           
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

    public List CargarNotas() {
        List<NotasControlador> ListaNot = new ArrayList<>();

        String sql = "SELECT * FROM VistaNotasConUnidad;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NotasControlador not = new NotasControlador();
                not.setIdNota(rs.getInt("IdNota"));
                not.setIdMatricula(rs.getString("IdMatricula"));
                not.setIdUnidadDidactica(rs.getString("IdUnidadDidactica"));
                not.setUnidadDidactica(rs.getString("NombreUnidadDidactica"));
                not.setNota(rs.getInt("Nota"));
                not.setFechaRegistro(rs.getString("FechaRegistro"));


                ListaNot.add(not);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaNot;
    }
    
    public void ModificarNota(NotasControlador not) {
        // Crear la consulta SQL para actualizar los datos de las notas
        String sql = "UPDATE Notas SET IdMatricula = ?, Nota = ?, FechaRegistro = ? WHERE IdNota = ?";

        try (
                Connection con = cn.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, not.getIdMatricula());
            ps.setInt(2, not.getNota());
            ps.setString(3, not.getFechaRegistro());
            ps.setInt(4, not.getIdNota());


            // Ejecutar la actualización
            //ps.executeUpdate();
            // Ejecutar la actualización y verificar si se actualizó alguna fila
        int filasActualizadas = ps.executeUpdate();
        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "Datos de la Nota actualizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar.");
        }
        } catch (SQLException e) {
                    throw new RuntimeException("Error al actualizar la nota: " + e.getMessage());
        }
    }
}
