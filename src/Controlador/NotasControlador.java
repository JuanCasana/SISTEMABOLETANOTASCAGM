package Controlador;

public class NotasControlador {
    private int IdNota;
    private String IdMatricula;
    private String IdUnidadDidactica;
    private String UnidadDidactica;
    private int nota;
    private String FechaRegistro;

    public NotasControlador() {
    }

    public NotasControlador(int IdNota, String IdMatricula, String IdUnidadDidactica, String UnidadDidactica, int nota, String FechaRegistro) {
        this.IdNota = IdNota;
        this.IdMatricula = IdMatricula;
        this.IdUnidadDidactica = IdUnidadDidactica;
        this.UnidadDidactica = UnidadDidactica;
        this.nota = nota;
        this.FechaRegistro = FechaRegistro;
    }

    public int getIdNota() {
        return IdNota;
    }

    public void setIdNota(int IdNota) {
        this.IdNota = IdNota;
    }

    public String getIdMatricula() {
        return IdMatricula;
    }

    public void setIdMatricula(String IdMatricula) {
        this.IdMatricula = IdMatricula;
    }

    public String getIdUnidadDidactica() {
        return IdUnidadDidactica;
    }

    public void setIdUnidadDidactica(String IdUnidadDidactica) {
        this.IdUnidadDidactica = IdUnidadDidactica;
    }

    public String getUnidadDidactica() {
        return UnidadDidactica;
    }

    public void setUnidadDidactica(String UnidadDidactica) {
        this.UnidadDidactica = UnidadDidactica;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    
}
