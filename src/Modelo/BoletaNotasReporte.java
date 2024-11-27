package Modelo;

import Controlador.BoletaNotasControlador;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoletaNotasReporte {

    public void generarReporte(List<BoletaNotasControlador> ListaDesempenoBN, String codigoMatricula, String nombreEstudiante,
            String programaEstudio, String periodoAcademico, double totalCreditos,
            double puntajeTotal, double promedioGeneral, int ordenMerito, String condicion) {
        try {
            // Compila el archivo JRXML a un archivo Jasper
//         JasperReport jasperReport = JasperCompileManager.compileReport("src/reports/BoletaNotasReport.jrxml");

            // Crear los parámetros para el reporte
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("codigoMatricula", codigoMatricula);
            parametros.put("nombreEstudiante", nombreEstudiante);
            parametros.put("programaEstudio", programaEstudio);
            parametros.put("periodoAcademico", periodoAcademico);
            parametros.put("totalCreditos", totalCreditos);
            parametros.put("puntajeTotal", puntajeTotal);
            parametros.put("promedioGeneral", String.format("%.2f", promedioGeneral)); // Formato de 2 decimales
            parametros.put("ordenMerito", ordenMerito);
            parametros.put("condicion", condicion);

            // Fuente de datos para el reporte
//            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListaDesempenoBN);
//
//            // Llenar el reporte con datos y parámetros
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
//
//            // Mostrar el reporte en una ventana
//            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) { //JR
            e.printStackTrace();
        }
    }
}
