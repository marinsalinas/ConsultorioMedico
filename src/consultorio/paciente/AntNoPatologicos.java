/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.paciente;

/**
 *
 * @author marin
 */
public class AntNoPatologicos extends Antecedentes {
	  //
	 // Fields
	//

	  private String ginecologico;
	  private double peso;
	  private double talla;
	  private String tipoSangre;
	  private double frecCard;
	  private double tensionArt;
	  private double frecResp;
	  
	   //
	  // Constructors
	 //
	  public AntNoPatologicos () { };
	  
	  //
	 // Methods
	//


	   //
	  // Accessor methods
	 //

	  /**
	   * Set the value of ginecologico
	   * @param newVar the new value of ginecologico
	   */
	  public void setGinecologico ( String newVar ) {
	    ginecologico = newVar;
	  }

	  /**
	   * Get the value of ginecologico
	   * @return the value of ginecologico
	   */
	  public String getGinecologico ( ) {
	    return ginecologico;
	  }

	  /**
	   * Set the value of peso
	   * @param newVar the new value of peso
	   */
	  public void setPeso ( double newVar ) {
	    peso = newVar;
	  }

	  /**
	   * Get the value of peso
	   * @return the value of peso
	   */
	  public double getPeso ( ) {
	    return peso;
	  }

	  /**
	   * Set the value of talla
	   * @param newVar the new value of talla
	   */
	  public void setTalla ( double newVar ) {
	    talla = newVar;
	  }

	  /**
	   * Get the value of talla
	   * @return the value of talla
	   */
	  public double getTalla ( ) {
	    return talla;
	  }

	  /**
	   * Set the value of tipoSangre
	   * @param newVar the new value of tipoSangre
	   */
	  public void setTipoSangre ( String newVar ) {
	    tipoSangre = newVar;
	  }

	  /**
	   * Get the value of tipoSangre
	   * @return the value of tipoSangre
	   */
	  public String getTipoSangre ( ) {
	    return tipoSangre;
	  }

	  /**
	   * Set the value of frecCard
	   * @param newVar the new value of frecCard
	   */
	  public void setFrecCard ( double newVar ) {
	    frecCard = newVar;
	  }

	  /**
	   * Get the value of frecCard
	   * @return the value of frecCard
	   */
	  public double getFrecCard ( ) {
	    return frecCard;
	  }

	  /**
	   * Set the value of tensionArt
	   * @param newVar the new value of tensionArt
	   */
	  public void setTensionArt ( double newVar ) {
	    tensionArt = newVar;
	  }

	  /**
	   * Get the value of tensionArt
	   * @return the value of tensionArt
	   */
	  public double getTensionArt ( ) {
	    return tensionArt;
	  }

	  /**
	   * Set the value of frecResp
	   * @param newVar the new value of frecResp
	   */
	  public void setFrecResp (double newVar ) {
	    frecResp = newVar;
	  }

	  /**
	   * Get the value of frecResp
	   * @return the value of frecResp
	   */
	  public double getFrecResp ( ) {
	    return frecResp;
	  }

	   //
	  // Other methods
	 //
    
}
