package Modelo;

import Controlador.Conexion;
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
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarUsuario(UsuarioControlador user) {
        String sql = "INSERT INTO Usuario (Dni, ApPaterno, ApMaterno, Nombres, Email, Celular, Contraseña, NivelAcceso, Estado) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getDniUsuario());
            ps.setString(2, user.getApPaternoUsuario());
            ps.setString(3, user.getApMaternoUsuario());
            ps.setString(4, user.getNombresUsuario());
            ps.setString(5, user.getEmailUsuario());
            ps.setString(6, user.getCelularUsuario());
            ps.setString(7, user.getContraseñaUsuario());
            ps.setString(8, user.getNivelAccesoUsuario());
            ps.setInt(9, 1);
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

    public List CargarUsuario() {
        List<UsuarioControlador> ListaUs = new ArrayList<>();

                        //IdUsuario, Dni, ApPaterno, ApMaterno, Nombres, Email, Celular, NivelAcceso 
        String sql = "SELECT * FROM Usuario WHERE Estado = 1;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioControlador user = new UsuarioControlador();
                user.setIdUsuario(rs.getInt("IdUsuario"));
                user.setDniUsuario(rs.getString("Dni"));
                user.setApPaternoUsuario(rs.getString("ApPaterno"));
                user.setApMaternoUsuario(rs.getString("ApMaterno"));
                user.setNombresUsuario(rs.getString("Nombres"));
                user.setEmailUsuario(rs.getString("Email"));
                user.setCelularUsuario(rs.getString("Celular"));
                user.setNivelAccesoUsuario(rs.getString("NivelAcceso"));

                ListaUs.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaUs;
    }

    public boolean EliminarUsuario(int Id) {
        String sql = "UPDATE Usuario SET Estado = 0 WHERE IdUsuario = ?";//"DELETE FROM Usuario WHERE IdUsuario = ?";
        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, Id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

    }

    public void ModificarUsuario(UsuarioControlador user) {
        // Crear la consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE Usuario SET Dni = ?, ApPaterno = ?, ApMaterno = ?, Nombres = ?, Email = ?, Celular = ?, NivelAcceso = ?"
                + (user.getContraseñaUsuario() != null ? ", Contraseña = ?" : "")
                + " WHERE IdUsuario = ?";

        try (
                Connection con = cn.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, user.getDniUsuario());
            ps.setString(2, user.getApPaternoUsuario());
            ps.setString(3, user.getApMaternoUsuario());
            ps.setString(4, user.getNombresUsuario());
            ps.setString(5, user.getEmailUsuario());
            ps.setString(6, user.getCelularUsuario());
            ps.setString(7, user.getNivelAccesoUsuario());

            // Establecer la contraseña solo si se ha proporcionado un nuevo valor
            if (user.getContraseñaUsuario() != null) {
                ps.setString(8, user.getContraseñaUsuario());
                ps.setInt(9, user.getIdUsuario());
            } else {
                ps.setInt(8, user.getIdUsuario());
            }

            // Ejecutar la actualización
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
