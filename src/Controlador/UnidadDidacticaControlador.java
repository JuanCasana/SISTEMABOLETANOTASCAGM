package Controlador;

public class UnidadDidacticaControlador {
  
    private String IdUnidadDidactica;
    private String NombreUnidadDidactica;
    private String HorasUnidadDidactica;
    private String CreditosUnidadDidactica;
    private String IdProgramaEstudios;
    private String IdModulo;

    public UnidadDidacticaControlador() {
    }

    public UnidadDidacticaControlador(String IdUnidadDidactica, String NombreUnidadDidactica, String HorasUnidadDidactica, String CreditosUnidadDidactica, String IdProgramaEstudios, String IdModulo) {
        this.IdUnidadDidactica = IdUnidadDidactica;
        this.NombreUnidadDidactica = NombreUnidadDidactica;
        this.HorasUnidadDidactica = HorasUnidadDidactica;
        this.CreditosUnidadDidactica = CreditosUnidadDidactica;
        this.IdProgramaEstudios = IdProgramaEstudios;
        this.IdModulo = IdModulo;
    }

    public String getIdUnidadDidactica() {
        return IdUnidadDidactica;
    }

    public void setIdUnidadDidactica(String IdUnidadDidactica) {
        this.IdUnidadDidactica = IdUnidadDidactica;
    }

    public String getNombreUnidadDidactica() {
        return NombreUnidadDidactica;
    }

    public void setNombreUnidadDidactica(String NombreUnidadDidactica) {
        this.NombreUnidadDidactica = NombreUnidadDidactica;
    }

    public String getHorasUnidadDidactica() {
        return HorasUnidadDidactica;
    }

    public void setHorasUnidadDidactica(String HorasUnidadDidactica) {
        this.HorasUnidadDidactica = HorasUnidadDidactica;
    }

    public String getCreditosUnidadDidactica() {
        return CreditosUnidadDidactica;
    }

    public void setCreditosUnidadDidactica(String CreditosUnidadDidactica) {
        this.CreditosUnidadDidactica = CreditosUnidadDidactica;
    }

    public String getIdProgramaEstudios() {
        return IdProgramaEstudios;
    }

    public void setIdProgramaEstudios(String IdProgramaEstudios) {
        this.IdProgramaEstudios = IdProgramaEstudios;
    }

    public String getIdModulo() {
        return IdModulo;
    }

    public void setIdModulo(String IdModulo) {
        this.IdModulo = IdModulo;
    }
    
    
}
