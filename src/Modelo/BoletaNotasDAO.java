package Modelo;

import Controlador.BoletaNotasControlador;
import Controlador.Conexion;
import Controlador.EstudianteControlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoletaNotasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<BoletaNotasControlador> CargarEstudianteBN(String dni) {
        List<BoletaNotasControlador> ListaEstudianteBN = new ArrayList<>();

        String sql = "SELECT * FROM VistaAlumnoMatricula WHERE Dni = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);  // Establecer el DNI como parámetro de búsqueda
            rs = ps.executeQuery();
            while (rs.next()) {
                BoletaNotasControlador estudianteBN = new BoletaNotasControlador();
                estudianteBN.setIdAlumnoBN(rs.getString("IdAlumno"));
                estudianteBN.setDni(rs.getString("Dni"));
                estudianteBN.setIdMatriculaBN(rs.getString("IdMatricula"));
                estudianteBN.setNombreCompletoBN(rs.getString("NombreCompleto"));
                estudianteBN.setNombreProgramaEstudioBN(rs.getString("NombreProgramaEstudio"));
                estudianteBN.setIdPeriodoAcademicoBN(rs.getString("IdPeriodoAcademico"));
                estudianteBN.setPerioLectiBN(rs.getString("IdPeriodoLectivo"));
                ListaEstudianteBN.add(estudianteBN);
            }
        } catch (SQLException e) {
            System.out.println("Error en CargarEstudianteBN: " + e.toString());
        }
        return ListaEstudianteBN;
    }

    public List<BoletaNotasControlador> CargarNotasBN(String idMatricula) {
        List<BoletaNotasControlador> ListaNotasBN = new ArrayList<>();

        String sql = "SELECT * FROM VistaUnidadesDidacticasNotas WHERE idMatricula = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            // Establece el valor del parámetro DNI
            ps.setString(1, idMatricula);  // Asumiendo que 'dni' es el valor que quieres pasar

            rs = ps.executeQuery();
            while (rs.next()) {
                BoletaNotasControlador estudianteBN = new BoletaNotasControlador();
                estudianteBN.setDniNotaBN(rs.getString("Dni"));
                estudianteBN.setCorrelativo(rs.getString("Correlativo"));
                estudianteBN.setNombreUDBN(rs.getString("NombreUnidadDidactica"));
                estudianteBN.setCreditoUDBN(rs.getString("CreditosUnidadDidactica"));
                estudianteBN.setNotasUDBN(rs.getString("Nota"));
                //estudianteBN.setPerioLectiBN(rs.getString("IdPeriodoLectivo"));

                ListaNotasBN.add(estudianteBN);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
        return ListaNotasBN;
    }

    public List<BoletaNotasControlador> CargarDesemBN(String IdMatricula) {
        List<BoletaNotasControlador> ListaDesempenoBN = new ArrayList<>();

        String sql = "SELECT * FROM VistaDesempenoEstudiante WHERE idMatricula = ?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            // Establece el valor del parámetro DNI
            ps.setString(1, IdMatricula);

            rs = ps.executeQuery();
            while (rs.next()) {
                BoletaNotasControlador estudianteDesemBN = new BoletaNotasControlador();
                estudianteDesemBN.setTotalCreditosDesemBN(rs.getString("IdAlumno"));
                estudianteDesemBN.setTotalCreditosDesemBN(rs.getString("TotalCreditos"));
                estudianteDesemBN.setCreditosAprobadosDesemBN(rs.getString("CreditosAprobados"));
                estudianteDesemBN.setCreditosDesaprobadosDesemBN(rs.getString("CreditosDesaprobados"));
                estudianteDesemBN.setPromedioGeneralDesemBN(rs.getString("PromedioGeneral"));
                estudianteDesemBN.setPuntajeTotalDesemBN(rs.getString("PuntajeTotal"));
                estudianteDesemBN.setOrdenMeritoDesemBN(rs.getString("OrdenMerito"));

                ListaDesempenoBN.add(estudianteDesemBN);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
        }
        return ListaDesempenoBN;
    }
    
    

}
