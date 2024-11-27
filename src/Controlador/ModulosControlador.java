package Controlador;

public class ModulosControlador {
    
    private String IdModulo;
    private String NombreModulo;
    private String IdProgramaEstudios;

    public ModulosControlador() {
    }

    public ModulosControlador(String IdModulo, String NombreModulo, String IdProgramaEstudios) {
        this.IdModulo = IdModulo;
        this.NombreModulo = NombreModulo;
        this.IdProgramaEstudios = IdProgramaEstudios;
    }

    public String getIdModulo() {
        return IdModulo;
    }

    public void setIdModulo(String IdModulo) {
        this.IdModulo = IdModulo;
    }

    public String getNombreModulo() {
        return NombreModulo;
    }

    public void setNombreModulo(String NombreModulo) {
        this.NombreModulo = NombreModulo;
    }

    public String getIdProgramaEstudios() {
        return IdProgramaEstudios;
    }

    public void setIdProgramaEstudios(String IdProgramaEstudios) {
        this.IdProgramaEstudios = IdProgramaEstudios;
    }

        
}
