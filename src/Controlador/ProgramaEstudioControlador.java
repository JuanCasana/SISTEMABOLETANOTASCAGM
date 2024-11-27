package Controlador;

public class ProgramaEstudioControlador {
    private String IdProgramaEstudio;
    private String ProgramaEstudio;
    private String CantModulos;

    public ProgramaEstudioControlador() {
    }

    public ProgramaEstudioControlador(String IdProgramaEstudios, String ProgramaEstudio, String CantModulos) {
        this.IdProgramaEstudio = IdProgramaEstudios;
        this.ProgramaEstudio = ProgramaEstudio;
        this.CantModulos = CantModulos;
    }

    public String getIdProgramaEstudio() {
        return IdProgramaEstudio;
    }

    public void setIdProgramaEstudio(String IdProgramaEstudios) {
        this.IdProgramaEstudio = IdProgramaEstudios;
    }

    public String getProgramaEstudio() {
        return ProgramaEstudio;
    }

    public void setProgramaEstudio(String ProgramaEstudio) {
        this.ProgramaEstudio = ProgramaEstudio;
    }

    public String getCantModulos() {
        return CantModulos;
    }

    public void setCantModulos(String CantModulos) {
        this.CantModulos = CantModulos;
    }
    
    
    
}
