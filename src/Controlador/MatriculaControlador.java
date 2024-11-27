package Controlador;

public class MatriculaControlador {

    private String IdMatricula;
    private String IdAlumnoMatricula;
    private String ApPaternoMatricula;
    private String ApMaternoMatricula;
    private String NombresMatricula;
    private String IdProgramaEstudioMatricula;  
    private String NombreProgramaEstudioMatricula;     
    private String IdPeriodoLectivoMatricula;  
    private String IdAulaMatricula;

    public MatriculaControlador() {
    }

    public MatriculaControlador(String IdMatricula, String IdAlumnoMatricula, String ApPaternoMatricula, String ApMaternoMatricula, String NombresMatricula, String IdProgramaEstudioMatricula, String NombreProgramaEstudioMatricula, String IdPeriodoLectivoMatricula, String IdAulaMatricula) {
        this.IdMatricula = IdMatricula;
        this.IdAlumnoMatricula = IdAlumnoMatricula;
        this.ApPaternoMatricula = ApPaternoMatricula;
        this.ApMaternoMatricula = ApMaternoMatricula;
        this.NombresMatricula = NombresMatricula;
        this.IdProgramaEstudioMatricula = IdProgramaEstudioMatricula;
        this.NombreProgramaEstudioMatricula = NombreProgramaEstudioMatricula;
        this.IdPeriodoLectivoMatricula = IdPeriodoLectivoMatricula;
        this.IdAulaMatricula = IdAulaMatricula;
    }

    public String getIdMatricula() {
        return IdMatricula;
    }

    public void setIdMatricula(String IdMatricula) {
        this.IdMatricula = IdMatricula;
    }

    public String getIdAlumnoMatricula() {
        return IdAlumnoMatricula;
    }

    public void setIdAlumnoMatricula(String IdAlumnoMatricula) {
        this.IdAlumnoMatricula = IdAlumnoMatricula;
    }

    public String getApPaternoMatricula() {
        return ApPaternoMatricula;
    }

    public void setApPaternoMatricula(String ApPaternoMatricula) {
        this.ApPaternoMatricula = ApPaternoMatricula;
    }

    public String getApMaternoMatricula() {
        return ApMaternoMatricula;
    }

    public void setApMaternoMatricula(String ApMaternoMatricula) {
        this.ApMaternoMatricula = ApMaternoMatricula;
    }

    public String getNombresMatricula() {
        return NombresMatricula;
    }

    public void setNombresMatricula(String NombresMatricula) {
        this.NombresMatricula = NombresMatricula;
    }

    public String getIdProgramaEstudioMatricula() {
        return IdProgramaEstudioMatricula;
    }

    public void setIdProgramaEstudioMatricula(String IdProgramaEstudioMatricula) {
        this.IdProgramaEstudioMatricula = IdProgramaEstudioMatricula;
    }

    public String getNombreProgramaEstudioMatricula() {
        return NombreProgramaEstudioMatricula;
    }

    public void setNombreProgramaEstudioMatricula(String NombreProgramaEstudioMatricula) {
        this.NombreProgramaEstudioMatricula = NombreProgramaEstudioMatricula;
    }

    public String getIdPeriodoLectivoMatricula() {
        return IdPeriodoLectivoMatricula;
    }

    public void setIdPeriodoLectivoMatricula(String IdPeriodoLectivoMatricula) {
        this.IdPeriodoLectivoMatricula = IdPeriodoLectivoMatricula;
    }

    public String getIdAulaMatricula() {
        return IdAulaMatricula;
    }

    public void setIdAulaMatricula(String IdAulaMatricula) {
        this.IdAulaMatricula = IdAulaMatricula;
    }
    
    
}
