/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.paciente;

/**
 *
 * @author marin
 */
public class Historial {
    
    public Historial(){
    fechaActual = new Fecha();
    seguimiento = new Fecha();
    };
    
    private long id_paciente;
    private Fecha fechaActual;
    private String padActual;
    private String exLab;
    private String exImg;
    private String tratamiento;
    private String comentarios;
    private Fecha seguimiento;

    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Fecha getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Fecha fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getPadActual() {
        return padActual;
    }

    public void setPadActual(String padActual) {
        this.padActual = padActual;
    }

    public String getExLab() {
        return exLab;
    }

    public void setExLab(String exLab) {
        this.exLab = exLab;
    }

    public String getExImg() {
        return exImg;
    }

    public void setExImg(String exImg) {
        this.exImg = exImg;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Fecha getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Fecha seguimiento) {
        this.seguimiento = seguimiento;
    }
    
    
    
}
