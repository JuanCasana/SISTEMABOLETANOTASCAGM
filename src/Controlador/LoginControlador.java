
package Controlador;

public class LoginControlador {
    private int IdUsuario;
    private String Dni;
    private String ApPaterno;
    private String ApMAterno;
    private String Contrasenea;

    public LoginControlador() {
    }

    public LoginControlador(int IdUsuario, String Dni, String ApPaterno, String ApMAterno, String Contrasenea) {
        this.IdUsuario = IdUsuario;
        this.Dni = Dni;
        this.ApPaterno = ApPaterno;
        this.ApMAterno = ApMAterno;
        this.Contrasenea = Contrasenea;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String ApPaterno) {
        this.ApPaterno = ApPaterno;
    }

    public String getApMAterno() {
        return ApMAterno;
    }

    public void setApMAterno(String ApMAterno) {
        this.ApMAterno = ApMAterno;
    }

    public String getContrasenea() {
        return Contrasenea;
    }

    public void setContrasenea(String Contrasenea) {
        this.Contrasenea = Contrasenea;
    }
    
    
}
