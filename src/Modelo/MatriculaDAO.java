package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import Controlador.EstudianteControlador;
import Controlador.MatriculaControlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MatriculaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List CargarMatricula() {
        List<MatriculaControlador> ListaMatriculas = new ArrayList<>();

        /*String sql = "SELECT \n"
                + "    M.IdMatricula,\n"
                + "    A.IdAlumno,\n"
                + "    A.ApPaterno,\n"
                + "    A.ApMaterno,\n"
                + "    A.Nombres,\n"
                + "    M.IdProgramaEstudio,\n"
                + "    P.NombreProgramaEstudio,\n"
                + "    M.IdPeriodoLectivo,\n"
                + "    M.IdAula\n"
                + "FROM \n"
                + "    Matricula M\n"
                + "INNER JOIN \n"
                + "    Alumno A ON M.IdAlumno = A.IdAlumno\n"
                + "INNER JOIN \n"
                + "    ProgramaEstudios P ON M.IdProgramaEstudio = P.IdProgramaEstudio;";*/
        String sql = "SELECT * FROM VistaMatriculas";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MatriculaControlador matricula = new MatriculaControlador();
                matricula.setIdMatricula(rs.getString("IdMatricula"));
                matricula.setIdAlumnoMatricula(rs.getString("IdAlumno"));
                matricula.setApPaternoMatricula(rs.getString("ApPaterno"));
                matricula.setApMaternoMatricula(rs.getString("ApMaterno"));
                matricula.setNombresMatricula(rs.getString("Nombres"));
                matricula.setIdProgramaEstudioMatricula(rs.getString("IdProgramaEstudio"));
                matricula.setNombreProgramaEstudioMatricula(rs.getString("NombreProgramaEstudio"));
                matricula.setIdPeriodoLectivoMatricula(rs.getString("IdPeriodoLectivo"));
                matricula.setIdAulaMatricula(rs.getString("IdAula"));

                ListaMatriculas.add(matricula);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaMatriculas;
    }

    public boolean RegistrarMatricula(MatriculaControlador matricula) {
        String sql = "INSERT INTO Matricula (IdMatricula, IdAlumno,IdProgramaEstudio, IdPeriodoLectivo, IdAula) VALUES(?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps = con.prepareStatement(sql);
            ps.setString(1, matricula.getIdMatricula());
            ps.setString(2, matricula.getIdAlumnoMatricula());
            ps.setString(3, matricula.getIdProgramaEstudioMatricula());
            ps.setString(4, matricula.getIdPeriodoLectivoMatricula());
            ps.setString(5, matricula.getIdAulaMatricula());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Registro de matrícula guardado");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    
    public void ModificarMatricula(MatriculaControlador matricula) {
        // Crear la consulta SQL para actualizar los datos del usuario
        String sql = "UPDATE Matricula SET IdMatricula = ?, IdProgramaEstudio = ?, IdPeriodoLectivo = ?, IdAula = ? WHERE IdMatricula = ?";

        try (Connection con = cn.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            ps.setString(1, matricula.getIdMatricula());
            ps.setString(2, matricula.getIdProgramaEstudioMatricula());
            ps.setString(3, matricula.getIdPeriodoLectivoMatricula());
            ps.setString(4, matricula.getIdAulaMatricula());
            ps.setString(5, matricula.getIdMatricula());

            ps.executeUpdate();
            // Ejecutar la actualización          
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
