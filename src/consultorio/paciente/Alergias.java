/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.paciente;

/**
 *
 * @author marin
 */
public class Alergias {
//
	  // Fields
	  //

	  private String sustancias;
	  private String medicamento;
	  private String alimentos;
	  private String otra;
	  //
	  // Constructors
	  //
	  public Alergias () { };
	  
	  //
	  // Methods
	  //


	  //
	  // Accessor methods
	  //

          /**
           * Establece el valor de otra, que se refiere a otro tipo de alergia
           * @param otraAlergia el nuevo valor de otra
           */          
          public void setOtra( String otraAlergia )
          {      
              otra = otraAlergia;
          }
          
          /**
           * Obtiene el valor de otra, que se refiere a otro tipo de alergia
           * @return el valor de otra 
           */
          public String getOtra(){
              return otra;
          }
          
          
	  /**
	   * Set the value of sustancias
	   * @param newVar the new value of sustancias
	   */
	  public void setSustancias ( String newVar ) {
	    sustancias = newVar;
	  }

	  /**
	   * Get the value of sustancias
	   * @return the value of sustancias
	   */
	  public String getSustancias ( ) {
	    return sustancias;
	  }

	  /**
	   * Set the value of medicamento
	   * @param newVar the new value of medicamento
	   */
	  public void setMedicamento ( String newVar ) {
	    medicamento = newVar;
	  }

	  /**
	   * Get the value of medicamento
	   * @return the value of medicamento
	   */
	  public String getMedicamento ( ) {
	    return medicamento;
	  }

	  /**
	   * Set the value of alimentos
	   * @param newVar the new value of alimentos
	   */
	  public void setAlimentos ( String newVar ) {
	    alimentos = newVar;
	  }

	  /**
	   * Get the value of alimentos
	   * @return the value of alimentos
	   */
	  public String getAlimentos ( ) {
	    return alimentos;
	  }

	  //
	  // Other methods
	  //    
}
