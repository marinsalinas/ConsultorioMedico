/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.paciente;

import javax.swing.JOptionPane;

/**
 * Clase <code>FechaNac</code> la cual tiene una superclase llamada Fecha
 * de la cual obtiene el m&eacutetodo <code>obtenerFechaActual</code> que le
 * sirve para calcular la edad actual.
 * @author marin
 */
public class FechaNac extends Fecha
{ 
          
  /**M&eacutetodo constructor el cual no recibe ningun parametro.
   */
 public FechaNac(){};
	 
          
 /**
  * M&eacutetodo constructor el cual recibe como parametros para dia
  * mes y a&ntildeo.
  * @param d
  * @param m
  * @param a 
  */
 public FechaNac (int d, int m, int a)
 {
     super(a, m, a);
    /*super.setAnio(d);
    super.setMes(m);
    super.setDia(a);*/
 }
          
 // Accessor methods
  /**
   * Establece el Valor de dia
   * @param newVar es el nuevo valor de dia
   */
 @Override
 public void setDia ( int newVar )
 {
    super.setDia(newVar);
 }

 /**
  * Obtiene el Valor del dia
  * @return el valor de dia
  */
 @Override
 public int getDia ( ) {
   return super.getDia();
  }

  /**
   * Set the value of mes
   * @param newVar the new value of mes
   */
 @Override
 public void setMes ( int newVar ) {
    super.setMes(newVar);
  }

 /**
  * Get the value of mes
  * @return the value of mes
  */
  public int getMes ( ) {
    return super.getMes();
  }

  /**
   * Set the value of anio
   * @param newVar the new value of anio
   */
 @Override
  public void setAnio ( int newVar ) {
    super.setAnio(newVar);
  }

  /**
   * Get the value of anio
   * @return the value of anio
   */
  public int getAnio ( ) {
    return super.getAnio();
  }

          
	  //Otros Metodos
  @Override       
  public String toString(){     
      return String.format("%d/%d/%d",super.getDia(),super.getMes(),super.getAnio());          
  }
	  
  /**
   * M&eacutetodo que calcula la Edad actual o bien los años que han
   * transcurrido desde FechaNac utiliza el m&eacutetodo
   * <code> toString();</code> para obtener el formato de "dd/MM/yyy"
   * requerido para hacer el calculo de la edad
   * @return anos
   */
  public int obtenerEdad()
  {        
      String fechaNac = this.toString();
      String hoy = super.obtenerFechaActual();
      //String hoy = formatoFecha.format(fechaHoy);
      String[] datosNac = fechaNac.split("/");//guarda en cada indice lo que esta entre el caracter "/" 
      String[] datosHoy = hoy.split("/"); 
      
      //Convierte los indices de los arreglos en Int y los resta cada uno 
      //para posterior obtener la edad
      int anos = Integer.parseInt(datosHoy[2]) - Integer.parseInt(datosNac[2]);
      int m = Integer.parseInt(datosHoy[1]) - Integer.parseInt(datosNac[1]);
	
      if ( m < 0){
          anos = anos -1;
      }else if ( m == 0){
          //se utiliza solo si cumple en el mismo mes
          int d = Integer.parseInt(datosHoy[0]) - Integer.parseInt(datosNac[0]);
          if (d < 0){
              anos = anos - 1;
          }
      }
      return anos;
  }
  
  public static void main( String[] args){
   String dia = JOptionPane.showInputDialog(null, "Introduzca el dia de nacimeinto", "PruebaFechaNac", JOptionPane.PLAIN_MESSAGE);
   String mes = JOptionPane.showInputDialog(null, "Introduzca el mes de nacumuento", "PruebaFechaNac", JOptionPane.PLAIN_MESSAGE);
   String anio = JOptionPane.showInputDialog(null, "Introduzca su año de naciento", "PruebaFechaNac", JOptionPane.PLAIN_MESSAGE);
   JOptionPane.showMessageDialog(null, "La Fecha de Nacimiento es: "+Integer.parseInt(dia)+"/"+Integer.parseInt(mes)+"/"+Integer.parseInt(anio),"PruebaFechaNac", JOptionPane.PLAIN_MESSAGE);
   //Demostrando Herencia con su contructor
   FechaNac nac = new FechaNac();
   nac.setAnio(Integer.parseInt(anio));
   nac.setMes(Integer.parseInt(mes));
   nac.setDia(Integer.parseInt(dia));
   int edad = nac.obtenerEdad();
   String fechaactual= nac.obtenerFechaActual();
   JOptionPane.showMessageDialog(null, "La Fecha Actual es:"+fechaactual, "PruebaFechaNac", JOptionPane.PLAIN_MESSAGE);
   JOptionPane.showMessageDialog(null, "LA edad del que ingreso es: "+edad, "PruebaFechaNac", JOptionPane.PLAIN_MESSAGE);
  }
}
