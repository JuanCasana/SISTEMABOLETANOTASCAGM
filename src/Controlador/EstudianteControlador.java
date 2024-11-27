package Controlador;

public class EstudianteControlador {
    private String IdAlumno;
    private String DniAlumno;
    private String ApPaternoAlumno;
    private String ApMaternoAlumno;
    private String NombresAlumno;
    private String EmailAlumno;
    private String CelularAlumno;
    private String AneoIngresoAlumno;
    private String SexoAlumno;

    public EstudianteControlador() {
    }

    public EstudianteControlador(String IdAlumno, String DniAlumno, String ApPaternoAlumno, String ApMaternoAlumno, String NombresAlumno, String EmailAlumno, String CelularAlumno, String AneoIngresoAlumno, String Sexo) {
        this.IdAlumno = IdAlumno;
        this.DniAlumno = DniAlumno;
        this.ApPaternoAlumno = ApPaternoAlumno;
        this.ApMaternoAlumno = ApMaternoAlumno;
        this.NombresAlumno = NombresAlumno;
        this.EmailAlumno = EmailAlumno;
        this.CelularAlumno = CelularAlumno;
        this.AneoIngresoAlumno = AneoIngresoAlumno;
        this.SexoAlumno = Sexo;
    }

    public String getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(String IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public String getDniAlumno() {
        return DniAlumno;
    }

    public void setDniAlumno(String DniAlumno) {
        this.DniAlumno = DniAlumno;
    }

    public String getApPaternoAlumno() {
        return ApPaternoAlumno;
    }

    public void setApPaternoAlumno(String ApPaternoAlumno) {
        this.ApPaternoAlumno = ApPaternoAlumno;
    }

    public String getApMaternoAlumno() {
        return ApMaternoAlumno;
    }

    public void setApMaternoAlumno(String ApMaternoAlumno) {
        this.ApMaternoAlumno = ApMaternoAlumno;
    }

    public String getNombresAlumno() {
        return NombresAlumno;
    }

    public void setNombresAlumno(String NombresAlumno) {
        this.NombresAlumno = NombresAlumno;
    }

    public String getEmailAlumno() {
        return EmailAlumno;
    }

    public void setEmailAlumno(String EmailAlumno) {
        this.EmailAlumno = EmailAlumno;
    }

    public String getCelularAlumno() {
        return CelularAlumno;
    }

    public void setCelularAlumno(String CelularAlumno) {
        this.CelularAlumno = CelularAlumno;
    }

    public String getAneoIngresoAlumno() {
        return AneoIngresoAlumno;
    }

    public void setAneoIngresoAlumno(String AneoIngresoAlumno) {
        this.AneoIngresoAlumno = AneoIngresoAlumno;
    }

    public String getSexoAlumno() {
        return SexoAlumno;
    }

    public void setSexoAlumno(String Sexo) {
        this.SexoAlumno = Sexo;
    }   
}