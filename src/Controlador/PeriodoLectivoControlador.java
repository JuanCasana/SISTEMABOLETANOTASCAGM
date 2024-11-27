package Controlador;

public class PeriodoLectivoControlador {

    private String IdPeriodoLectivo;
    private String AnioPeriodoLectivo;
    private String NumeroPeriodoLectivo;

    public PeriodoLectivoControlador() {
    }

    public PeriodoLectivoControlador(String IdPeriodoLectivo, String AnioPeriodoLectivo, String NumeroPeriodoLectivo) {
        this.IdPeriodoLectivo = IdPeriodoLectivo;
        this.AnioPeriodoLectivo = AnioPeriodoLectivo;
        this.NumeroPeriodoLectivo = NumeroPeriodoLectivo;
    }

    public String getIdPeriodoLectivo() {
        return IdPeriodoLectivo;
    }

    public void setIdPeriodoLectivo(String IdPeriodoLectivo) {
        this.IdPeriodoLectivo = IdPeriodoLectivo;
    }

    public String getAnioPeriodoLectivo() {
        return AnioPeriodoLectivo;
    }

    public void setAnioPeriodoLectivo(String AnioPeriodoLectivo) {
        this.AnioPeriodoLectivo = AnioPeriodoLectivo;
    }

    public String getNumeroPeriodoLectivo() {
        return NumeroPeriodoLectivo;
    }

    public void setNumeroPeriodoLectivo(String NumeroPeriodoLectivo) {
        this.NumeroPeriodoLectivo = NumeroPeriodoLectivo;
    }
    
    
}
