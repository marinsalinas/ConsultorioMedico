package consultorio.paciente;

/**
 *
 * @author marin
 */
public class Paciente {
          //Atributos
	  private static int idPac = 0;
	  private String nombrePac;
	  private String apellidoPac1;
          private String apellidoPac2;
	  private boolean sexoPac;
	  private String estadoCivPac;
	  private String ocupacionPac;
	  private long telefono;
	  private long celular;
	  private String email;
	  private AntPatologicos antPatPac;
	  private AntNoPatologicos antNoPatPac;
	  private FechaNac nacimiento;
	 
          /**
	   M&eacutetodo constructor de Paciente el cual no recibe parametros
	  */
	  public Paciente (){
              this.antPatPac = new AntPatologicos();//this recomendable
              this.antNoPatPac = new AntNoPatologicos();
              this.nacimiento = new FechaNac();
              idPac++;
          }

	  // Methods
        
	  // Accessor methods

	  /**
	   * Establece el Valor de idPac
	   * @param newVar es el nuevo valor idPac
	   */
	  public void setIdPac ( int newVar ) {
	    idPac = newVar;
	  }

	  /**
	   * Obtiene el Valor de idPac
	   * @return el valor de idPac
	   */
	  public int getIdPac ( ) {
	    return idPac;
	  }

	  /**
	   * Set the value of nombrePac
	   * @param newVar the new value of nombrePac
	   */
	  public void setNombrePac ( String newVar ) {
	    nombrePac = newVar;
	  }

	  /**
	   * Get the value of nombrePac
	   * @return the value of nombrePac
	   */
	  public String getNombrePac ( ) {
	    return nombrePac;
	  }

	  /**
	   * Set the value of apellidoPac
	   * @param newVar the new value of apellidoPac
	   */
	  public void setApellidoPac1 ( String newVar ) {
	    apellidoPac1 = newVar;
	  }

	  /**
	   * Get the value of apellidoPac
	   * @return the value of apellidoPac
	   */
	  public String getApellidoPac1 ( ) {
	    return apellidoPac1;
	  }

            /**
	   * Set the value of apellidoPac
	   * @param newVar the new value of apellidoPac
	   */
	  public void setApellidoPac2 ( String newVar ) {
	    apellidoPac2 = newVar;
	  }

	  /**
	   * Get the value of apellidoPac
	   * @return the value of apellidoPac
	   */
	  public String getApellidoPac2 ( ) {
	    return apellidoPac2;
	  }
          
	  /**
	   * Set the value of sexoPac
	   * @param newVar the new value of sexoPac
	   */
	  public void setSexoPac ( boolean newVar ) {
	    sexoPac = newVar;
	  }

	  /**
	   * Get the value of sexoPac
	   * @return the value of sexoPac
	   */
	  public boolean getSexoPac ( ) {
	    return sexoPac;
	  }

	  /**
	   * Set the value of estadoCivPac
	   * @param newVar the new value of estadoCivPac
	   */
	  public void setEstadoCivPac ( String newVar ) {
	    estadoCivPac = newVar;
	  }

	  /**
	   * Get the value of estadoCivPac
	   * @return the value of estadoCivPac
	   */
	  public String getEstadoCivPac ( ) {
	    return estadoCivPac;
	  }

	  /**
	   * Set the value of ocupacionPac
	   * @param newVar the new value of ocupacionPac
	   */
	  public void setOcupacionPac ( String newVar ) {
	    ocupacionPac = newVar;
	  }

	  /**
	   * Get the value of ocupacionPac
	   * @return the value of ocupacionPac
	   */
	  public String getOcupacionPac ( ) {
	    return ocupacionPac;
	  }

	  /**
	   * Set the value of telefono
	   * @param newVar the new value of telefono
	   */
	  public void setTelefono ( long newVar ) {
              telefono = newVar;
	  }

	  /**
	   * Get the value of telefono
	   * @return the value of telefono
	   */
	  public long getTelefono ( ) {
	    return telefono;
	  }

	  /**
	   * Set the value of celular
	   * @param newVar the new value of celular
	   */
	  public void setCelular ( long newVar ) {
	    celular = newVar;
	  }

	  /**
	   * Get the value of celular
	   * @return the value of celular
	   */
	  public long getCelular ( ) {
	    return celular;
	  }

	  /**
	   * Set the value of email
	   * @param newVar the new value of email
	   */
	  public void setEmail ( String newVar ) {
	    email = newVar;
	  }

	  /**
	   * Get the value of email
	   * @return the value of email
	   */
	  public String getEmail ( ) {
	    return email;
	  }

	  /**
	   * Establece los valor del objeto nacimiento
	   * @param day es el nuevo valor de dia
           * @param month es el nuevo valor de mes
           * @param year es el nuevo valor del año
	   */
          public void setNacimiento ( int day, int month, int year)
          {   
              nacimiento.setMes(month);
              nacimiento.setAnio(year);
              nacimiento.setDia(day);
          }

	  /**
	   * Obtiene el valor de nacimiento
	   * @return el valor de nacimiento
	   */
          public FechaNac getNacimiento(){
             return nacimiento;//regresa el objeto completo
          }

	  /**
	   * Set the value of antPatPac
	   * @param newVar the new value of antPatPac
	   */
	  public void setAntPatPac ( AntPatologicos newVar ) {
	    antPatPac = newVar;
	  }

	  /**
	   * Get the value of antPatPac
	   * @return the value of antPatPac
	   */
	  public AntPatologicos getAntPatPac ( ) {
	    return antPatPac;
	  }

	  /**
	   * Set the value of antNoPatPac
	   * @param newVar the new value of antNoPatPac
	   */
	  public void setAntNoPatPac ( AntNoPatologicos newVar ) {
	    antNoPatPac = newVar;
	  }

	  /**
	   * Get the value of antNoPatPac
	   * @return the value of antNoPatPac
	   */
	  public AntNoPatologicos getAntNoPatPac ( ) {
	    return antNoPatPac;
	  }
          
	  // Other methods
}
