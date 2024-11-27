package Controlador;

public class BoletaNotasControlador {

    private String Dni;
    private String IdAlumnoBN;
    private String IdMatriculaBN;
    private String NombreProgramaEstudioBN;
    private String IdPeriodoAcademicoBN;
    private String NombreCompletoBN;

    private String correlativo;
    private String DniNotaBN;
    private String NombreUDBN;
    private String CreditoUDBN;
    private String NotasUDBN;
    private String PerioLectiBN;

    private String TotalCreditosDesemBN;
    private String CreditosAprobadosDesemBN;
    private String CreditosDesaprobadosDesemBN;
    private String PromedioGeneralDesemBN;
    private String PuntajeTotalDesemBN;
    private String OrdenMeritoDesemBN;

   
    public BoletaNotasControlador() {
    }

    public BoletaNotasControlador(String Dni, String IdAlumnoBN, String IdMatriculaBN, String NombreProgramaEstudioBN, String IdPeriodoAcademicoBN, String NombreCompletoBN, String correlativo, String DniNotaBN, String NombreUDBN, String CreditoUDBN, String NotasUDBN, String PerioLectiBN, String TotalCreditosDesemBN, String CreditosAprobadosDesemBN, String CreditosDesaprobadosDesemBN, String PromedioGeneralDesemBN, String PuntajeTotalDesemBN, String OrdenMeritoDesemBN) {
        this.Dni = Dni;
        this.IdAlumnoBN = IdAlumnoBN;
        this.IdMatriculaBN = IdMatriculaBN;
        this.NombreProgramaEstudioBN = NombreProgramaEstudioBN;
        this.IdPeriodoAcademicoBN = IdPeriodoAcademicoBN;
        this.NombreCompletoBN = NombreCompletoBN;
        this.correlativo = correlativo;
        this.DniNotaBN = DniNotaBN;
        this.NombreUDBN = NombreUDBN;
        this.CreditoUDBN = CreditoUDBN;
        this.NotasUDBN = NotasUDBN;
        this.PerioLectiBN = PerioLectiBN;
        this.TotalCreditosDesemBN = TotalCreditosDesemBN;
        this.CreditosAprobadosDesemBN = CreditosAprobadosDesemBN;
        this.CreditosDesaprobadosDesemBN = CreditosDesaprobadosDesemBN;
        this.PromedioGeneralDesemBN = PromedioGeneralDesemBN;
        this.PuntajeTotalDesemBN = PuntajeTotalDesemBN;
        this.OrdenMeritoDesemBN = OrdenMeritoDesemBN;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getIdAlumnoBN() {
        return IdAlumnoBN;
    }

    public void setIdAlumnoBN(String IdAlumnoBN) {
        this.IdAlumnoBN = IdAlumnoBN;
    }

    public String getIdMatriculaBN() {
        return IdMatriculaBN;
    }

    public void setIdMatriculaBN(String IdMatriculaBN) {
        this.IdMatriculaBN = IdMatriculaBN;
    }

    public String getNombreProgramaEstudioBN() {
        return NombreProgramaEstudioBN;
    }

    public void setNombreProgramaEstudioBN(String NombreProgramaEstudioBN) {
        this.NombreProgramaEstudioBN = NombreProgramaEstudioBN;
    }

    public String getIdPeriodoAcademicoBN() {
        return IdPeriodoAcademicoBN;
    }

    public void setIdPeriodoAcademicoBN(String IdPeriodoAcademicoBN) {
        this.IdPeriodoAcademicoBN = IdPeriodoAcademicoBN;
    }

    public String getNombreCompletoBN() {
        return NombreCompletoBN;
    }

    public void setNombreCompletoBN(String NombreCompletoBN) {
        this.NombreCompletoBN = NombreCompletoBN;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getDniNotaBN() {
        return DniNotaBN;
    }

    public void setDniNotaBN(String DniNotaBN) {
        this.DniNotaBN = DniNotaBN;
    }

    public String getNombreUDBN() {
        return NombreUDBN;
    }

    public void setNombreUDBN(String NombreUDBN) {
        this.NombreUDBN = NombreUDBN;
    }

    public String getCreditoUDBN() {
        return CreditoUDBN;
    }

    public void setCreditoUDBN(String CreditoUDBN) {
        this.CreditoUDBN = CreditoUDBN;
    }

    public String getNotasUDBN() {
        return NotasUDBN;
    }

    public void setNotasUDBN(String NotasUDBN) {
        this.NotasUDBN = NotasUDBN;
    }

    public String getPerioLectiBN() {
        return PerioLectiBN;
    }

    public void setPerioLectiBN(String PerioLectiBN) {
        this.PerioLectiBN = PerioLectiBN;
    }

    public String getTotalCreditosDesemBN() {
        return TotalCreditosDesemBN;
    }

    public void setTotalCreditosDesemBN(String TotalCreditosDesemBN) {
        this.TotalCreditosDesemBN = TotalCreditosDesemBN;
    }

    public String getCreditosAprobadosDesemBN() {
        return CreditosAprobadosDesemBN;
    }

    public void setCreditosAprobadosDesemBN(String CreditosAprobadosDesemBN) {
        this.CreditosAprobadosDesemBN = CreditosAprobadosDesemBN;
    }

    public String getCreditosDesaprobadosDesemBN() {
        return CreditosDesaprobadosDesemBN;
    }

    public void setCreditosDesaprobadosDesemBN(String CreditosDesaprobadosDesemBN) {
        this.CreditosDesaprobadosDesemBN = CreditosDesaprobadosDesemBN;
    }

    public String getPromedioGeneralDesemBN() {
        return PromedioGeneralDesemBN;
    }

    public void setPromedioGeneralDesemBN(String PromedioGeneralDesemBN) {
        this.PromedioGeneralDesemBN = PromedioGeneralDesemBN;
    }

    public String getPuntajeTotalDesemBN() {
        return PuntajeTotalDesemBN;
    }

    public void setPuntajeTotalDesemBN(String PuntajeTotalDesemBN) {
        this.PuntajeTotalDesemBN = PuntajeTotalDesemBN;
    }

    public String getOrdenMeritoDesemBN() {
        return OrdenMeritoDesemBN;
    }

    public void setOrdenMeritoDesemBN(String OrdenMeritoDesemBN) {
        this.OrdenMeritoDesemBN = OrdenMeritoDesemBN;
    }

}
