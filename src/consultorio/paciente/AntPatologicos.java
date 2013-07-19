/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.paciente;

/**
 *
 * @author marin
 */
public class AntPatologicos extends Antecedentes
{
  //
	  // Fields
	  //

	  private boolean diabetes;
	  private boolean hipertension;
	  private boolean tabaquismo;
	  private boolean alcoholismo;
	  private Alergias alergiasPac;
	  
	  //
	  // Constructors
	  //
	  public AntPatologicos () {
          alergiasPac = new Alergias();
          }
	  
	  //
	  // Methods
	  //


	  //
	  // Accessor methods
	  //

	  /**
	   * Set the value of diabetes
	   * @param newVar the new value of diabetes
	   */
	  public void setDiabetes ( boolean newVar ) {
	    diabetes = newVar;
	  }

	  /**
	   * Get the value of diabetes
	   * @return the value of diabetes
	   */
	  public boolean getDiabetes ( ) {
	    return diabetes;
	  }

	  /**
	   * Set the value of hipertension
	   * @param newVar the new value of hipertension
	   */
	  public void setHipertension ( boolean newVar ) {
	    hipertension = newVar;
	  }

	  /**
	   * Get the value of hipertension
	   * @return the value of hipertension
	   */
	  public boolean getHipertension ( ) {
	    return hipertension;
	  }

	  /**
	   * Set the value of tabaquismo
	   * @param newVar the new value of tabaquismo
	   */
	  public void setTabaquismo ( boolean newVar ) {
	    tabaquismo = newVar;
	  }

	  /**
	   * Get the value of tabaquismo
	   * @return the value of tabaquismo
	   */
	  public boolean getTabaquismo ( ) {
	    return tabaquismo;
	  }

	  /**
	   * Set the value of alcoholismo
	   * @param newVar the new value of alcoholismo
	   */
	  public void setAlcoholismo ( boolean newVar ) {
	    alcoholismo = newVar;
	  }

	  /**
	   * Get the value of alcoholismo
	   * @return the value of alcoholismo
	   */
	  public boolean getAlcoholismo ( ) {
	    return alcoholismo;
	  }

	  /**
	   * Set the value of alergiasPac
	   * @param newVar the new value of alergiasPac
	   */
	  public void setAlergiasPac ( Alergias newVar ) {
	    alergiasPac = newVar;
	  }

	  /**
	   * Get the value of alergiasPac
	   * @return the value of alergiasPac
	   */
	  public Alergias getAlergiasPac ( ) {
	    return alergiasPac;
	  }

	  //
	  // Other methods
	  //

  
}
