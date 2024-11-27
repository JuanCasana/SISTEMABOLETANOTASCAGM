package Modelo;

import Controlador.Conexion;
import Controlador.EstudianteControlador;
import Controlador.UnidadDidacticaControlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UnidadDidacticaDAO {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
    public boolean RegistrarUnidadDidactica(UnidadDidacticaControlador UnidadDidactica) {
        String sql = "INSERT INTO UnidadDidactica (IdUnidadDidactica, NombreUnidadDidactica,HorasUnidadDidactica , CreditosUnidadDidactica, IdProgramaEstudios, IdModulo) VALUES(?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, UnidadDidactica.getIdUnidadDidactica());
            ps.setString(2, UnidadDidactica.getNombreUnidadDidactica());
            ps.setString(3, UnidadDidactica.getHorasUnidadDidactica());
            ps.setString(4, UnidadDidactica.getCreditosUnidadDidactica());
            ps.setString(5, UnidadDidactica.getIdProgramaEstudios());
            ps.setString(6, UnidadDidactica.getIdModulo());

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
    
    public List CargarUnidadDidactica(){
        List<UnidadDidacticaControlador> ListaUnidadDidactica = new ArrayList<>();
        
        String sql = "SELECT IdUnidadDidactica, NombreUnidadDidactica,HorasUnidadDidactica , CreditosUnidadDidactica, IdProgramaEstudios, IdModulo FROM UnidadDidactica;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                UnidadDidacticaControlador unidadAcademica = new UnidadDidacticaControlador();
                unidadAcademica.setIdUnidadDidactica(rs.getString("IdUnidadDidactica"));
                unidadAcademica.setNombreUnidadDidactica(rs.getString("NombreUnidadDidactica"));
                unidadAcademica.setHorasUnidadDidactica(rs.getString("HorasUnidadDidactica"));
                unidadAcademica.setCreditosUnidadDidactica(rs.getString("CreditosUnidadDidactica"));
                unidadAcademica.setIdProgramaEstudios(rs.getString("IdProgramaEstudios"));
                unidadAcademica.setIdModulo(rs.getString("IdModulo"));
                               
                ListaUnidadDidactica.add(unidadAcademica);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaUnidadDidactica;
    }
    
    //MODIFICAR
    public void ModificarUnidadDidactica(UnidadDidacticaControlador UnidadDidactica) {
        // Crear la consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE UnidadDidactica SET IdUnidadDidactica = ?, NombreUnidadDidactica = ?, HorasUnidadDidactica = ?, CreditosUnidadDidactica = ?, IdProgramaEstudios = ?, IdModulo = ? WHERE IdUnidadDidactica = ?";

        try (Connection con = cn.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, UnidadDidactica.getIdUnidadDidactica());
            ps.setString(2, UnidadDidactica.getNombreUnidadDidactica());
            ps.setString(3, UnidadDidactica.getHorasUnidadDidactica());
            ps.setString(4, UnidadDidactica.getCreditosUnidadDidactica());
            ps.setString(5, UnidadDidactica.getIdProgramaEstudios());
            ps.setString(6, UnidadDidactica.getIdModulo());
            
            ps.setString(7, UnidadDidactica.getIdUnidadDidactica());

            // Ejecutar la actualización
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
