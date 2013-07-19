/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.paciente;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author marin
 */
public class Fecha{
    
    private int dia;
    private int mes;
    private int anio;


    public static final int[] diasMes = //dias por cada mes
     { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
    
    /**M&eacutetodo Constructor <code>Fecha</code> el cual se inicializa sin
     * parametros.
     */
    public Fecha(){};
    
    public Fecha(int dia, int mes, int anio){
        this.anio = validarAnio(anio);
        this.mes = validarMes(mes);
        this.dia = validarDia(dia);
        
        
    }
    
    public String toDDMMAAAA(){
        return String.format("%d/%d/%d", this.getDia(),this.getMes(), this.getAnio());
    }
    
    
        // Methods
    private int validarMes( int varMes )
    {
     //comprobar si el dia esta dentro del rango del mes
          if ( varMes > 0 && varMes <= 12)
              return varMes;
          else
              throw new IllegalArgumentException("El mes se encuentra fuera"
                          + "del rango debe ser de 1 a 12");
    }

    
        public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = validarDia(dia);    
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = validarMes(mes);
        }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = validarAnio(anio);
    }
    
    
    /**
    * M&eacutetodo privado <code>validarDia</code> el cual sirve para validar
    * el la variable dia y no cometer algun error al dar los datos
    * @param varDia
    * @return varDia
    */      
    private int validarDia( int varDia )
    {       
          //comprueba si el dia esta dentro del rango para el dia
          if (varDia > 0 && varDia <= diasMes[mes])
              return varDia;
          //comprueba si el año es bisiesto
          if (mes == 2 && varDia == 29 && ( anio % 400 == 0 || 
                 (anio % 4 == 0 && anio % 100 != 0 )))
              return varDia;

          //si no aprueba lanza una excepcion
          throw new IllegalArgumentException ( "dia fuera de rango pa"
                                    + "ra el mes y anio especificado");
    }
    
    private int validarAnio( int varAnio){
        if (varAnio >= 0){
            return varAnio;
        }else{ 
            throw new IllegalArgumentException("Año Invalido, no puede ser negativo");
        }
    }
    
     /**
      * M&eacutetodo <code>obtenerFechaActual</code> el cual no requiere de
      * ning&uacute;n par&aacute;metro que es para obtener la fecha actual.
      * @return el valor de la fecha actual en formato "dd/MM/YYYY". 
      */
    public String obtenerFechaActual()
    {        
      Date fechaActual = new Date();
      SimpleDateFormat formatoFechaActual = new SimpleDateFormat("dd/MM/yyyy");      
      String fechaHoy = formatoFechaActual.format(fechaActual);
      return fechaHoy;
  
    }
}
