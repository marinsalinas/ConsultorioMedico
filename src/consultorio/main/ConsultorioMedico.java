package consultorio.main;

import consultorio.gui.Login;


 /**
 * Clase Principal el cual correra la Aplicaci&oacuten MediHist del
 * proyecto llamado <code>ConsultorioMedico</code>.
 * @author marin
 * @version 0.1
 * @since 20/03/2013
 */
public class ConsultorioMedico {
	/**
	 * @param args
         * */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
            
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultorioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            Login main = new Login();
            main.setLocationRelativeTo(null);
            main.setVisible(true);            
            
        }//fin metodo main
}//fin de la clase ConsultorioMedico
