/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.BoletaNotasReporte;
import Controlador.BoletaNotasControlador;
import Controlador.EstudianteControlador;
import Controlador.MatriculaControlador;
import Controlador.ModulosControlador;
import Controlador.NotasControlador;
import Controlador.PeriodoLectivoControlador;
import Controlador.ProgramaEstudioControlador;
import Controlador.UnidadDidacticaControlador;
import Controlador.UsuarioControlador;
import Modelo.BoletaNotasDAO;
import Modelo.EstudianteDAO;
import Modelo.MatriculaDAO;
import Modelo.ModulosDAO;
import Modelo.MultiLineTableCellRenderer;
import Modelo.NotasDAO;
import Modelo.PeriodoLectivoDAO;
import Modelo.ProgramaEstudioDAO;
import Modelo.UnidadDidacticaDAO;
import Modelo.UsuarioDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sistema extends javax.swing.JFrame {

    ButtonGroup btnGr;
    ButtonGroup btnGrAlumno;
    DefaultTableModel modelo = new DefaultTableModel();

    UsuarioControlador user = new UsuarioControlador();
    UsuarioDAO usuario = new UsuarioDAO();
    EstudianteControlador estudiante = new EstudianteControlador();
    EstudianteDAO estudiantes = new EstudianteDAO();
    ProgramaEstudioControlador PrograEstudio = new ProgramaEstudioControlador();
    ProgramaEstudioDAO PrograEstudios = new ProgramaEstudioDAO();
    ModulosControlador modulo = new ModulosControlador();
    ModulosDAO modulos = new ModulosDAO();
    UnidadDidacticaControlador unidaDidactica = new UnidadDidacticaControlador();
    UnidadDidacticaDAO unidadesDidacticas = new UnidadDidacticaDAO();
    PeriodoLectivoControlador periodoLectivo = new PeriodoLectivoControlador();
    PeriodoLectivoDAO periodosLectivos = new PeriodoLectivoDAO();
    MatriculaControlador matricula = new MatriculaControlador();
    MatriculaDAO matriculas = new MatriculaDAO();
    NotasControlador nota = new NotasControlador();
    NotasDAO notas = new NotasDAO();
    BoletaNotasControlador estudianteBN = new BoletaNotasControlador();
    BoletaNotasDAO estudiantesBNs = new BoletaNotasDAO();

    public Sistema() {
        btnGr = new ButtonGroup();
        btnGrAlumno = new ButtonGroup();

        initComponents();
        LimpiarUsuarios();
        this.setLocationRelativeTo(null);
        btnGr.add(rbAdm);
        btnGr.add(rbAsist);
        btnGrAlumno.add(rbMasculino);
        btnGrAlumno.add(rbFemenino);
        txtId.setVisible(false);
        txtIdMatriculaBN.setVisible(false);
        txtIdMatriculaBNs.setVisible(false);

    }
    

    //FUNCIONA
    public void CargarUsuario() {
        List<UsuarioControlador> CargarUs = usuario.CargarUsuario();
        modelo = (DefaultTableModel) tblUsuarios.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < CargarUs.size(); i++) {
            ob[0] = CargarUs.get(i).getIdUsuario();
            ob[1] = CargarUs.get(i).getDniUsuario();
            ob[2] = CargarUs.get(i).getApPaternoUsuario();
            ob[3] = CargarUs.get(i).getApMaternoUsuario();
            ob[4] = CargarUs.get(i).getNombresUsuario();
            ob[5] = CargarUs.get(i).getEmailUsuario();
            ob[6] = CargarUs.get(i).getCelularUsuario();
            ob[7] = CargarUs.get(i).getNivelAccesoUsuario();
            modelo.addRow(ob);
        }
        tblUsuarios.setModel(modelo);
    }

    //FUNCIONA
    public void CargarEstudiante() {
        List<EstudianteControlador> CargarEs = estudiantes.CargarEstudiante();
        modelo = (DefaultTableModel) tblEstudiante.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < CargarEs.size(); i++) {
            ob[0] = CargarEs.get(i).getIdAlumno();
            ob[1] = CargarEs.get(i).getDniAlumno();
            ob[2] = CargarEs.get(i).getApPaternoAlumno();
            ob[3] = CargarEs.get(i).getApMaternoAlumno();
            ob[4] = CargarEs.get(i).getNombresAlumno();
            ob[5] = CargarEs.get(i).getEmailAlumno();
            ob[6] = CargarEs.get(i).getCelularAlumno();
            ob[7] = CargarEs.get(i).getSexoAlumno();
            ob[8] = CargarEs.get(i).getAneoIngresoAlumno();

            modelo.addRow(ob);

        }

        tblEstudiante.setModel(modelo);
    }

    //FUNCIONA
    public void CargarProgramaEstudio() {
        List<ProgramaEstudioControlador> CargarPE = PrograEstudios.CargarProgramaEstudio();
        modelo = (DefaultTableModel) tblProgramaEstudios.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < CargarPE.size(); i++) {
            ob[0] = CargarPE.get(i).getIdProgramaEstudio();
            ob[1] = CargarPE.get(i).getProgramaEstudio();
            ob[2] = CargarPE.get(i).getCantModulos();

            modelo.addRow(ob);
        }
        tblProgramaEstudios.setModel(modelo);
    }

    public void CargarModulos() {
        List<ModulosControlador> CargarMod = modulos.CargarModulos();
        modelo = (DefaultTableModel) TblModulo.getModel();
        //modelo.setRowCount(0);  // Limpiar todas las filas existentes
        Object[] ob = new Object[3];
        for (int i = 0; i < CargarMod.size(); i++) {
            ob[0] = CargarMod.get(i).getIdModulo();
            ob[1] = CargarMod.get(i).getNombreModulo();
            ob[2] = CargarMod.get(i).getIdProgramaEstudios();

            modelo.addRow(ob);
        }
        TblModulo.setModel(modelo);
    }

    public void CargarUnidadDidactica() {
        List<UnidadDidacticaControlador> CargarUd = unidadesDidacticas.CargarUnidadDidactica();
        modelo = (DefaultTableModel) tblUnidadesDidacticas.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < CargarUd.size(); i++) {
            ob[0] = CargarUd.get(i).getIdUnidadDidactica();
            ob[1] = CargarUd.get(i).getNombreUnidadDidactica();
            ob[2] = CargarUd.get(i).getHorasUnidadDidactica();
            ob[3] = CargarUd.get(i).getCreditosUnidadDidactica();
            ob[4] = CargarUd.get(i).getIdProgramaEstudios();
            ob[5] = CargarUd.get(i).getIdModulo();

            modelo.addRow(ob);
        }
        tblUnidadesDidacticas.setModel(modelo);
    }

    public void CargarPeriodoLectivo() {
        List<PeriodoLectivoControlador> CargarPeriodoLect = periodosLectivos.CargarPeriodoLectivo();
        modelo = (DefaultTableModel) tblPeriodoLectivo.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < CargarPeriodoLect.size(); i++) {
            ob[0] = CargarPeriodoLect.get(i).getIdPeriodoLectivo();
            ob[1] = CargarPeriodoLect.get(i).getAnioPeriodoLectivo();
            ob[2] = CargarPeriodoLect.get(i).getNumeroPeriodoLectivo();

            modelo.addRow(ob);
        }
        tblPeriodoLectivo.setModel(modelo);
    }

    public void CargarMatricula() {
        List<MatriculaControlador> CargarEs = matriculas.CargarMatricula();
        modelo = (DefaultTableModel) tblMatricula.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < CargarEs.size(); i++) {
            ob[0] = CargarEs.get(i).getIdMatricula();
            ob[1] = CargarEs.get(i).getIdAlumnoMatricula();
            ob[2] = CargarEs.get(i).getApPaternoMatricula();
            ob[3] = CargarEs.get(i).getApMaternoMatricula();
            ob[4] = CargarEs.get(i).getNombresMatricula();
            ob[5] = CargarEs.get(i).getIdProgramaEstudioMatricula();
            ob[6] = CargarEs.get(i).getNombreProgramaEstudioMatricula();
            ob[7] = CargarEs.get(i).getIdPeriodoLectivoMatricula();
            ob[8] = CargarEs.get(i).getIdAulaMatricula();

            modelo.addRow(ob);

        }

        tblEstudiante.setModel(modelo);
    }

    public void CargarNotas() {
        List<NotasControlador> CargarNot = notas.CargarNotas();
        modelo = (DefaultTableModel) tblNotas.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < CargarNot.size(); i++) {
            ob[0] = CargarNot.get(i).getIdNota();
            ob[1] = CargarNot.get(i).getIdMatricula();
            ob[2] = CargarNot.get(i).getIdUnidadDidactica();
            ob[3] = CargarNot.get(i).getUnidadDidactica();
            ob[4] = CargarNot.get(i).getNota();
            ob[5] = CargarNot.get(i).getFechaRegistro();
            modelo.addRow(ob);
        }
        tblNotas.setModel(modelo);
    }

//// Método para cargar datos en la tabla a partir de la búsqueda
//    public void CargarEstudianteBN(String dni) {
//        List<BoletaNotasControlador> CargarEsBN = estudiantesBNs.CargarEstudianteBN(dni);
//        modelo = (DefaultTableModel) tblEstudianteDesemBN.getModel();
//        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
//        Object[] ob = new Object[6];
//
//        for (BoletaNotasControlador estudianteBN : CargarEsBN) {
//            ob[0] = estudianteBN.getIdAlumnoBN();
//            ob[1] = estudianteBN.getDni();
//            ob[2] = estudianteBN.getIdMatriculaBN();
//            ob[3] = estudianteBN.getNombreCompletoBN();
//            ob[4] = estudianteBN.getNombreProgramaEstudioBN();
//            ob[5] = estudianteBN.getIdPeriodoAcademicoBN();
//            modelo.addRow(ob);
//        }
//        tblEstudianteDesemBN.setModel(modelo);
//    }
    // Método de búsqueda del estudiante por DNI al hacer clic en el botón
    public void buscarEstudiantePorDni() {
        String dni = txtDniBN.getText().trim();

        if (!dni.isEmpty()) {
            List<BoletaNotasControlador> CargarEsBN = estudiantesBNs.CargarEstudianteBN(dni);
            modelo = (DefaultTableModel) tblEstudiantesBN.getModel();
            modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
            Object[] ob = new Object[7];

            for (BoletaNotasControlador estudianteBN : CargarEsBN) {
                ob[0] = estudianteBN.getIdAlumnoBN();
                ob[1] = estudianteBN.getDni();
                ob[2] = estudianteBN.getIdMatriculaBN();
                //ob[3] = estudianteBN.getNombreCompletoBN();
                ob[3] = "<html>" + estudianteBN.getNombreCompletoBN().replace(", ", "<br>") + "</html>"; // Nombre Completo en 2 líneas
                //ob[4] = estudianteBN.getNombreProgramaEstudioBN();
                // Dividir el nombre del programa en dos líneas
                String nombrePrograma = estudianteBN.getNombreProgramaEstudioBN();

                // Dividimos el texto en dos líneas automáticamente si tiene más de dos palabras
                String nombreDividido;
                String[] palabras = nombrePrograma.split(" ");

                // Verificamos si el nombre tiene más de dos palabras para dividirlo en dos líneas
                if (palabras.length > 2) {
                    // Unimos la primera mitad de las palabras en la primera línea y la segunda mitad en la segunda línea
                    int mitad = palabras.length / 2;
                    String primeraParte = String.join(" ", Arrays.copyOfRange(palabras, 0, mitad));
                    String segundaParte = String.join(" ", Arrays.copyOfRange(palabras, mitad, palabras.length));

                    // Combinamos ambas partes con un salto de línea HTML
                    nombreDividido = primeraParte + "<br>" + segundaParte;
                } else {
                    // Si tiene dos o menos palabras, no se divide
                    nombreDividido = nombrePrograma;
                }

                ob[4] = "<html>" + nombreDividido + "</html>"; // Nombre del programa en 2 líneas
                ob[5] = estudianteBN.getIdPeriodoAcademicoBN();
                ob[6] = estudianteBN.getPerioLectiBN();

                modelo.addRow(ob);
            }

            tblEstudiantesBN.setModel(modelo);
            tblEstudiantesBN.setRowHeight(70);

            if (CargarEsBN.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún estudiante con el DNI especificado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI válido.");
        }
    }

//    public void buscarEstDesempPorDni () {
//        String IdMatricula = txtIdMatriculaBNs.getText().trim();
//
//        if (!IdMatricula.isEmpty()) {
//            List<BoletaNotasControlador> CargaDesempenoBN = estudiantesBNs.CargarDesemBN(IdMatricula);
//            modelo = (DefaultTableModel) tblEstudianteDesemBN.getModel();
//            modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
//            Object[] ob = new Object[7];
//
//            for (BoletaNotasControlador estudianteBN : CargaDesempenoBN) {
//                ob[0] = estudianteBN.getIdAlumnoBN();
//                ob[1] = estudianteBN.getTotalCreditosDesemBN();
//                ob[2] = estudianteBN.getCreditosAprobadosDesemBN();
//                ob[3] = estudianteBN.getCreditosDesaprobadosDesemBN();
//                ob[4] = estudianteBN.getPromedioGeneralDesemBN();
//                ob[5] = estudianteBN.getPuntajeTotalDesemBN();
//                ob[6] = estudianteBN.getOrdenMeritoDesemBN();
//
//                modelo.addRow(ob);
//            }
//
//            tblEstudianteDesemBN.setModel(modelo);
//            //tblEstudianteDesemBN.setRowHeight(50);
//
//            if (CargaDesempenoBN.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "No se encontró ningún estudiante con el DNI especificado.");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI válido pra orden de merito.");
//        }
//    }
//        public void CargarDesemEstBN(String IdMatricula) {
//        List<BoletaNotasControlador> CargarDesmEst = estudiantesBNs.CargarDesemBN(IdMatricula);
//        modelo = (DefaultTableModel) tblEstudianteDesemBN.getModel();
//        Object[] ob = new Object[8];
//        for (int i = 0; i < CargarDesmEst.size(); i++) {
//            ob[0] = CargarDesmEst.get(i).getIdAlumnoBN();
//            ob[1] = CargarDesmEst.get(i).getTotalCreditosDesemBN();
//            ob[2] = CargarDesmEst.get(i).getCreditosAprobadosDesemBN();
//            ob[3] = CargarDesmEst.get(i).getCreditosDesaprobadosDesemBN();
//            ob[4] = CargarDesmEst.get(i).getPromedioGeneralDesemBN();
//            ob[5] = CargarDesmEst.get(i).getPuntajeTotalDesemBN();
//            ob[6] = CargarDesmEst.get(i).getOrdenMeritoDesemBN();
//            modelo.addRow(ob);
//        }
//        tblEstudianteDesemBN.setModel(modelo);
//    }
    public void CargarNotasBN(String idMatricula) {
        List<BoletaNotasControlador> CargarNotaBn = estudiantesBNs.CargarNotasBN(idMatricula);
        modelo = (DefaultTableModel) tblNotasBN.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < CargarNotaBn.size(); i++) {
            ob[0] = CargarNotaBn.get(i).getCorrelativo();
            ob[1] = CargarNotaBn.get(i).getNombreUDBN();
            ob[2] = CargarNotaBn.get(i).getCreditoUDBN();
            ob[3] = CargarNotaBn.get(i).getNotasUDBN();

            modelo.addRow(ob);
        }
        tblNotasBN.setModel(modelo);
    }

//FUNCIONA
    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    public void LimpiarTablaEspecifica(JTable tabla) {
    // Obtiene el modelo de la tabla
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    // Limpia todas las filas del modelo
    modelo.setRowCount(0);
}

    //FUNCIONA
    private void LimpiarUsuarios() {
        txtId.setText("");
        txtDni.setText("");
        txtApPaterno.setText("");
        txtApMaterno.setText("");
        txtNombres.setText("");
        txtEmail.setText("");
        txtCelular.setText("");
        txtContrasenea.setText("");
        // Para deseleccionar todos los JRadioButton en el ButtonGroup
        btnGr.clearSelection();          // Deselecciona cualquier botón en el grupo
    }

    //FUNCIONA
    private void LimpiarAlumno() {
        txtIdAlumno.setText("");
        txtDniAlumno.setText("");
        txtApPaternoAlumno.setText("");
        txtApMaternoAlumno.setText("");
        txtNombresAlumno.setText("");
        txtEmailAlumno.setText("");
        txtCelularAlumno.setText("");
        txtAneoIngresoAlumno.setText("");

        // Para deseleccionar todos los JRadioButton en el ButtonGroup
        btnGrAlumno.clearSelection();          // Deselecciona cualquier botón en el grupo
    }

    private void LimpiarModulo() {
        txtIdModulo.setText("");
        txtNombreModulo.setText("");
        txtIdProgramaEstudio.setText("");
    }

    private void LimpiarUnidadDidactica() {
        txtIdUnidadDidactica.setText("");
        jTextArea1.setText("");
        txtHorasUnidaDidactica.setText("");
        txtCreditosUnidadDidactica.setText("");
        txtPEUnidadDidactica.setText("");
        txtModUnidadDidactica.setText("");
    }

    //FUNCIONA
    private void LimpiarProgramaEstudio() {
        txtIdProgramaEstudio.setText("");
        txtNombreProgramaEstudio.setText("");
        txtModuloProgramaEstudio.setText("");
    }

    private void LimpiarPeriodoLectivo() {
        txtIdPeriodoLectivo.setText("");
        txtAneoPeriodoLectivo.setText("");
        txtNumeroPeriodoLectivo.setText("");
    }

    private void LimpiarMatricula() {
        txtIdMatricula.setText("");
        txtIdAlumnoMatricula.setText("");
        txtNumeroPeriodoLectivo.setText("");
        txtApPaternoMatricula.setText(""); //
        txtApMaternoMatricula.setText("");
        txtNombresMatricula.setText("");
        txtIdPEMatricula.setText("");
        txtIdProgramaEstudiosMatricula.setText("");
        txtPeriodoLectivoMatricula.setText("");
        txtIdAulaMatricula.setText("");
    }

    private void LimpiarNotas() {
        txtIdNotas.setText("");
        txtIdMatriculaNotas.setText("");
        txtIdUnidaDidacticaNotas.setText("");
        txtNombreUnidadDidacticaNotas.setText("");
        txtNotas.setText("");
        txtFehcaRegistroNotas.setText("");

    }

    private void LimpiarBoletaNotas() {
        txtIdMatriculaBN.setText("");
        txtIdMatriculaBNs.setText("");
        txtDniBN.setText("");
        txtNombreEstudianteBN.setText("");
        txtAProgramaEstudiosBN.setText("");
        txtPeriodoAcadeBN.setText("");
        txtPeriodoLectBN.setText("");
        txtTotalCreditosPeriodoBN.setText("");
        txtCreditosAprobadosBN.setText("");
        txtPromedioGeneralBN2.setText("");
        txtPuntajeTotalObtBN1.setText("");
        txtCreditosDesaprobadosBN5.setText("");
        txtOrdenMeritoBN3.setText("");

    }

    private void LimpiarEstudiantesBN() {
        txtIdMatriculaBN.setText("");
        txtIdMatriculaBNs.setText("");
    }

    public JButton getBtnBoletaNotas() {
        return BtnBoletaNotas;
    }

    public JButton getBtnEstudiante() {
        return BtnEstudiante;
    }

    public JButton getBtnMatricula() {
        return BtnMatricula;
    }

    public JButton getBtnModulo() {
        return BtnModulo;
    }

    public JButton getBtnNotas() {
        return BtnNotas;
    }

    public JButton getBtnPeriodoLectivo() {
        return BtnPeriodoLectivo;
    }

    public JButton getBtnProgramaEstudio() {
        return BtnProgramaEstudio;
    }

    public JButton getBtnReporte() {
        return BtnReporte;
    }

    public JButton getBtnUnidadDidactica() {
        return BtnUnidadDidactica;
    }

    public JButton getBtnUsuario() {
        return BtnUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnBoletaNotas = new javax.swing.JButton();
        BtnEstudiante = new javax.swing.JButton();
        BtnProgramaEstudio = new javax.swing.JButton();
        BtnModulo = new javax.swing.JButton();
        BtnUnidadDidactica = new javax.swing.JButton();
        BtnNotas = new javax.swing.JButton();
        BtnMatricula = new javax.swing.JButton();
        BtnPeriodoLectivo = new javax.swing.JButton();
        BtnReporte = new javax.swing.JButton();
        BtnUsuario = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        JpBoletaNotas = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        txtDniBN = new javax.swing.JTextField();
        btnBuscarBN = new javax.swing.JButton();
        btnVerNotasBN = new javax.swing.JButton();
        btnBuscarBN2 = new javax.swing.JButton();
        txtIdMatriculaBN = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblEstudiantesBN = new javax.swing.JTable();
        txtIdMatriculaBNs = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblNotasBN = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        txtNombreEstudianteBN = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtAProgramaEstudiosBN = new javax.swing.JTextArea();
        jLabel71 = new javax.swing.JLabel();
        txtPeriodoAcadeBN = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txtPeriodoLectBN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalCreditosPeriodoBN = new javax.swing.JTextField();
        txtPuntajeTotalObtBN1 = new javax.swing.JTextField();
        txtPromedioGeneralBN2 = new javax.swing.JTextField();
        txtOrdenMeritoBN3 = new javax.swing.JTextField();
        txtCreditosAprobadosBN = new javax.swing.JTextField();
        txtCreditosDesaprobadosBN5 = new javax.swing.JTextField();
        JpEstudiantes = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtDniAlumno = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNombresAlumno = new javax.swing.JTextField();
        txtEmailAlumno = new javax.swing.JTextField();
        txtCelularAlumno = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtAneoIngresoAlumno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFemenino = new javax.swing.JRadioButton();
        btnGuardarAlumno = new javax.swing.JButton();
        btnModificarAlumno = new javax.swing.JButton();
        btnLimpiarAlumno = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtApPaternoAlumno = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtApMaternoAlumno = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtIdAlumno = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEstudiante = new javax.swing.JTable();
        JpProgramaEstudios = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtNombreProgramaEstudio = new javax.swing.JTextField();
        btnGuardarProgramaEstudio = new javax.swing.JButton();
        btnModificarProgramaEstudio = new javax.swing.JButton();
        btnLimpiarProgramaEstudio = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        txtModuloProgramaEstudio = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtIdProgramaEstudio = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProgramaEstudios = new javax.swing.JTable();
        JpUnidadesDidacticas = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtPEUnidadDidactica = new javax.swing.JTextField();
        btnGuardarUd = new javax.swing.JButton();
        btnModificarUd = new javax.swing.JButton();
        btnLimpiarUd = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        txtHorasUnidaDidactica = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtCreditosUnidadDidactica = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtIdUnidadDidactica = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtModUnidadDidactica = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblUnidadesDidacticas = new javax.swing.JTable();
        JpNotas = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtFehcaRegistroNotas = new javax.swing.JTextField();
        btnGuardarNotas = new javax.swing.JButton();
        btnModificarNotas = new javax.swing.JButton();
        btnLimpiarNotas = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        txtIdUnidaDidacticaNotas = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtNotas = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtIdNotas = new javax.swing.JTextField();
        txtIdMatriculaNotas = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtNombreUnidadDidacticaNotas = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        JpMatricula = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtIdAlumnoMatricula = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtNombresMatricula = new javax.swing.JTextField();
        txtPeriodoLectivoMatricula = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtIdAulaMatricula = new javax.swing.JTextField();
        btnGuardarMatricula = new javax.swing.JButton();
        btnModificarMatricula = new javax.swing.JButton();
        btnLimpiarMatricula = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        txtApPaternoMatricula = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtApMaternoMatricula = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtIdMatricula = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtIdProgramaEstudiosMatricula = new javax.swing.JTextArea();
        jLabel48 = new javax.swing.JLabel();
        txtIdPEMatricula = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblMatricula = new javax.swing.JTable();
        JpPeriodoLectivo = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtAneoPeriodoLectivo = new javax.swing.JTextField();
        btnGuardarPeriodoLectivo = new javax.swing.JButton();
        btnModificarPeriodoLectivo = new javax.swing.JButton();
        btnLimpiarPeriodoLectivo = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        txtNumeroPeriodoLectivo = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtIdPeriodoLectivo = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblPeriodoLectivo = new javax.swing.JTable();
        JpReporte = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JpUsuarios = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtContrasenea = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rbAdm = new javax.swing.JRadioButton();
        rbAsist = new javax.swing.JRadioButton();
        txtId = new javax.swing.JTextField();
        btnGuardarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnLimpiarUsuario = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtApPaterno = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtApMaterno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        JpModulos = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnGuardarModulo = new javax.swing.JButton();
        btnModificarModulo = new javax.swing.JButton();
        btnLimpiarModulo = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtProgramaEstudio = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtIdModulo = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtNombreModulo = new javax.swing.JTextArea();
        jLabel73 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblModulo = new javax.swing.JTable();
        JpPeriodoAcademico = new javax.swing.JPanel();
        PERIODO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(15, 116, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBoletaNotas.setBackground(new java.awt.Color(204, 204, 204));
        BtnBoletaNotas.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnBoletaNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/notes_icon-icons.com_66633 (1).png"))); // NOI18N
        BtnBoletaNotas.setText("<html>Boleta de<p>Notas</html>");
        BtnBoletaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBoletaNotasActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBoletaNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 45));

        BtnEstudiante.setBackground(new java.awt.Color(204, 204, 204));
        BtnEstudiante.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/school_students_icon_144607 (1).png"))); // NOI18N
        BtnEstudiante.setText("Estudiantes");
        BtnEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEstudianteMouseClicked(evt);
            }
        });
        BtnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, 45));

        BtnProgramaEstudio.setBackground(new java.awt.Color(204, 204, 204));
        BtnProgramaEstudio.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnProgramaEstudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/default_program_folder_icon_250639 (1).png"))); // NOI18N
        BtnProgramaEstudio.setText("<html>Programas <p>de Estudios</html>");
        BtnProgramaEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProgramaEstudioActionPerformed(evt);
            }
        });
        jPanel1.add(BtnProgramaEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, 45));

        BtnModulo.setBackground(new java.awt.Color(204, 204, 204));
        BtnModulo.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/interactive_modules_learning_education_online_icon_262294.png"))); // NOI18N
        BtnModulo.setText("   Módulos");
        BtnModulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnModuloMouseClicked(evt);
            }
        });
        BtnModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModuloActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 160, 45));

        BtnUnidadDidactica.setBackground(new java.awt.Color(204, 204, 204));
        BtnUnidadDidactica.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnUnidadDidactica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/online_education_content_materials_course_icon_262306.png"))); // NOI18N
        BtnUnidadDidactica.setText("<html>Unidades <p>Didácticas</html>");
        BtnUnidadDidactica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUnidadDidacticaActionPerformed(evt);
            }
        });
        jPanel1.add(BtnUnidadDidactica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 160, 45));

        BtnNotas.setBackground(new java.awt.Color(204, 204, 204));
        BtnNotas.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        BtnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/list_notes_930.png"))); // NOI18N
        BtnNotas.setText("Notas");
        BtnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNotasActionPerformed(evt);
            }
        });
        jPanel1.add(BtnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 160, 45));

        BtnMatricula.setBackground(new java.awt.Color(204, 204, 204));
        BtnMatricula.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registereduser_4958.png"))); // NOI18N
        BtnMatricula.setText("Matricula");
        BtnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(BtnMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, 45));

        BtnPeriodoLectivo.setBackground(new java.awt.Color(204, 204, 204));
        BtnPeriodoLectivo.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnPeriodoLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/isolation_quarentine_stay_at_home_icon_140107.png"))); // NOI18N
        BtnPeriodoLectivo.setText("<html>Periodo <p> Lectivo</html>");
        BtnPeriodoLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPeriodoLectivoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPeriodoLectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 160, 45));

        BtnReporte.setBackground(new java.awt.Color(204, 204, 204));
        BtnReporte.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medical_icon_4_icon-icons.com_66661.png"))); // NOI18N
        BtnReporte.setText("Reportes");
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(BtnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 160, 45));

        BtnUsuario.setBackground(new java.awt.Color(204, 204, 204));
        BtnUsuario.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        BtnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario_25560.png"))); // NOI18N
        BtnUsuario.setText("Usuarios");
        BtnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(BtnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 160, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 780));

        jPanel19.setBackground(new java.awt.Color(15, 116, 235));

        jLabel75.setBackground(new java.awt.Color(0, 102, 255));
        jLabel75.setFont(new java.awt.Font("Perpetua Titling MT", 3, 48)); // NOI18N
        jLabel75.setText("SISTEMA ACADEMICO INTEGRAL ");
        jLabel75.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 153));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel20.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setText("Dni:");

        txtDniBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnBuscarBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscarBN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupax32.png"))); // NOI18N
        btnBuscarBN.setText("Buscar");
        btnBuscarBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBNActionPerformed(evt);
            }
        });

        btnVerNotasBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVerNotasBN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnVerNotasBN.setText("Limpiar");
        btnVerNotasBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerNotasBNMouseClicked(evt);
            }
        });
        btnVerNotasBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerNotasBNActionPerformed(evt);
            }
        });

        btnBuscarBN2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscarBN2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresorax32.png"))); // NOI18N
        btnBuscarBN2.setText("Imprimir");
        btnBuscarBN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBN2ActionPerformed(evt);
            }
        });

        txtIdMatriculaBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblEstudiantesBN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Alumno", "Dni", "Id Matricula", "Nombre Completo", "Programa de Estudios", "Per. Acad", "Per. Lect."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstudiantesBN.setToolTipText("");
        tblEstudiantesBN.setColumnSelectionAllowed(true);
        tblEstudiantesBN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblEstudiantesBN.setFillsViewportHeight(true);
        tblEstudiantesBN.setRowHeight(30);
        tblEstudiantesBN.setShowGrid(true);
        tblEstudiantesBN.getTableHeader().setReorderingAllowed(false);
        tblEstudiantesBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstudiantesBNMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblEstudiantesBN);
        tblEstudiantesBN.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblEstudiantesBN.getColumnModel().getColumnCount() > 0) {
            tblEstudiantesBN.getColumnModel().getColumn(0).setResizable(false);
            tblEstudiantesBN.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblEstudiantesBN.getColumnModel().getColumn(1).setResizable(false);
            tblEstudiantesBN.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblEstudiantesBN.getColumnModel().getColumn(2).setResizable(false);
            tblEstudiantesBN.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblEstudiantesBN.getColumnModel().getColumn(3).setMinWidth(110);
            tblEstudiantesBN.getColumnModel().getColumn(3).setPreferredWidth(110);
            tblEstudiantesBN.getColumnModel().getColumn(3).setMaxWidth(110);
            tblEstudiantesBN.getColumnModel().getColumn(4).setMinWidth(150);
            tblEstudiantesBN.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblEstudiantesBN.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel68)
                .addGap(18, 18, 18)
                .addComponent(txtDniBN, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnBuscarBN)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnBuscarBN2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerNotasBN)
                .addGap(109, 109, 109))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdMatriculaBNs, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdMatriculaBN, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jScrollPane16)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdMatriculaBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMatriculaBNs, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDniBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(btnBuscarBN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarBN2)
                    .addComponent(btnVerNotasBN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblNotasBN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblNotasBN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Unidad Didáctica", "Creditos", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNotasBN.setColumnSelectionAllowed(true);
        tblNotasBN.setRowHeight(30);
        tblNotasBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNotasBNMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblNotasBN);
        tblNotasBN.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblNotasBN.getColumnModel().getColumnCount() > 0) {
            tblNotasBN.getColumnModel().getColumn(0).setMinWidth(30);
            tblNotasBN.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblNotasBN.getColumnModel().getColumn(0).setMaxWidth(30);
            tblNotasBN.getColumnModel().getColumn(2).setResizable(false);
            tblNotasBN.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblNotasBN.getColumnModel().getColumn(3).setMinWidth(60);
            tblNotasBN.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblNotasBN.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel69.setText("Estudiante:");

        txtNombreEstudianteBN.setEditable(false);
        txtNombreEstudianteBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel70.setText("Programa de Estudios:");

        txtAProgramaEstudiosBN.setEditable(false);
        txtAProgramaEstudiosBN.setColumns(20);
        txtAProgramaEstudiosBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAProgramaEstudiosBN.setLineWrap(true);
        txtAProgramaEstudiosBN.setRows(1);
        txtAProgramaEstudiosBN.setTabSize(2);
        txtAProgramaEstudiosBN.setAutoscrolls(false);
        jScrollPane13.setViewportView(txtAProgramaEstudiosBN);

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel71.setText("Periodo Academico: ");

        txtPeriodoAcadeBN.setEditable(false);
        txtPeriodoAcadeBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel72.setText("Periodo Lectivo: ");

        txtPeriodoLectBN.setEditable(false);
        txtPeriodoLectBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("<html>Total Créditos del <p>Periodo Académico</html>");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Créditos Aprobados:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Promedio General:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Créditos Desaprobados:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("<html>Puntaje Total <p>Obtenido:</html>");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Orden Merito:");

        txtTotalCreditosPeriodoBN.setEditable(false);
        txtTotalCreditosPeriodoBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPuntajeTotalObtBN1.setEditable(false);
        txtPuntajeTotalObtBN1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPuntajeTotalObtBN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuntajeTotalObtBN1ActionPerformed(evt);
            }
        });

        txtPromedioGeneralBN2.setEditable(false);
        txtPromedioGeneralBN2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtOrdenMeritoBN3.setEditable(false);
        txtOrdenMeritoBN3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtCreditosAprobadosBN.setEditable(false);
        txtCreditosAprobadosBN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtCreditosDesaprobadosBN5.setEditable(false);
        txtCreditosDesaprobadosBN5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalCreditosPeriodoBN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPromedioGeneralBN2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCreditosAprobadosBN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCreditosDesaprobadosBN5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrdenMeritoBN3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuntajeTotalObtBN1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeriodoAcadeBN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeriodoLectBN))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel70)
                            .addComponent(jLabel69))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreEstudianteBN)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane14)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreEstudianteBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel70)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeriodoAcadeBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeriodoLectBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalCreditosPeriodoBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuntajeTotalObtBN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCreditosDesaprobadosBN5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCreditosAprobadosBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrdenMeritoBN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPromedioGeneralBN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout JpBoletaNotasLayout = new javax.swing.GroupLayout(JpBoletaNotas);
        JpBoletaNotas.setLayout(JpBoletaNotasLayout);
        JpBoletaNotasLayout.setHorizontalGroup(
            JpBoletaNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBoletaNotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpBoletaNotasLayout.setVerticalGroup(
            JpBoletaNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBoletaNotasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpBoletaNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab1", JpBoletaNotas);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Dni:");

        txtDniAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Nombres:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Email:");

        txtNombresAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombresAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresAlumnoActionPerformed(evt);
            }
        });

        txtEmailAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtCelularAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Celular:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Año Ingreso:");

        txtAneoIngresoAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Sexo:");

        rbMasculino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMasculino.setText("Masculino");
        rbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMasculinoActionPerformed(evt);
            }
        });

        rbFemenino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbFemenino.setText("Femenino");
        rbFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemeninoActionPerformed(evt);
            }
        });

        btnGuardarAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarAlumnoMouseClicked(evt);
            }
        });
        btnGuardarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlumnoActionPerformed(evt);
            }
        });

        btnModificarAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAlumnoActionPerformed(evt);
            }
        });

        btnLimpiarAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAlumnoActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Apellido Paterno:");

        txtApPaternoAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Apellido Materno:");

        txtApMaternoAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Id Alumno:");

        txtIdAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnGuardarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnModificarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(186, 186, 186))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnLimpiarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(rbMasculino)
                                                .addGap(36, 36, 36)
                                                .addComponent(rbFemenino)
                                                .addGap(10, 10, 10))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel15))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombresAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCelularAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAneoIngresoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmailAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApMaternoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApPaternoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel25)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtApPaternoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtApMaternoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombresAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtEmailAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCelularAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAneoIngresoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbMasculino)
                    .addComponent(rbFemenino))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarAlumno)
                    .addComponent(btnGuardarAlumno)
                    .addComponent(btnLimpiarAlumno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dni", "Apellido Paterno", "Apellido Materno", "Nombres", "Email", "Celular", "Sexo", "Año de Ingreso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstudiante.setColumnSelectionAllowed(true);
        tblEstudiante.setRowHeight(30);
        tblEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstudianteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEstudiante);
        tblEstudiante.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblEstudiante.getColumnModel().getColumnCount() > 0) {
            tblEstudiante.getColumnModel().getColumn(0).setResizable(false);
            tblEstudiante.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblEstudiante.getColumnModel().getColumn(1).setResizable(false);
            tblEstudiante.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblEstudiante.getColumnModel().getColumn(7).setResizable(false);
            tblEstudiante.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        javax.swing.GroupLayout JpEstudiantesLayout = new javax.swing.GroupLayout(JpEstudiantes);
        JpEstudiantes.setLayout(JpEstudiantesLayout);
        JpEstudiantesLayout.setHorizontalGroup(
            JpEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpEstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        JpEstudiantesLayout.setVerticalGroup(
            JpEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpEstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpEstudiantesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", JpEstudiantes);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Nombre Programa de Estudios");

        txtNombreProgramaEstudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnGuardarProgramaEstudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarProgramaEstudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarProgramaEstudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarProgramaEstudioMouseClicked(evt);
            }
        });
        btnGuardarProgramaEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProgramaEstudioActionPerformed(evt);
            }
        });

        btnModificarProgramaEstudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarProgramaEstudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarProgramaEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProgramaEstudioActionPerformed(evt);
            }
        });

        btnLimpiarProgramaEstudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarProgramaEstudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarProgramaEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProgramaEstudioActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Cantidad de Módulos");

        txtModuloProgramaEstudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("Id Programa de Estudios");

        txtIdProgramaEstudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombreProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModuloProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnGuardarProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificarProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(btnLimpiarProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(101, 101, 101))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel35)
                .addGap(35, 35, 35)
                .addComponent(txtIdProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel27)
                .addGap(33, 33, 33)
                .addComponent(txtNombreProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel33)
                .addGap(31, 31, 31)
                .addComponent(txtModuloProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificarProgramaEstudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarProgramaEstudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiarProgramaEstudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        tblProgramaEstudios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Siglas", "Nombre Programa de Estudios", "Cantidad de Módulos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProgramaEstudios.setRowHeight(30);
        tblProgramaEstudios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProgramaEstudiosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProgramaEstudios);
        tblProgramaEstudios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblProgramaEstudios.getColumnModel().getColumnCount() > 0) {
            tblProgramaEstudios.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 71, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        javax.swing.GroupLayout JpProgramaEstudiosLayout = new javax.swing.GroupLayout(JpProgramaEstudios);
        JpProgramaEstudios.setLayout(JpProgramaEstudiosLayout);
        JpProgramaEstudiosLayout.setHorizontalGroup(
            JpProgramaEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpProgramaEstudiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        JpProgramaEstudiosLayout.setVerticalGroup(
            JpProgramaEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpProgramaEstudiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpProgramaEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpProgramaEstudiosLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab3", JpProgramaEstudios);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Nombre Unidad Didáctica");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Programa de Estudios ");

        txtPEUnidadDidactica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPEUnidadDidactica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPEUnidadDidacticaActionPerformed(evt);
            }
        });

        btnGuardarUd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarUd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarUd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarUdMouseClicked(evt);
            }
        });
        btnGuardarUd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUdActionPerformed(evt);
            }
        });

        btnModificarUd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarUd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarUd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUdActionPerformed(evt);
            }
        });

        btnLimpiarUd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarUd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarUd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarUdActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setText("Horas Unidad Didáctica");

        txtHorasUnidaDidactica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setText("Crédito Unidad Didáctica");

        txtCreditosUnidadDidactica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setText("Id Unidad Didáctica");

        txtIdUnidadDidactica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Módulo");

        txtModUnidadDidactica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtModUnidadDidactica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModUnidadDidacticaActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(null);
        jScrollPane7.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(190, 190, 190))))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnGuardarUd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel41))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel29))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHorasUnidaDidactica, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGap(112, 112, 112)
                                    .addComponent(btnModificarUd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(61, 61, 61)
                                    .addComponent(btnLimpiarUd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtIdUnidadDidactica)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))))
                .addGap(0, 83, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCreditosUnidadDidactica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(txtModUnidadDidactica)
                    .addComponent(txtPEUnidadDidactica))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel41)
                .addGap(16, 16, 16)
                .addComponent(txtIdUnidadDidactica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHorasUnidaDidactica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addGap(16, 16, 16)
                .addComponent(txtCreditosUnidadDidactica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(txtPEUnidadDidactica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(15, 15, 15)
                .addComponent(txtModUnidadDidactica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiarUd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarUd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarUd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        tblUnidadesDidacticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id UD", "Nombre", "Horas", "Créditos", "Programa Estudios", "Módulo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUnidadesDidacticas.setColumnSelectionAllowed(true);
        tblUnidadesDidacticas.setRowHeight(30);
        tblUnidadesDidacticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUnidadesDidacticasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblUnidadesDidacticas);
        tblUnidadesDidacticas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblUnidadesDidacticas.getColumnModel().getColumnCount() > 0) {
            tblUnidadesDidacticas.getColumnModel().getColumn(2).setResizable(false);
            tblUnidadesDidacticas.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblUnidadesDidacticas.getColumnModel().getColumn(4).setResizable(false);
            tblUnidadesDidacticas.getColumnModel().getColumn(4).setPreferredWidth(90);
            tblUnidadesDidacticas.getColumnModel().getColumn(5).setResizable(false);
            tblUnidadesDidacticas.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        javax.swing.GroupLayout JpUnidadesDidacticasLayout = new javax.swing.GroupLayout(JpUnidadesDidacticas);
        JpUnidadesDidacticas.setLayout(JpUnidadesDidacticasLayout);
        JpUnidadesDidacticasLayout.setHorizontalGroup(
            JpUnidadesDidacticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUnidadesDidacticasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        JpUnidadesDidacticasLayout.setVerticalGroup(
            JpUnidadesDidacticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpUnidadesDidacticasLayout.createSequentialGroup()
                .addGroup(JpUnidadesDidacticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpUnidadesDidacticasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpUnidadesDidacticasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpUnidadesDidacticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                            .addComponent(jScrollPane6))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab5", JpUnidadesDidacticas);

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel16.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setText("Id Matricula");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel53.setText("Fecha de Registro");

        txtFehcaRegistroNotas.setEditable(false);
        txtFehcaRegistroNotas.setBackground(new java.awt.Color(204, 204, 204));
        txtFehcaRegistroNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFehcaRegistroNotas.setFocusable(false);
        txtFehcaRegistroNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFehcaRegistroNotasActionPerformed(evt);
            }
        });

        btnGuardarNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarNotasMouseClicked(evt);
            }
        });
        btnGuardarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNotasActionPerformed(evt);
            }
        });

        btnModificarNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarNotasActionPerformed(evt);
            }
        });

        btnLimpiarNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarNotasActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setText("Id Unidad Didáctica");

        txtIdUnidaDidacticaNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setText("Nota");

        txtNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel57.setText("Id Notas");

        txtIdNotas.setEditable(false);
        txtIdNotas.setBackground(new java.awt.Color(204, 204, 204));
        txtIdNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIdNotas.setFocusable(false);

        txtIdMatriculaNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIdMatriculaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMatriculaNotasActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setText("Unidad Didáctica");

        txtNombreUnidadDidacticaNotas.setEditable(false);
        txtNombreUnidadDidacticaNotas.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreUnidadDidacticaNotas.setColumns(20);
        txtNombreUnidadDidacticaNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombreUnidadDidacticaNotas.setLineWrap(true);
        txtNombreUnidadDidacticaNotas.setRows(1);
        txtNombreUnidadDidacticaNotas.setTabSize(2);
        txtNombreUnidadDidacticaNotas.setFocusable(false);
        jScrollPane11.setViewportView(txtNombreUnidadDidacticaNotas);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtIdMatriculaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNotas, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addComponent(txtIdUnidaDidacticaNotas, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addComponent(btnGuardarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)
                            .addComponent(btnLimpiarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtFehcaRegistroNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel57))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel58)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(205, 205, 205))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(179, 179, 179))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(txtIdMatriculaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel55)
                .addGap(18, 18, 18)
                .addComponent(txtIdUnidaDidacticaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(txtFehcaRegistroNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarNotas)
                    .addComponent(btnLimpiarNotas)
                    .addComponent(btnGuardarNotas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Notas", "Id Matricula", "Id Unidad Didáctica", "Unidad Didáctica", "Nota", "Fecha de Registro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNotas.setColumnSelectionAllowed(true);
        tblNotas.setRowHeight(30);
        tblNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNotasMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblNotas);
        tblNotas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout JpNotasLayout = new javax.swing.GroupLayout(JpNotas);
        JpNotas.setLayout(JpNotasLayout);
        JpNotasLayout.setHorizontalGroup(
            JpNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpNotasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        JpNotasLayout.setVerticalGroup(
            JpNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpNotasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(JpNotasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab7", JpNotas);

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel14.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setText("Id Alumno:");

        txtIdAlumnoMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("Nombres:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("<html>Programa <p>Estudios:</html>");

        txtNombresMatricula.setEditable(false);
        txtNombresMatricula.setBackground(new java.awt.Color(204, 204, 204));
        txtNombresMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombresMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresMatriculaActionPerformed(evt);
            }
        });

        txtPeriodoLectivoMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setText("<html>Perdiodo <p>Lectivo:</html>");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("Aula:");

        txtIdAulaMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnGuardarMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMatriculaMouseClicked(evt);
            }
        });
        btnGuardarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMatriculaActionPerformed(evt);
            }
        });

        btnModificarMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMatriculaActionPerformed(evt);
            }
        });

        btnLimpiarMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMatriculaActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setText("Apellido Paterno:");

        txtApPaternoMatricula.setEditable(false);
        txtApPaternoMatricula.setBackground(new java.awt.Color(204, 204, 204));
        txtApPaternoMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel50.setText("Apellido Materno:");

        txtApMaternoMatricula.setEditable(false);
        txtApMaternoMatricula.setBackground(new java.awt.Color(204, 204, 204));
        txtApMaternoMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel51.setText("Id Matricula:");

        txtIdMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtIdProgramaEstudiosMatricula.setEditable(false);
        txtIdProgramaEstudiosMatricula.setBackground(new java.awt.Color(204, 204, 204));
        txtIdProgramaEstudiosMatricula.setColumns(20);
        txtIdProgramaEstudiosMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIdProgramaEstudiosMatricula.setLineWrap(true);
        txtIdProgramaEstudiosMatricula.setRows(1);
        txtIdProgramaEstudiosMatricula.setTabSize(3);
        txtIdProgramaEstudiosMatricula.setAutoscrolls(false);
        jScrollPane10.setViewportView(txtIdProgramaEstudiosMatricula);

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setText("<html>Id Programa <p> Estudios:");

        txtIdPEMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel48))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombresMatricula)
                                            .addComponent(txtApMaternoMatricula)))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdPEMatricula))))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel51))
                                        .addGap(30, 30, 30))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(26, 26, 26)))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdAlumnoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApPaternoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdMatricula)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(23, 23, 23)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel46)
                                            .addComponent(jLabel47))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPeriodoLectivoMatricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIdAulaMatricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnGuardarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(btnLimpiarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(183, 183, 183))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtIdMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdAlumnoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtApPaternoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(txtApMaternoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombresMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPEMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPeriodoLectivoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdAulaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiarMatricula)
                    .addComponent(btnGuardarMatricula)
                    .addComponent(btnModificarMatricula))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 844, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        tblMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Matricula", "Id Alumno", "Ape Paterno", "Ape Materno", "Nombres", "Id Programa Estudio", "Programa Estudio", "Perdiodo Lectivo", "Aula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMatricula.setColumnSelectionAllowed(true);
        tblMatricula.setRowHeight(30);
        tblMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMatriculaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblMatricula);
        tblMatricula.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblMatricula.getColumnModel().getColumnCount() > 0) {
            tblMatricula.getColumnModel().getColumn(0).setResizable(false);
            tblMatricula.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblMatricula.getColumnModel().getColumn(1).setResizable(false);
            tblMatricula.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblMatricula.getColumnModel().getColumn(2).setResizable(false);
            tblMatricula.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblMatricula.getColumnModel().getColumn(3).setResizable(false);
            tblMatricula.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblMatricula.getColumnModel().getColumn(4).setResizable(false);
            tblMatricula.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblMatricula.getColumnModel().getColumn(8).setResizable(false);
            tblMatricula.getColumnModel().getColumn(8).setPreferredWidth(15);
        }

        javax.swing.GroupLayout JpMatriculaLayout = new javax.swing.GroupLayout(JpMatricula);
        JpMatricula.setLayout(JpMatriculaLayout);
        JpMatriculaLayout.setHorizontalGroup(
            JpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        JpMatriculaLayout.setVerticalGroup(
            JpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMatriculaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(JpMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab8", JpMatricula);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel12.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setText("Año");

        txtAneoPeriodoLectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnGuardarPeriodoLectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarPeriodoLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarPeriodoLectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarPeriodoLectivoMouseClicked(evt);
            }
        });
        btnGuardarPeriodoLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPeriodoLectivoActionPerformed(evt);
            }
        });

        btnModificarPeriodoLectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarPeriodoLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarPeriodoLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPeriodoLectivoActionPerformed(evt);
            }
        });

        btnLimpiarPeriodoLectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarPeriodoLectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarPeriodoLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPeriodoLectivoActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Número:");

        txtNumeroPeriodoLectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setText("Id Periodo Lectivo");

        txtIdPeriodoLectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnGuardarPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnModificarPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel38))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel37)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumeroPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdPeriodoLectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(txtAneoPeriodoLectivo))
                            .addComponent(btnLimpiarPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel42)))
                .addGap(0, 100, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel42)
                .addGap(28, 28, 28)
                .addComponent(txtIdPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel37)
                .addGap(26, 26, 26)
                .addComponent(txtAneoPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel38)
                .addGap(26, 26, 26)
                .addComponent(txtNumeroPeriodoLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiarPeriodoLectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarPeriodoLectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarPeriodoLectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblPeriodoLectivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Siglas", "Nombre Programa de Estudios", "Cantidad de Módulos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPeriodoLectivo.setRowHeight(30);
        tblPeriodoLectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeriodoLectivoMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblPeriodoLectivo);
        tblPeriodoLectivo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblPeriodoLectivo.getColumnModel().getColumnCount() > 0) {
            tblPeriodoLectivo.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout JpPeriodoLectivoLayout = new javax.swing.GroupLayout(JpPeriodoLectivo);
        JpPeriodoLectivo.setLayout(JpPeriodoLectivoLayout);
        JpPeriodoLectivoLayout.setHorizontalGroup(
            JpPeriodoLectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpPeriodoLectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        JpPeriodoLectivoLayout.setVerticalGroup(
            JpPeriodoLectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpPeriodoLectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpPeriodoLectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab9", JpPeriodoLectivo);

        jLabel9.setText("REPORTES");

        javax.swing.GroupLayout JpReporteLayout = new javax.swing.GroupLayout(JpReporte);
        JpReporte.setLayout(JpReporteLayout);
        JpReporteLayout.setHorizontalGroup(
            JpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpReporteLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(736, Short.MAX_VALUE))
        );
        JpReporteLayout.setVerticalGroup(
            JpReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpReporteLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab10", JpReporte);

        JpUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        JpUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        JpUsuarios.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Dni:");

        txtDni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Nombres:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Email:");

        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtCelular.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Celular:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Contraseña:");

        txtContrasenea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Tipo de Usuario:");

        rbAdm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbAdm.setText("Administrador");
        rbAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdmActionPerformed(evt);
            }
        });

        rbAsist.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbAsist.setText("Asistente");

        btnGuardarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarUsuario.setText("Guardar");
        btnGuardarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarUsuarioMouseClicked(evt);
            }
        });
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar x32.png"))); // NOI18N
        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnLimpiarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarUsuario.setText("Limpiar");
        btnLimpiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarUsuarioActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Apellido Paterno:");

        txtApPaterno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Apellido Materno:");

        txtApMaterno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(12, 12, 12))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContrasenea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addComponent(txtCelular)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombres)
                            .addComponent(txtApMaterno)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rbAdm)
                        .addGap(70, 70, 70)
                        .addComponent(rbAsist, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiarUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAdm)
                    .addComponent(rbAsist))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarUsuario)
                    .addComponent(btnModificarUsuario)
                    .addComponent(btnEliminarUsuario)
                    .addComponent(btnLimpiarUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dni", "Apellido Paterno", "Apellido Materno", "Nombres", "Email", "Celular", "Nivel Acceso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setColumnSelectionAllowed(true);
        tblUsuarios.setRowHeight(30);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        tblUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setMinWidth(100);
            tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(100);
            tblUsuarios.getColumnModel().getColumn(1).setMinWidth(65);
            tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(65);
            tblUsuarios.getColumnModel().getColumn(1).setMaxWidth(65);
            tblUsuarios.getColumnModel().getColumn(2).setMinWidth(100);
            tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblUsuarios.getColumnModel().getColumn(2).setMaxWidth(100);
            tblUsuarios.getColumnModel().getColumn(3).setMinWidth(130);
            tblUsuarios.getColumnModel().getColumn(3).setPreferredWidth(130);
            tblUsuarios.getColumnModel().getColumn(3).setMaxWidth(130);
            tblUsuarios.getColumnModel().getColumn(4).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        javax.swing.GroupLayout JpUsuariosLayout = new javax.swing.GroupLayout(JpUsuarios);
        JpUsuarios.setLayout(JpUsuariosLayout);
        JpUsuariosLayout.setHorizontalGroup(
            JpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpUsuariosLayout.setVerticalGroup(
            JpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpUsuariosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(JpUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TabUsuario", JpUsuarios);

        JpModulos.setBackground(new java.awt.Color(204, 204, 204));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(644, 600));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Nombre del Módulo ");

        btnGuardarModulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible x32.png"))); // NOI18N
        btnGuardarModulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarModuloMouseClicked(evt);
            }
        });
        btnGuardarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarModuloActionPerformed(evt);
            }
        });

        btnModificarModulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar x32.png"))); // NOI18N
        btnModificarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarModuloActionPerformed(evt);
            }
        });

        btnLimpiarModulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar x32.png"))); // NOI18N
        btnLimpiarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarModuloActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("Programa de Estudios");

        txtProgramaEstudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("Id Módulo");

        txtIdModulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNombreModulo.setColumns(20);
        txtNombreModulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombreModulo.setLineWrap(true);
        txtNombreModulo.setRows(3);
        txtNombreModulo.setAutoscrolls(false);
        txtNombreModulo.setBorder(null);
        jScrollPane5.setViewportView(txtNombreModulo);

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel73.setText("Estudiante:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnGuardarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnModificarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(46, 46, 46)
                .addComponent(jLabel73)
                .addGap(51, 51, 51))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(txtIdModulo)
                    .addComponent(txtProgramaEstudio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel34)
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(145, 145, 145))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel73))
                .addGap(18, 18, 18)
                .addComponent(txtIdModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addComponent(txtProgramaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarModulo)
                    .addComponent(btnModificarModulo)
                    .addComponent(btnLimpiarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        TblModulo.setBackground(new java.awt.Color(204, 204, 204));
        TblModulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Módulo", "Nombre del Módulo", "Programa de Estudios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblModulo.setRowHeight(30);
        TblModulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblModuloMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TblModulo);
        TblModulo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TblModulo.getColumnModel().getColumnCount() > 0) {
            TblModulo.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout JpModulosLayout = new javax.swing.GroupLayout(JpModulos);
        JpModulos.setLayout(JpModulosLayout);
        JpModulosLayout.setHorizontalGroup(
            JpModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpModulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        JpModulosLayout.setVerticalGroup(
            JpModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpModulosLayout.createSequentialGroup()
                .addGroup(JpModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpModulosLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JpModulosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 651, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", JpModulos);

        PERIODO.setText("PERIODO ACADÉMICO");

        javax.swing.GroupLayout JpPeriodoAcademicoLayout = new javax.swing.GroupLayout(JpPeriodoAcademico);
        JpPeriodoAcademico.setLayout(JpPeriodoAcademicoLayout);
        JpPeriodoAcademicoLayout.setHorizontalGroup(
            JpPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpPeriodoAcademicoLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(PERIODO, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(786, Short.MAX_VALUE))
        );
        JpPeriodoAcademicoLayout.setVerticalGroup(
            JpPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpPeriodoAcademicoLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(PERIODO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", JpPeriodoAcademico);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel75)
                .addGap(216, 216, 216))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1280, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuarioActionPerformed
        LimpiarUsuarios();
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(9);
        CargarUsuario();
    }//GEN-LAST:event_BtnUsuarioActionPerformed

    private void BtnModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModuloActionPerformed
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(10);
        CargarModulos();
    }//GEN-LAST:event_BtnModuloActionPerformed

    private void BtnUnidadDidacticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUnidadDidacticaActionPerformed
        LimpiarUnidadDidactica();
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(3);
        CargarUnidadDidactica();
    }//GEN-LAST:event_BtnUnidadDidacticaActionPerformed

    private void BtnPeriodoLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPeriodoLectivoActionPerformed
        LimpiarPeriodoLectivo();
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(7);
        CargarPeriodoLectivo();
    }//GEN-LAST:event_BtnPeriodoLectivoActionPerformed

    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_BtnReporteActionPerformed

    private void BtnEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEstudianteMouseClicked

    }//GEN-LAST:event_BtnEstudianteMouseClicked

    private void BtnProgramaEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProgramaEstudioActionPerformed
        LimpiarProgramaEstudio();
        DefaultTableModel model = (DefaultTableModel) tblProgramaEstudios.getModel();
        model.setRowCount(0);
        //LimpiarTabla();
        jTabbedPane1.setSelectedIndex(2);
        CargarProgramaEstudio();
    }//GEN-LAST:event_BtnProgramaEstudioActionPerformed

    private void BtnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNotasActionPerformed
        LimpiarNotas();
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(5);
        CargarNotas();
    }//GEN-LAST:event_BtnNotasActionPerformed

    private void BtnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMatriculaActionPerformed
        LimpiarMatricula();
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(6);
        CargarMatricula();
    }//GEN-LAST:event_BtnMatriculaActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void rbAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAdmActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        int fila = tblUsuarios.rowAtPoint(evt.getPoint());
        txtId.setText(tblUsuarios.getValueAt(fila, 0).toString());
        txtDni.setText(tblUsuarios.getValueAt(fila, 1).toString());
        txtApPaterno.setText(tblUsuarios.getValueAt(fila, 2).toString());
        txtApMaterno.setText(tblUsuarios.getValueAt(fila, 3).toString());
        txtNombres.setText(tblUsuarios.getValueAt(fila, 4).toString());
        txtEmail.setText(tblUsuarios.getValueAt(fila, 5).toString());
        txtCelular.setText(tblUsuarios.getValueAt(fila, 6).toString());

        // Verificar el rol y seleccionar el JRadioButton correspondiente
        String rol = tblUsuarios.getValueAt(fila, 7).toString(); // Asumiendo que la columna 7 tiene el rol
        if ("Administrador".equals(rol)) {
            rbAdm.setSelected(true);
            rbAsist.setSelected(false); // Asegúrate de deseleccionar el otro RadioButton
        } else if ("Asistente".equals(rol)) {
            rbAsist.setSelected(true);
            rbAdm.setSelected(false); // Asegúrate de deseleccionar el otro RadioButton
        } else {
            // Opcional: Si no es ninguno de los dos, puedes limpiar ambos
            rbAdm.setSelected(false);
            rbAsist.setSelected(false);
        }

    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnGuardarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioMouseClicked
    }//GEN-LAST:event_btnGuardarUsuarioMouseClicked

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtDni.getText().trim())
                && !"".equals(txtApPaterno.getText().trim())
                && !"".equals(txtApMaterno.getText().trim())
                && !"".equals(txtNombres.getText().trim())
                && !"".equals(txtEmail.getText().trim())
                && !"".equals(txtCelular.getText().trim())
                && !"".equals(txtContrasenea.getText().trim())) {

            // Validar que uno de los RadioButton esté seleccionado
            if (rbAdm.isSelected() || rbAsist.isSelected()) {
                // Validaciones
                String Dni = txtDni.getText().trim();
                String apPaterno = txtApPaterno.getText().trim();
                String apMaterno = txtApMaterno.getText().trim();
                String nombres = txtNombres.getText().trim();
                String email = txtEmail.getText().trim();
                String celular = txtCelular.getText().trim();
                String contrasena = txtContrasenea.getText().trim();

                // Validar que el DNI tenga exactamente 8 números
                if (!Dni.matches("\\d{8}")) {
                    JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números.", "DNI no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el DNI no es válido
                }

                // Validar que el celular tenga exactamente 9 números
                if (!celular.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(null, "El celular debe contener exactamente 9 números.", "Celular no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el celular no es válido
                }

                // Validar que los nombres solo contengan letras
                if (!nombres.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.", "Nombre no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el nombre no es válido
                }

                // Validar si el correo electrónico es válido
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Correo no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el correo no es válido
                }

                // Validar si la contraseña es segura
                if (!isSecurePassword(contrasena)) {
                    JOptionPane.showMessageDialog(null, "La contraseña no es segura. Debe tener al menos 8 caracteres, una letra mayúscula, una minúscula, un número y un carácter especial.", "Contraseña no segura", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si la contraseña no es segura
                }

                // Encriptar la contraseña antes de guardarla
                String contrasenaEncriptada = hashPassword(contrasena);

                // Si todas las validaciones son exitosas, se asignan los valores al objeto `user`
                user.setDniUsuario(Dni);
                user.setApPaternoUsuario(apPaterno);
                user.setApMaternoUsuario(apMaterno);
                user.setNombresUsuario(nombres);
                user.setEmailUsuario(email);
                user.setCelularUsuario(celular);
                user.setContraseñaUsuario(contrasenaEncriptada); // Guardar la contraseña encriptada

                // Validar qué radio button está seleccionado y asignar el rol
                String rol = rbAdm.isSelected() ? "Administrador" : "Asistente";
                user.setNivelAccesoUsuario(rol);  // Asignar el rol al objeto `user`

                // Verificar que el nivel de acceso sea correcto antes de guardar
                System.out.println("Nivel de acceso seleccionado: " + user.getNivelAccesoUsuario());
                System.out.println("Guardando usuario: " + user.getDniUsuario());

                // Guardar los datos del usuario
                usuario.RegistrarUsuario(user);

                // Limpiar tabla y formularios
                LimpiarTabla();
                LimpiarUsuarios();
                CargarUsuario();

            } else {
                // Si ninguno de los RadioButton está seleccionado, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Debe seleccionar algún cargo");
            }
        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed
    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // Verificar que todos los campos estén llenos, excepto la contraseña (puede ser opcional)
        if (!"".equals(txtDni.getText().trim())
                && !"".equals(txtApPaterno.getText().trim())
                && !"".equals(txtApMaterno.getText().trim())
                && !"".equals(txtNombres.getText().trim())
                && !"".equals(txtEmail.getText().trim())
                && !"".equals(txtCelular.getText().trim())) {

            // Verificar que al menos un RadioButton esté seleccionado
            if (rbAdm.isSelected() || rbAsist.isSelected()) {
                // Obtener datos ingresados
                String Dni = txtDni.getText().trim();
                String apPaterno = txtApPaterno.getText().trim();
                String apMaterno = txtApMaterno.getText().trim();
                String nombres = txtNombres.getText().trim();
                String email = txtEmail.getText().trim();
                String celular = txtCelular.getText().trim();
                String nuevaContrasena = txtContrasenea.getText().trim();

                // Validaciones
                if (!Dni.matches("\\d{8}")) {
                    JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números.", "DNI no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el DNI no es válido
                }

                if (!celular.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(null, "El celular debe contener exactamente 9 números.", "Celular no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el celular no es válido
                }

                if (!nombres.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.", "Nombre no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el nombre no es válido
                }

                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Correo no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el correo no es válido
                }

                // Cargar datos en el objeto `user`
                user.setIdUsuario(Integer.parseInt(txtId.getText().trim()));
                user.setDniUsuario(Dni);
                user.setApPaternoUsuario(apPaterno);
                user.setApMaternoUsuario(apMaterno);
                user.setNombresUsuario(nombres);
                user.setEmailUsuario(email);
                user.setCelularUsuario(celular);

                // Determinar el nivel de acceso basado en el RadioButton seleccionado
                String rol = rbAdm.isSelected() ? "Administrador" : "Asistente";
                user.setNivelAccesoUsuario(rol);  // Asignar el rol al objeto `user`

                // Validar si se proporciona una nueva contraseña
                if (!nuevaContrasena.isEmpty()) {
                    // Validar si la nueva contraseña es segura
                    if (!isSecurePassword(nuevaContrasena)) {
                        JOptionPane.showMessageDialog(null, "La contraseña no es segura. Debe tener al menos 8 caracteres, una letra mayúscula, una minúscula, un número y un carácter especial.", "Contraseña no segura", JOptionPane.WARNING_MESSAGE);
                        return; // Detener el proceso si la contraseña no es segura
                    }

                    // Encriptar la nueva contraseña
                    String contrasenaEncriptada = hashPassword(nuevaContrasena);
                    user.setContraseñaUsuario(contrasenaEncriptada); // Guardar la contraseña encriptada
                } else {
                    user.setContraseñaUsuario(null); // No modificar la contraseña si el campo está vacío
                }

                // Llamar al método para actualizar el usuario en la base de datos
                try {
                    usuario.ModificarUsuario(user);
                    LimpiarTabla();
                    LimpiarUsuarios();
                    CargarUsuario();

                    JOptionPane.showMessageDialog(null, "Datos del usuario actualizados exitosamente.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
                }
            } else {
                // Si ninguno de los RadioButton está seleccionado, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Debe seleccionar algún cargo.");
            }
        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

// Método para encriptar la contraseña usando SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

// Validar si la contraseña es segura
    public static boolean isSecurePassword(String password) {
        if (password.length() < 8) {
            return false;  // Menos de 8 caracteres
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;  // No contiene mayúscula
        }
        if (!password.matches(".*[a-z].*")) {
            return false;  // No contiene minúscula
        }
        if (!password.matches(".*\\d.*")) {
            return false;  // No contiene número
        }
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;  // No contiene carácter especial
        }
        return true;
    }

// Validar si el correo electrónico tiene un formato válido
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }
    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        if (!"".equals(txtId.getText())) {
            int consulta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Eliminar?");
            if (consulta == 0) {
                int Id = Integer.parseInt(txtId.getText());
                usuario.EliminarUsuario(Id);
                LimpiarTabla();
                LimpiarUsuarios();
                CargarUsuario();
            }

        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnLimpiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUsuarioActionPerformed
        LimpiarUsuarios();
    }//GEN-LAST:event_btnLimpiarUsuarioActionPerformed

    private void txtNombresAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresAlumnoActionPerformed

    private void rbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMasculinoActionPerformed

    private void btnGuardarAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarAlumnoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarAlumnoMouseClicked

    private void btnGuardarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlumnoActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdAlumno.getText().trim())
                && !"".equals(txtDniAlumno.getText().trim())
                && !"".equals(txtApPaternoAlumno.getText().trim())
                && !"".equals(txtApMaternoAlumno.getText().trim())
                && !"".equals(txtNombresAlumno.getText().trim())
                && !"".equals(txtEmailAlumno.getText().trim())
                && !"".equals(txtCelularAlumno.getText().trim())
                && !"".equals(txtAneoIngresoAlumno.getText().trim())) {

            // Validar que uno de los RadioButton esté seleccionado
            if (rbMasculino.isSelected() || rbFemenino.isSelected()) {
                // Validaciones
                String IdAlumno = txtIdAlumno.getText().trim();
                String DniAlumno = txtDniAlumno.getText().trim();
                String apPaternoAlumno = txtApPaternoAlumno.getText().trim();
                String apMaternoAlumno = txtApMaternoAlumno.getText().trim();
                String nombresAlumno = txtNombresAlumno.getText().trim();
                String emailAlumno = txtEmailAlumno.getText().trim();
                String celularAlumno = txtCelularAlumno.getText().trim();
                String aneoIngresoAlumno = txtAneoIngresoAlumno.getText().trim();

                // Validar que el DNI tenga exactamente 8 números
                if (!DniAlumno.matches("\\d{8}")) {
                    JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números.", "DNI no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el DNI no es válido
                }

                // Validar que el celular tenga exactamente 9 números
                if (!celularAlumno.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(null, "El celular debe contener exactamente 9 números.", "Celular no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el celular no es válido
                }

                // Validar que los nombres solo contengan letras
                if (!nombresAlumno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.", "Nombre no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el nombre no es válido
                }

                // Validar si el correo electrónico es válido
                if (!isValidEmail(emailAlumno)) {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Correo no válido", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso si el correo no es válido
                }

                // Si todas las validaciones son exitosas, se asignan los valores al objeto `user`
                estudiante.setIdAlumno(IdAlumno);
                estudiante.setDniAlumno(DniAlumno);
                estudiante.setApPaternoAlumno(apPaternoAlumno);
                estudiante.setApMaternoAlumno(apMaternoAlumno);
                estudiante.setNombresAlumno(nombresAlumno);
                estudiante.setEmailAlumno(emailAlumno);
                estudiante.setCelularAlumno(celularAlumno);
                estudiante.setAneoIngresoAlumno(aneoIngresoAlumno);

                // Validar qué radio button está seleccionado y asignar el rol
                String sexo = rbMasculino.isSelected() ? "M" : "F";
                estudiante.setSexoAlumno(sexo);  // Asignar el rol al objeto `user`

                // Guardar los datos del usuario
                estudiantes.RegistrarEstudiante(estudiante);

                // Limpiar tabla y formularios
                LimpiarTabla();
                LimpiarAlumno();
                CargarEstudiante();

            } else {
                // Si ninguno de los RadioButton está seleccionado, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Debe seleccionar algún sexo");
            }
        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }//GEN-LAST:event_btnGuardarAlumnoActionPerformed

    private void btnModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAlumnoActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdAlumno.getText().trim())
                && !"".equals(txtDniAlumno.getText().trim())
                && !"".equals(txtApPaternoAlumno.getText().trim())
                && !"".equals(txtApMaternoAlumno.getText().trim())
                && !"".equals(txtNombresAlumno.getText().trim())
                && !"".equals(txtEmailAlumno.getText().trim())
                && !"".equals(txtCelularAlumno.getText().trim())) {

            // Obtener datos ingresados
            String IdAlumno = txtIdAlumno.getText().trim();
            String DniAlumno = txtDniAlumno.getText().trim();
            String apPaternoAlumno = txtApPaternoAlumno.getText().trim();
            String apMaternoAlumno = txtApMaternoAlumno.getText().trim();
            String nombresAlumno = txtNombresAlumno.getText().trim();
            String emailAlumno = txtEmailAlumno.getText().trim();
            String celularAlumno = txtCelularAlumno.getText().trim();

            // Validaciones
            if (!DniAlumno.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números.", "DNI no válido", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el DNI no es válido
            }

            if (!celularAlumno.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(null, "El celular debe contener exactamente 9 números.", "Celular no válido", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el celular no es válido
            }

            if (!nombresAlumno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.", "Nombre no válido", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el nombre no es válido
            }

            if (!isValidEmail(emailAlumno)) {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Correo no válido", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el correo no es válido
            }

            // Cargar datos en el objeto `estudiante`
            estudiante.setIdAlumno(IdAlumno);
            estudiante.setDniAlumno(DniAlumno);
            estudiante.setApPaternoAlumno(apPaternoAlumno);
            estudiante.setApMaternoAlumno(apMaternoAlumno);
            estudiante.setNombresAlumno(nombresAlumno);
            estudiante.setEmailAlumno(emailAlumno);
            estudiante.setCelularAlumno(celularAlumno);

//                // Determinar el nivel de acceso basado en el RadioButton seleccionado
//                String sexo = rbMasculino.isSelected() ? "M" : "F";
//                user.setNivelAcceso(sexo);  // Asignar el rol al objeto `user`
            // Llamar al método para actualizar el usuario en la base de datos
            try {
                estudiantes.ModificarEstudiante(estudiante);
                LimpiarTabla();
                LimpiarAlumno();
                CargarEstudiante();

                JOptionPane.showMessageDialog(null, "Datos del Alumno actualizados exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
            }

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarAlumnoActionPerformed

    private void btnLimpiarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAlumnoActionPerformed
        LimpiarAlumno();
    }//GEN-LAST:event_btnLimpiarAlumnoActionPerformed

    private void tblEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstudianteMouseClicked
        int fila = tblEstudiante.rowAtPoint(evt.getPoint());
        txtIdAlumno.setText(tblEstudiante.getValueAt(fila, 0).toString());
        txtDniAlumno.setText(tblEstudiante.getValueAt(fila, 1).toString());
        txtApPaternoAlumno.setText(tblEstudiante.getValueAt(fila, 2).toString());
        txtApMaternoAlumno.setText(tblEstudiante.getValueAt(fila, 3).toString());
        txtNombresAlumno.setText(tblEstudiante.getValueAt(fila, 4).toString());
        txtEmailAlumno.setText(tblEstudiante.getValueAt(fila, 5).toString());
        txtCelularAlumno.setText(tblEstudiante.getValueAt(fila, 6).toString());
        txtAneoIngresoAlumno.setText(tblEstudiante.getValueAt(fila, 8).toString());

        // Verificar el rol y seleccionar el JRadioButton correspondiente
        String sexo = tblEstudiante.getValueAt(fila, 7).toString(); // Asumiendo que la columna 7 tiene el sexo
        if ("M".equals(sexo)) {
            rbMasculino.setSelected(true);
            rbFemenino.setSelected(false); // Asegúrate de deseleccionar el otro RadioButton
        } else if ("F".equals(sexo)) {
            rbFemenino.setSelected(true);
            rbMasculino.setSelected(false); // Asegúrate de deseleccionar el otro RadioButton
//        } else {
//            // Opcional: Si no es ninguno de los dos, puedes limpiar ambos
//            rbMasculino.setSelected(false);
//            rbFemenino.setSelected(false);
//        }
        }
    }//GEN-LAST:event_tblEstudianteMouseClicked

    private void rbFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFemeninoActionPerformed

    private void BtnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEstudianteActionPerformed
        LimpiarAlumno();
//        DefaultTableModel model = (DefaultTableModel) tblEstudiante.getModel();
//        model.setRowCount(0);
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(1);
        CargarEstudiante();
    }//GEN-LAST:event_BtnEstudianteActionPerformed

    private void tblProgramaEstudiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProgramaEstudiosMouseClicked
        int fila = tblProgramaEstudios.rowAtPoint(evt.getPoint());
        txtIdProgramaEstudio.setText(tblProgramaEstudios.getValueAt(fila, 0).toString());
        txtNombreProgramaEstudio.setText(tblProgramaEstudios.getValueAt(fila, 1).toString());
        txtModuloProgramaEstudio.setText(tblProgramaEstudios.getValueAt(fila, 2).toString());

    }//GEN-LAST:event_tblProgramaEstudiosMouseClicked

    private void btnLimpiarProgramaEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProgramaEstudioActionPerformed
        LimpiarProgramaEstudio();
    }//GEN-LAST:event_btnLimpiarProgramaEstudioActionPerformed

    private void btnModificarProgramaEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProgramaEstudioActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdProgramaEstudio.getText().trim())
                && !"".equals(txtNombreProgramaEstudio.getText().trim())
                && !"".equals(txtModuloProgramaEstudio.getText().trim())) {

            // Obtener datos ingresados
            String IdProgramaEstudio = txtIdProgramaEstudio.getText().trim();
            String ProgramaEstudio = txtNombreProgramaEstudio.getText().trim();
            String CantModulosPE = txtModuloProgramaEstudio.getText().trim();

            // Validaciones
            if (!CantModulosPE.matches("\\d{1}")) {
                JOptionPane.showMessageDialog(null, "La cantidad de módulos debe ser un número.", "Cantidad no válida", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el DNI no es válido
            }

            // Cargar datos en el objeto `ProgramaEstudio`
            PrograEstudio.setIdProgramaEstudio(IdProgramaEstudio);
            PrograEstudio.setProgramaEstudio(ProgramaEstudio);
            PrograEstudio.setCantModulos(CantModulosPE);

            try {
                PrograEstudios.ModificarProgramaEstudio(PrograEstudio);
                LimpiarTabla();
                LimpiarProgramaEstudio();
                CargarProgramaEstudio();

                JOptionPane.showMessageDialog(null, "Datos del Alumno actualizados exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
            }

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarProgramaEstudioActionPerformed

    private void btnGuardarProgramaEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProgramaEstudioActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdProgramaEstudio.getText().trim())
                && !"".equals(txtNombreProgramaEstudio.getText().trim())
                && !"".equals(txtModuloProgramaEstudio.getText().trim())) {

            // Validaciones
            String IdProgramaEstudios = txtIdProgramaEstudio.getText().trim();
            String ProgramaEstudios = txtNombreProgramaEstudio.getText().trim();
            String CantidadModulosProgramaEstudios = txtModuloProgramaEstudio.getText().trim();

            // Validar que CantidadModulosProgramaEstudios sea un número
            if (!CantidadModulosProgramaEstudios.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "La cantidad de módulos debe ser un número.", "Cantidad no válida", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si la cantidad no es válida
            }

            // Asignar los valores al objeto `ProgramaEstudio`
            PrograEstudio.setIdProgramaEstudio(IdProgramaEstudios);
            PrograEstudio.setProgramaEstudio(ProgramaEstudios);
            PrograEstudio.setCantModulos(CantidadModulosProgramaEstudios);

            PrograEstudios.RegistrarProgramaEstudios(PrograEstudio);

            // Limpiar tabla y formularios
            LimpiarTabla();
            LimpiarProgramaEstudio();
            CargarProgramaEstudio();

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }//GEN-LAST:event_btnGuardarProgramaEstudioActionPerformed

    private void btnGuardarProgramaEstudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarProgramaEstudioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarProgramaEstudioMouseClicked

    private void btnGuardarModuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarModuloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarModuloMouseClicked

    private void btnGuardarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarModuloActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdModulo.getText().trim())
                && !"".equals(txtNombreModulo.getText().trim())
                && !"".equals(txtProgramaEstudio.getText().trim())) {

            // Validaciones
            String IdModulo = txtIdModulo.getText().trim();
            String NombreModulo = txtNombreModulo.getText().trim();
            String ProgramaEstudios = txtProgramaEstudio.getText().trim();

            // Asignar los valores al objeto `Modulo`
            modulo.setIdModulo(IdModulo);
            modulo.setNombreModulo(NombreModulo);
            modulo.setIdProgramaEstudios(ProgramaEstudios);

            modulos.RegistrarModulos(modulo);

            // Limpiar tabla y formularios
            LimpiarTabla();
            LimpiarModulo();
            CargarModulos();

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
    }//GEN-LAST:event_btnGuardarModuloActionPerformed

    private void btnModificarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarModuloActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdModulo.getText().trim())
                && !"".equals(txtNombreModulo.getText().trim()) /*&& !"".equals(txtProgramaEstudio.getText().trim())*/) {

            // Obtener datos ingresados
            String IdModulo = txtIdModulo.getText().trim();
            String NombreModulo = txtNombreModulo.getText().trim();
            /*String IdProgramaEstudio = txtProgramaEstudio.getText().trim();*/

            // Cargar datos en el objeto `ProgramaEstudio`
            modulo.setIdModulo(IdModulo);
            modulo.setNombreModulo(NombreModulo);
            /*modulo.setIdProgramaEstudios(IdProgramaEstudio);*/

            try {
                modulos.ModificarModulos(modulo);
                LimpiarTabla();
                LimpiarModulo();
                CargarModulos();

                JOptionPane.showMessageDialog(null, "Datos del Módulo actualizados exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
            }

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarModuloActionPerformed

    private void btnLimpiarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarModuloActionPerformed
        LimpiarModulo();
    }//GEN-LAST:event_btnLimpiarModuloActionPerformed

    private void TblModuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblModuloMouseClicked
        int fila = TblModulo.rowAtPoint(evt.getPoint());
        txtIdModulo.setText(TblModulo.getValueAt(fila, 0).toString());
        txtNombreModulo.setText(TblModulo.getValueAt(fila, 1).toString());
        txtProgramaEstudio.setText(TblModulo.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_TblModuloMouseClicked

    private void BtnModuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModuloMouseClicked
        LimpiarTabla();
        jTabbedPane1.setSelectedIndex(10);
        CargarModulos();
    }//GEN-LAST:event_BtnModuloMouseClicked

    private void txtPEUnidadDidacticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPEUnidadDidacticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPEUnidadDidacticaActionPerformed

    private void btnGuardarUdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarUdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarUdMouseClicked

    private void btnGuardarUdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUdActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdUnidadDidactica.getText().trim())
                && !"".equals(jTextArea1.getText().trim())
                && !"".equals(txtHorasUnidaDidactica.getText().trim())
                && !"".equals(txtCreditosUnidadDidactica.getText().trim())
                && !"".equals(txtPEUnidadDidactica.getText().trim())
                && !"".equals(txtModUnidadDidactica.getText().trim())) {

            // Validaciones
            String IdUnidadDidactica = txtIdUnidadDidactica.getText().trim();
            String NombreUnidadDidactica = jTextArea1.getText().trim();
            String HorasUnidadDidactica = txtHorasUnidaDidactica.getText().trim();
            String CreditosUnidadDidactica = txtCreditosUnidadDidactica.getText().trim();
            String PEUnidadDidactica = txtPEUnidadDidactica.getText().trim();
            String ModUnidadDidactica = txtModUnidadDidactica.getText().trim();

            // Validar que el DNI tenga exactamente 8 números
            if (!HorasUnidadDidactica.matches("\\d{1}")) {
                JOptionPane.showMessageDialog(null, "Las horas deben de ser un número.", "Horas no válido", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el DNI no es válido
            }

            // Validar que el celular tenga exactamente 9 números
            if (!CreditosUnidadDidactica.matches("\\d{1}")) {
                JOptionPane.showMessageDialog(null, "Loes créditos deben de ser un número.", "Créditos no válidos", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el celular no es válido
            }
            // Si todas las validaciones son exitosas, se asignan los valores al objeto `user`
            unidaDidactica.setIdUnidadDidactica(IdUnidadDidactica);
            unidaDidactica.setNombreUnidadDidactica(NombreUnidadDidactica);
            unidaDidactica.setHorasUnidadDidactica(HorasUnidadDidactica);
            unidaDidactica.setCreditosUnidadDidactica(CreditosUnidadDidactica);
            unidaDidactica.setIdProgramaEstudios(PEUnidadDidactica);
            unidaDidactica.setIdModulo(ModUnidadDidactica);

            // Guardar los datos del usuario
            unidadesDidacticas.RegistrarUnidadDidactica(unidaDidactica);

            // Limpiar tabla y formularios
            LimpiarTabla();
            LimpiarUnidadDidactica();
            CargarUnidadDidactica();

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }//GEN-LAST:event_btnGuardarUdActionPerformed

    private void btnModificarUdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUdActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdUnidadDidactica.getText().trim())
                && !"".equals(jTextArea1.getText().trim())
                && !"".equals(txtHorasUnidaDidactica.getText().trim())
                && !"".equals(txtCreditosUnidadDidactica.getText().trim())
                && !"".equals(txtPEUnidadDidactica.getText().trim())
                && !"".equals(txtModUnidadDidactica.getText().trim())) {

            // Obtener datos ingresados
            String IdUnidadDidactica = txtIdUnidadDidactica.getText().trim();
            String NombreUnidadDidactica = jTextArea1.getText().trim();
            String HorasUnidadDidactica = txtHorasUnidaDidactica.getText().trim();
            String CreditosUnidadDidactica = txtCreditosUnidadDidactica.getText().trim();
            String PEUnidadDidactica = txtPEUnidadDidactica.getText().trim();
            String ModUnidadDidactica = txtModUnidadDidactica.getText().trim();

            // Validar que el DNI tenga exactamente 8 números
            if (!HorasUnidadDidactica.matches("\\d{1}")) {
                JOptionPane.showMessageDialog(null, "Las horas deben de ser un número.", "Horas no válido", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el DNI no es válido
            }

            // Validar que el celular tenga exactamente 9 números
            if (!CreditosUnidadDidactica.matches("\\d{1}")) {
                JOptionPane.showMessageDialog(null, "Loes créditos deben de ser un número.", "Créditos no válidos", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso si el celular no es válido
            }

            // Cargar datos en el objeto `estudiante`
            unidaDidactica.setIdUnidadDidactica(IdUnidadDidactica);
            unidaDidactica.setNombreUnidadDidactica(NombreUnidadDidactica);
            unidaDidactica.setHorasUnidadDidactica(HorasUnidadDidactica);
            unidaDidactica.setCreditosUnidadDidactica(CreditosUnidadDidactica);
            unidaDidactica.setIdProgramaEstudios(PEUnidadDidactica);
            unidaDidactica.setIdModulo(ModUnidadDidactica);

            try {
                unidadesDidacticas.ModificarUnidadDidactica(unidaDidactica);
                LimpiarTabla();
                LimpiarUnidadDidactica();
                CargarUnidadDidactica();

                JOptionPane.showMessageDialog(null, "Datos de la Unidad Didácticas actualizados exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
            }

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarUdActionPerformed

    private void btnLimpiarUdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUdActionPerformed
        LimpiarUnidadDidactica();
    }//GEN-LAST:event_btnLimpiarUdActionPerformed

    private void tblUnidadesDidacticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUnidadesDidacticasMouseClicked
        int fila = tblUnidadesDidacticas.rowAtPoint(evt.getPoint());
        txtIdUnidadDidactica.setText(tblUnidadesDidacticas.getValueAt(fila, 0).toString());
        jTextArea1.setText(tblUnidadesDidacticas.getValueAt(fila, 1).toString());
        txtHorasUnidaDidactica.setText(tblUnidadesDidacticas.getValueAt(fila, 2).toString());
        txtCreditosUnidadDidactica.setText(tblUnidadesDidacticas.getValueAt(fila, 3).toString());
        txtPEUnidadDidactica.setText(tblUnidadesDidacticas.getValueAt(fila, 4).toString());
        txtModUnidadDidactica.setText(tblUnidadesDidacticas.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_tblUnidadesDidacticasMouseClicked

    private void txtModUnidadDidacticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModUnidadDidacticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModUnidadDidacticaActionPerformed

    private void btnGuardarPeriodoLectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarPeriodoLectivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarPeriodoLectivoMouseClicked

    private void btnGuardarPeriodoLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPeriodoLectivoActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdPeriodoLectivo.getText().trim())
                && !"".equals(txtAneoPeriodoLectivo.getText().trim())
                && !"".equals(txtNumeroPeriodoLectivo.getText().trim())) {

            // Validaciones
            String IdPeriodoLectivo = txtIdPeriodoLectivo.getText().trim();
            String AneoPeriodoLectivo = txtAneoPeriodoLectivo.getText().trim();
            String NumeroPeriodoLectivo = txtNumeroPeriodoLectivo.getText().trim();

            // Asignar los valores al objeto `Modulo`
            periodoLectivo.setIdPeriodoLectivo(IdPeriodoLectivo);
            periodoLectivo.setAnioPeriodoLectivo(AneoPeriodoLectivo);
            periodoLectivo.setNumeroPeriodoLectivo(NumeroPeriodoLectivo);

            periodosLectivos.RegistrarPeriodoLectivo(periodoLectivo);

            // Limpiar tabla y formularios
            LimpiarTabla();
            LimpiarPeriodoLectivo();
            CargarPeriodoLectivo();

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
    }//GEN-LAST:event_btnGuardarPeriodoLectivoActionPerformed

    private void btnModificarPeriodoLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPeriodoLectivoActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdPeriodoLectivo.getText().trim())
                && !"".equals(txtAneoPeriodoLectivo.getText().trim())
                && !"".equals(txtNumeroPeriodoLectivo.getText().trim())) {

            // Obtener datos ingresados
            String IdPeriodoLectivo = txtIdPeriodoLectivo.getText().trim();
            String AneoPeriocoLectivo = txtAneoPeriodoLectivo.getText().trim();
            String NumeroPeriodoLectivo = txtNumeroPeriodoLectivo.getText().trim();

            // Cargar datos en el objeto `PeriodoLectivo`
            periodoLectivo.setIdPeriodoLectivo(IdPeriodoLectivo);
            periodoLectivo.setAnioPeriodoLectivo(AneoPeriocoLectivo);
            periodoLectivo.setNumeroPeriodoLectivo(NumeroPeriodoLectivo);

            try {
                periodosLectivos.ModificarPeriodoLectivo(periodoLectivo);
                LimpiarTabla();
                LimpiarPeriodoLectivo();
                CargarPeriodoLectivo();

                JOptionPane.showMessageDialog(null, "Datos del Periodo Lectivo actualizados exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
            }

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarPeriodoLectivoActionPerformed

    private void btnLimpiarPeriodoLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPeriodoLectivoActionPerformed
        LimpiarPeriodoLectivo();
    }//GEN-LAST:event_btnLimpiarPeriodoLectivoActionPerformed

    private void tblPeriodoLectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeriodoLectivoMouseClicked
        int fila = tblPeriodoLectivo.rowAtPoint(evt.getPoint());
        txtIdPeriodoLectivo.setText(tblPeriodoLectivo.getValueAt(fila, 0).toString());
        txtAneoPeriodoLectivo.setText(tblPeriodoLectivo.getValueAt(fila, 1).toString());
        txtNumeroPeriodoLectivo.setText(tblPeriodoLectivo.getValueAt(fila, 2).toString());

    }//GEN-LAST:event_tblPeriodoLectivoMouseClicked

    private void tblMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMatriculaMouseClicked

        int fila = tblMatricula.rowAtPoint(evt.getPoint());
        txtIdMatricula.setText(tblMatricula.getValueAt(fila, 0).toString());
        txtIdAlumnoMatricula.setText(tblMatricula.getValueAt(fila, 1).toString());
        txtApPaternoMatricula.setText(tblMatricula.getValueAt(fila, 2).toString());
        txtApMaternoMatricula.setText(tblMatricula.getValueAt(fila, 3).toString());
        txtNombresMatricula.setText(tblMatricula.getValueAt(fila, 4).toString());
        txtIdPEMatricula.setText(tblMatricula.getValueAt(fila, 5).toString());
        txtIdProgramaEstudiosMatricula.setText(tblMatricula.getValueAt(fila, 6).toString());
        txtPeriodoLectivoMatricula.setText(tblMatricula.getValueAt(fila, 7).toString());
        txtIdAulaMatricula.setText(tblMatricula.getValueAt(fila, 8).toString());

    }//GEN-LAST:event_tblMatriculaMouseClicked

    private void btnLimpiarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMatriculaActionPerformed
        LimpiarMatricula();
    }//GEN-LAST:event_btnLimpiarMatriculaActionPerformed

    private void btnModificarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMatriculaActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdMatricula.getText().trim())
                && !"".equals(txtIdPEMatricula.getText().trim())
                //&& !"".equals(txtIdProgramaEstudiosMatricula.getText().trim())
                && !"".equals(txtPeriodoLectivoMatricula.getText().trim())
                && !"".equals(txtIdAulaMatricula.getText().trim())) {

            // Obtener datos ingresados
            String IdMatriculaMat = txtIdMatricula.getText().trim();
            String IdProgramaEstudio = txtIdPEMatricula.getText().trim();
            String PerdioLectivoMatricula = txtPeriodoLectivoMatricula.getText().trim();
            String AulaMatricula = txtIdAulaMatricula.getText().trim();

            // Cargar datos en el objeto `Matricula`
            matricula.setIdMatricula(IdMatriculaMat);
            matricula.setIdProgramaEstudioMatricula(IdProgramaEstudio);
            matricula.setIdPeriodoLectivoMatricula(PerdioLectivoMatricula);
            matricula.setIdAulaMatricula(AulaMatricula);

            try {
                matriculas.ModificarMatricula(matricula);
                LimpiarTabla();
                LimpiarMatricula();
                CargarMatricula();

                JOptionPane.showMessageDialog(null, "Datos de la Matricula actualizados exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
            }

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarMatriculaActionPerformed

    private void btnGuardarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMatriculaActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdMatricula.getText().trim())
                && !"".equals(txtIdAlumnoMatricula.getText().trim())
                && !"".equals(txtIdPEMatricula.getText().trim())
                && !"".equals(txtPeriodoLectivoMatricula.getText().trim())
                && !"".equals(txtIdAulaMatricula.getText().trim())) {
            // Validaciones
            String IdMatricula = txtIdMatricula.getText().trim();
            String IdAlumnoMatricula = txtIdAlumnoMatricula.getText().trim();
            String IdProgramaEstudiosMatricula = txtIdPEMatricula.getText().trim();
            String PerdiodoLectivoMatricula = txtPeriodoLectivoMatricula.getText().trim();
            String IdAulaMatricula = txtIdAulaMatricula.getText().trim();

            matricula.setIdMatricula(IdMatricula);
            matricula.setIdAlumnoMatricula(IdAlumnoMatricula);
            matricula.setIdProgramaEstudioMatricula(IdProgramaEstudiosMatricula);
            matricula.setIdPeriodoLectivoMatricula(PerdiodoLectivoMatricula);
            matricula.setIdAulaMatricula(IdAulaMatricula);

            // Guardar los datos de la Matricula
            matriculas.RegistrarMatricula(matricula);

            // Limpiar tabla y formularios
            LimpiarTabla();
            LimpiarMatricula();
            CargarMatricula();

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }//GEN-LAST:event_btnGuardarMatriculaActionPerformed

    private void btnGuardarMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMatriculaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMatriculaMouseClicked

    private void txtNombresMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresMatriculaActionPerformed

    private void txtFehcaRegistroNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFehcaRegistroNotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFehcaRegistroNotasActionPerformed

    private void btnGuardarNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarNotasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarNotasMouseClicked

    private void btnGuardarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNotasActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdMatriculaNotas.getText().trim())
                && !"".equals(txtIdUnidaDidacticaNotas.getText().trim())
                && !"".equals(txtNotas.getText().trim())) {
            // Validaciones
            String IdMatriculaNotas = txtIdMatriculaNotas.getText().trim();
            String IdUnidaDidacticaNotas = txtIdUnidaDidacticaNotas.getText().trim();
            int notaob = Integer.parseInt(txtNotas.getText().trim());
            LocalDateTime fechaActual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaRegistroNotas = fechaActual.format(formato);

            nota.setIdMatricula(IdMatriculaNotas);
            nota.setIdUnidadDidactica(IdUnidaDidacticaNotas);
            nota.setNota(notaob);
            nota.setFechaRegistro(fechaRegistroNotas);

            // Guardar los datos de la Matricula
            notas.RegistrarNota(nota);

            // Limpiar tabla y formularios
            LimpiarTabla();
            LimpiarNotas();
            CargarNotas();

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }

    }//GEN-LAST:event_btnGuardarNotasActionPerformed

    private void btnModificarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarNotasActionPerformed
        // Verificar que todos los campos estén llenos
        if (!"".equals(txtIdMatriculaNotas.getText().trim())
                && !"".equals(txtIdUnidaDidacticaNotas.getText().trim())
                && !"".equals(txtNotas.getText().trim())) {

            // Obtener datos ingresados
            String IdMatriculaNotas = txtIdMatriculaNotas.getText().trim();
            String IdUnidadDidacticaNotas = txtIdUnidaDidacticaNotas.getText().trim();
            int notaob = Integer.parseInt(txtNotas.getText().trim());
            int IdNota = Integer.parseInt(txtIdNotas.getText().trim());
            String FechaRegistro = txtFehcaRegistroNotas.getText().trim();
            // Cargar datos en el objeto `Matricula`
            nota.setIdMatricula(IdMatriculaNotas);
            nota.setIdUnidadDidactica(IdUnidadDidacticaNotas);
            nota.setNota(notaob);
            nota.setIdNota(IdNota);
            nota.setFechaRegistro(FechaRegistro);

            try {
                notas.ModificarNota(nota);
                LimpiarTabla();
                LimpiarNotas();
                CargarNotas();

                JOptionPane.showMessageDialog(null, "Datos de la Nota actualizado exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
            }

        } else {
            // Si alguno de los campos de texto está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        }
    }//GEN-LAST:event_btnModificarNotasActionPerformed

    private void btnLimpiarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarNotasActionPerformed
        LimpiarNotas();
    }//GEN-LAST:event_btnLimpiarNotasActionPerformed

    private void tblNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotasMouseClicked
        int fila = tblNotas.rowAtPoint(evt.getPoint());
        txtIdNotas.setText(tblNotas.getValueAt(fila, 0).toString());
        txtIdMatriculaNotas.setText(tblNotas.getValueAt(fila, 1).toString());
        txtIdUnidaDidacticaNotas.setText(tblNotas.getValueAt(fila, 2).toString());
        txtNombreUnidadDidacticaNotas.setText(tblNotas.getValueAt(fila, 3).toString());
        txtNotas.setText(tblNotas.getValueAt(fila, 4).toString());
        txtFehcaRegistroNotas.setText(tblNotas.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_tblNotasMouseClicked

    private void btnBuscarBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBNActionPerformed
        buscarEstudiantePorDni(); // Llamada al método de búsqueda
        txtNombreEstudianteBN.setText("");
        txtAProgramaEstudiosBN.setText("");
        txtPeriodoAcadeBN.setText("");
        txtPeriodoLectBN.setText("");
        txtTotalCreditosPeriodoBN.setText("");
        txtCreditosAprobadosBN.setText("");
        txtPromedioGeneralBN2.setText("");
        txtPuntajeTotalObtBN1.setText("");
        txtCreditosDesaprobadosBN5.setText("");
        txtOrdenMeritoBN3.setText("");
        LimpiarTablaEspecifica(tblNotasBN);

    }//GEN-LAST:event_btnBuscarBNActionPerformed

    private void tblNotasBNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotasBNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNotasBNMouseClicked

    private void btnVerNotasBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerNotasBNActionPerformed
        LimpiarBoletaNotas();
        LimpiarTabla();
        LimpiarTablaEspecifica(tblEstudiantesBN);
    }//GEN-LAST:event_btnVerNotasBNActionPerformed

    private void btnBuscarBN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBN2ActionPerformed
        BoletaNotasReporte reporte = new BoletaNotasReporte();

        // Recoge los datos para el reporte
        String codigoMatricula = txtIdMatriculaBN.getText();
        String nombreEstudiante = txtNombreEstudianteBN.getText();
        String programaEstudio = txtAProgramaEstudiosBN.getText();
        String periodoAcademico = txtPeriodoAcadeBN.getText();
        double totalCreditos = Double.parseDouble(txtTotalCreditosPeriodoBN.getText());
        double puntajeTotal = Double.parseDouble(txtPuntajeTotalObtBN1.getText());
        double promedioGeneral = Double.parseDouble(txtPromedioGeneralBN2.getText());
        int ordenMerito = Integer.parseInt(txtOrdenMeritoBN3.getText());
        String condicion = "APROBADO SATISFACTORIAMENTE"; // Ejemplo, podrías calcularlo según la lógica

        // Llama al método de generación de reporte
//        reporte.generarReporte(ListaDesempenoBN, codigoMatricula, nombreEstudiante, programaEstudio,
//                               periodoAcademico, totalCreditos, puntajeTotal, promedioGeneral, ordenMerito, condicion);
//    
    }//GEN-LAST:event_btnBuscarBN2ActionPerformed

    private void btnVerNotasBNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerNotasBNMouseClicked

    }//GEN-LAST:event_btnVerNotasBNMouseClicked

    private void tblEstudiantesBNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstudiantesBNMouseClicked
        int fila = tblEstudiantesBN.rowAtPoint(evt.getPoint());

        String nombreEstudiante = tblEstudiantesBN.getValueAt(fila, 3).toString()
                .replaceAll("<br>", " ")
                .replaceAll("<[^>]*>", "");

        String programaEstudios = tblEstudiantesBN.getValueAt(fila, 4).toString()
                .replaceAll("<br>", " ")
                .replaceAll("<[^>]*>", "");

        String idMatricula = tblEstudiantesBN.getValueAt(fila, 2).toString();
        txtIdMatriculaBNs.setText(idMatricula);
        txtNombreEstudianteBN.setText(nombreEstudiante);
        txtAProgramaEstudiosBN.setText(programaEstudios);
        txtPeriodoAcadeBN.setText(tblEstudiantesBN.getValueAt(fila, 5).toString());
        txtPeriodoLectBN.setText(tblEstudiantesBN.getValueAt(fila, 6).toString());

        String IdMatricula = txtIdMatriculaBNs.getText(); // Obtener el DNI del campo de texto
        if (!IdMatricula.isEmpty()) { // Verifica que el DNI no esté vacío
            CargarNotasBN(IdMatricula); // Llama al método para cargar las notas
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un DNI válido.");
        }

        String idMatriculas = txtIdMatriculaBNs.getText().trim();
        // Crear un objeto DecimalFormat para limitar a 2 decimales
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        if (!idMatriculas.isEmpty()) {
            // Llamar al método controlador para cargar los datos del rendimiento del estudiante
            List<BoletaNotasControlador> listaDesempeno = estudiantesBNs.CargarDesemBN(idMatriculas);

            // Verificar si la lista contiene datos
            if (!listaDesempeno.isEmpty()) {
                // Obtener el primer registro de la lista
                BoletaNotasControlador desempeno = listaDesempeno.get(0);

                // Cargar los datos en los TextFields correspondientes
                txtTotalCreditosPeriodoBN.setText(desempeno.getTotalCreditosDesemBN());
                txtPuntajeTotalObtBN1.setText(desempeno.getPuntajeTotalDesemBN());
                txtCreditosAprobadosBN.setText(desempeno.getCreditosAprobadosDesemBN());
                txtCreditosDesaprobadosBN5.setText(desempeno.getCreditosDesaprobadosDesemBN());
                // Formatear el promedio general a 2 decimales
                String promedioFormateado = decimalFormat.format(Double.parseDouble(desempeno.getPromedioGeneralDesemBN()));
                txtPromedioGeneralBN2.setText(promedioFormateado);
                //txtPromedioGeneralBN2.setText(desempeno.getPromedioGeneralDesemBN());
                txtOrdenMeritoBN3.setText(desempeno.getOrdenMeritoDesemBN());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID de matrícula proporcionado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de matrícula válido.");
        }

        LimpiarTabla();
        LimpiarEstudiantesBN();
        CargarNotasBN(IdMatricula);
        //System.out.println(IdMatricula);

    }//GEN-LAST:event_tblEstudiantesBNMouseClicked

    private void BtnBoletaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBoletaNotasActionPerformed
        LimpiarBoletaNotas();
        LimpiarEstudiantesBN();
        LimpiarTablaEspecifica(tblEstudiantesBN);
        LimpiarTablaEspecifica(tblNotasBN);
        jTabbedPane1.setSelectedIndex(0);
        LimpiarEstudiantesBN();
    }//GEN-LAST:event_BtnBoletaNotasActionPerformed

    private void txtPuntajeTotalObtBN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuntajeTotalObtBN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuntajeTotalObtBN1ActionPerformed

    private void txtIdMatriculaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMatriculaNotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMatriculaNotasActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
                  Sistema sistema = new Sistema();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBoletaNotas;
    private javax.swing.JButton BtnEstudiante;
    private javax.swing.JButton BtnMatricula;
    private javax.swing.JButton BtnModulo;
    private javax.swing.JButton BtnNotas;
    private javax.swing.JButton BtnPeriodoLectivo;
    private javax.swing.JButton BtnProgramaEstudio;
    private javax.swing.JButton BtnReporte;
    private javax.swing.JButton BtnUnidadDidactica;
    private javax.swing.JButton BtnUsuario;
    private javax.swing.JPanel JpBoletaNotas;
    private javax.swing.JPanel JpEstudiantes;
    private javax.swing.JPanel JpMatricula;
    private javax.swing.JPanel JpModulos;
    private javax.swing.JPanel JpNotas;
    private javax.swing.JPanel JpPeriodoAcademico;
    private javax.swing.JPanel JpPeriodoLectivo;
    private javax.swing.JPanel JpProgramaEstudios;
    private javax.swing.JPanel JpReporte;
    private javax.swing.JPanel JpUnidadesDidacticas;
    private javax.swing.JPanel JpUsuarios;
    private javax.swing.JLabel PERIODO;
    private javax.swing.JTable TblModulo;
    private javax.swing.JButton btnBuscarBN;
    private javax.swing.JButton btnBuscarBN2;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnGuardarAlumno;
    private javax.swing.JButton btnGuardarMatricula;
    private javax.swing.JButton btnGuardarModulo;
    private javax.swing.JButton btnGuardarNotas;
    private javax.swing.JButton btnGuardarPeriodoLectivo;
    private javax.swing.JButton btnGuardarProgramaEstudio;
    private javax.swing.JButton btnGuardarUd;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JButton btnLimpiarAlumno;
    private javax.swing.JButton btnLimpiarMatricula;
    private javax.swing.JButton btnLimpiarModulo;
    private javax.swing.JButton btnLimpiarNotas;
    private javax.swing.JButton btnLimpiarPeriodoLectivo;
    private javax.swing.JButton btnLimpiarProgramaEstudio;
    private javax.swing.JButton btnLimpiarUd;
    private javax.swing.JButton btnLimpiarUsuario;
    private javax.swing.JButton btnModificarAlumno;
    private javax.swing.JButton btnModificarMatricula;
    private javax.swing.JButton btnModificarModulo;
    private javax.swing.JButton btnModificarNotas;
    private javax.swing.JButton btnModificarPeriodoLectivo;
    private javax.swing.JButton btnModificarProgramaEstudio;
    private javax.swing.JButton btnModificarUd;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnVerNotasBN;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton rbAdm;
    private javax.swing.JRadioButton rbAsist;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tblEstudiante;
    private javax.swing.JTable tblEstudiantesBN;
    private javax.swing.JTable tblMatricula;
    private javax.swing.JTable tblNotas;
    private javax.swing.JTable tblNotasBN;
    private javax.swing.JTable tblPeriodoLectivo;
    private javax.swing.JTable tblProgramaEstudios;
    private javax.swing.JTable tblUnidadesDidacticas;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextArea txtAProgramaEstudiosBN;
    private javax.swing.JTextField txtAneoIngresoAlumno;
    private javax.swing.JTextField txtAneoPeriodoLectivo;
    private javax.swing.JTextField txtApMaterno;
    private javax.swing.JTextField txtApMaternoAlumno;
    private javax.swing.JTextField txtApMaternoMatricula;
    private javax.swing.JTextField txtApPaterno;
    private javax.swing.JTextField txtApPaternoAlumno;
    private javax.swing.JTextField txtApPaternoMatricula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCelularAlumno;
    private javax.swing.JTextField txtContrasenea;
    private javax.swing.JTextField txtCreditosAprobadosBN;
    private javax.swing.JTextField txtCreditosDesaprobadosBN5;
    private javax.swing.JTextField txtCreditosUnidadDidactica;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDniAlumno;
    private javax.swing.JTextField txtDniBN;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailAlumno;
    private javax.swing.JTextField txtFehcaRegistroNotas;
    private javax.swing.JTextField txtHorasUnidaDidactica;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdAlumno;
    private javax.swing.JTextField txtIdAlumnoMatricula;
    private javax.swing.JTextField txtIdAulaMatricula;
    private javax.swing.JTextField txtIdMatricula;
    private javax.swing.JTextField txtIdMatriculaBN;
    private javax.swing.JTextField txtIdMatriculaBNs;
    private javax.swing.JTextField txtIdMatriculaNotas;
    private javax.swing.JTextField txtIdModulo;
    private javax.swing.JTextField txtIdNotas;
    private javax.swing.JTextField txtIdPEMatricula;
    private javax.swing.JTextField txtIdPeriodoLectivo;
    private javax.swing.JTextField txtIdProgramaEstudio;
    private javax.swing.JTextArea txtIdProgramaEstudiosMatricula;
    private javax.swing.JTextField txtIdUnidaDidacticaNotas;
    private javax.swing.JTextField txtIdUnidadDidactica;
    private javax.swing.JTextField txtModUnidadDidactica;
    private javax.swing.JTextField txtModuloProgramaEstudio;
    private javax.swing.JTextField txtNombreEstudianteBN;
    private javax.swing.JTextArea txtNombreModulo;
    private javax.swing.JTextField txtNombreProgramaEstudio;
    private javax.swing.JTextArea txtNombreUnidadDidacticaNotas;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombresAlumno;
    private javax.swing.JTextField txtNombresMatricula;
    private javax.swing.JTextField txtNotas;
    private javax.swing.JTextField txtNumeroPeriodoLectivo;
    private javax.swing.JTextField txtOrdenMeritoBN3;
    private javax.swing.JTextField txtPEUnidadDidactica;
    private javax.swing.JTextField txtPeriodoAcadeBN;
    private javax.swing.JTextField txtPeriodoLectBN;
    private javax.swing.JTextField txtPeriodoLectivoMatricula;
    private javax.swing.JTextField txtProgramaEstudio;
    private javax.swing.JTextField txtPromedioGeneralBN2;
    private javax.swing.JTextField txtPuntajeTotalObtBN1;
    private javax.swing.JTextField txtTotalCreditosPeriodoBN;
    // End of variables declaration//GEN-END:variables

}
