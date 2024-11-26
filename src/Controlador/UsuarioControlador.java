/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Yoana
 */
public class UsuarioControlador {
    private int IdUsuario;
    private String DniUsuario;
    private String ApPaternoUsuario;
    private String ApMaternoUsuario;
    private String NombresUsuario;
    private String EmailUsuario;
    private String CelularUsuario;
    private String ContraseñaUsuario;
    private String NivelAccesoUsuario;
    private char EstadoUsuario; 

    
    public UsuarioControlador() {
    }

    public UsuarioControlador(int IdUsuario, String DniUsuario, String ApPaternoUsuario, String ApMaternoUsuario, String NombresUsuario, String EmailUsuario, String CelularUsuario, String ContraseñaUsuario, String NivelAccesoUsuario, char EstadoUsuario) {
        this.IdUsuario = IdUsuario;
        this.DniUsuario = DniUsuario;
        this.ApPaternoUsuario = ApPaternoUsuario;
        this.ApMaternoUsuario = ApMaternoUsuario;
        this.NombresUsuario = NombresUsuario;
        this.EmailUsuario = EmailUsuario;
        this.CelularUsuario = CelularUsuario;
        this.ContraseñaUsuario = ContraseñaUsuario;
        this.NivelAccesoUsuario = NivelAccesoUsuario;
        this.EstadoUsuario = EstadoUsuario;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getDniUsuario() {
        return DniUsuario;
    }

    public void setDniUsuario(String DniUsuario) {
        this.DniUsuario = DniUsuario;
    }

    public String getApPaternoUsuario() {
        return ApPaternoUsuario;
    }

    public void setApPaternoUsuario(String ApPaternoUsuario) {
        this.ApPaternoUsuario = ApPaternoUsuario;
    }

    public String getApMaternoUsuario() {
        return ApMaternoUsuario;
    }

    public void setApMaternoUsuario(String ApMaternoUsuario) {
        this.ApMaternoUsuario = ApMaternoUsuario;
    }

    public String getNombresUsuario() {
        return NombresUsuario;
    }

    public void setNombresUsuario(String NombresUsuario) {
        this.NombresUsuario = NombresUsuario;
    }

    public String getEmailUsuario() {
        return EmailUsuario;
    }

    public void setEmailUsuario(String EmailUsuario) {
        this.EmailUsuario = EmailUsuario;
    }

    public String getCelularUsuario() {
        return CelularUsuario;
    }

    public void setCelularUsuario(String CelularUsuario) {
        this.CelularUsuario = CelularUsuario;
    }

    public String getContraseñaUsuario() {
        return ContraseñaUsuario;
    }

    public void setContraseñaUsuario(String ContraseñaUsuario) {
        this.ContraseñaUsuario = ContraseñaUsuario;
    }

    public String getNivelAccesoUsuario() {
        return NivelAccesoUsuario;
    }

    public void setNivelAccesoUsuario(String NivelAccesoUsuario) {
        this.NivelAccesoUsuario = NivelAccesoUsuario;
    }

    public char getEstadoUsuario() {
        return EstadoUsuario;
    }

    public void setEstadoUsuario(char EstadoUsuario) {
        this.EstadoUsuario = EstadoUsuario;
    }
    
    
}
