/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.basededatos;
import consultorio.paciente.Historial;
import consultorio.paciente.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marin
 */
public class ConexionDB {
    
    /**
     *Constructor de la Clase <code>ConexionDB</code>.
     */
    public ConexionDB(){}
    
    
    /**
     * M&eacutetodo <code>conectarDB</code>. 
     */
    public static Connection conectarBD ()
    {
        Connection link = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado con la Base de Datos de MySQL");
            link = DriverManager.getConnection("jdbc:mysql://localhost:3306/Consultorio",
				"root", "salinass27_");
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null, e, "ERROR de MySQL", JOptionPane.ERROR_MESSAGE);
	}catch (Exception e){
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado", JOptionPane.ERROR_MESSAGE);
        } 
        return link;
    }
    
    public static void altaPac(Paciente pac)
    {
         PreparedStatement smt = null;
         Connection con = ConexionDB.conectarBD();
         String query = "INSERT INTO paciente (id,nombre, apellido1, apellido2, sexo, estadoCivil, ocupacion,"
                 + "telefono, movil, email, FechaNac, edad)"
                 + "VALUES (null,?,?,?,?,?,?,?,?,?,?,?)";
         try{
           smt = con.prepareStatement(query);
           smt.setString(1, pac.getNombrePac());
           smt.setString(2, pac.getApellidoPac1());
           smt.setString(3, pac.getApellidoPac2());
           smt.setBoolean(4, pac.getSexoPac());
           smt.setString(5, pac.getEstadoCivPac());
           smt.setString(6, pac.getOcupacionPac());
           smt.setLong(7, pac.getTelefono());
           smt.setLong(8, pac.getCelular());
           smt.setString(9, pac.getEmail());
           smt.setString(10, pac.getNacimiento().toString());
           smt.setInt(11, pac.getNacimiento().obtenerEdad());
           smt.execute();
           System.out.println("Si salio");
            JOptionPane.showMessageDialog(null, "Se agrego el paciente satisfactoriamente",
                    "Consultorio", JOptionPane.PLAIN_MESSAGE);
            con.close();
            smt.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado", JOptionPane.ERROR_MESSAGE);
        }
         //return resultado;
    }
    
    public static void altaPatologicos(Paciente pac, int id_pac)
    {
         PreparedStatement smt = null;
         Connection con = ConexionDB.conectarBD();
         String query = "INSERT INTO patologicos (id_paciente,diabetes, hipertension, tabaquismo, "
                 + "alcoholismo, otroPat, alergiaMed, alergiaSus, alergiaAl, otraAlergia)"
                 + "VALUES (?,?,?,?,?,?,?,?,?,?)";
         try{
           smt = con.prepareStatement(query);
           smt.setLong(1, id_pac);
           smt.setBoolean(2, pac.getAntPatPac().getDiabetes());
           smt.setBoolean(3, pac.getAntPatPac().getHipertension());
           smt.setBoolean(4, pac.getAntPatPac().getTabaquismo());
           smt.setBoolean(5, pac.getAntPatPac().getAlcoholismo());
           smt.setString(6, pac.getAntPatPac().getOtroAnt());
           smt.setString(7, pac.getAntPatPac().getAlergiasPac().getMedicamento());
           smt.setString(8, pac.getAntPatPac().getAlergiasPac().getSustancias());
           smt.setString(9, pac.getAntPatPac().getAlergiasPac().getAlimentos());
           smt.setString(10, pac.getAntPatPac().getAlergiasPac().getOtra());
           smt.execute();
           System.out.println("Si salio");
           JOptionPane.showMessageDialog(null, "Se agregaron Antecedentes Patologicos",
                    "Consultorio", JOptionPane.PLAIN_MESSAGE);
            con.close();
            smt.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado", JOptionPane.ERROR_MESSAGE);
        }
         //return resultado;
    }
    
    
    public static void altaNoPatologicos(Paciente pac, int id_pac)
    {
         PreparedStatement smt = null;
         Connection con = ConexionDB.conectarBD();
         String query = "INSERT INTO nopatologicos (id_paciente, ginecologico, peso, talla, "
                 + "tiposangre, freccard, tensionArt, frecresp, otronopat)"
                 + "VALUES (?,?,?,?,?,?,?,?,?)";
         try{
           smt = con.prepareStatement(query);
           smt.setLong(1, id_pac);
           smt.setString(2, pac.getAntNoPatPac().getGinecologico());
           smt.setDouble(3, pac.getAntNoPatPac().getPeso());
           smt.setDouble(4, pac.getAntNoPatPac().getTalla());
           smt.setString(5, pac.getAntNoPatPac().getTipoSangre());
           smt.setDouble(6, pac.getAntNoPatPac().getFrecCard());
           smt.setDouble(7, pac.getAntNoPatPac().getTensionArt());
           smt.setDouble(8, pac.getAntNoPatPac().getFrecResp());
           smt.setString(9, pac.getAntNoPatPac().getOtroAnt());
           smt.execute();
           System.out.println("Si salio");
           JOptionPane.showMessageDialog(null, "Se agregaron Antecedentes No Patologicos",
                    "Consultorio", JOptionPane.PLAIN_MESSAGE);
            con.close();
            smt.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado", JOptionPane.ERROR_MESSAGE);
        }
         //return resultado;
    }
    
public static DefaultTableModel busquedaPac(String textABuscar){
       String[] columnas = {"ID","Nombre","Apellido Paterno","Apellido Materno",
            "Sexo", "Estado Civil", "Ocupacion","Telefono","Movil", "Email", "FechaNac",
            "Edad"};
        Object [] resultados = new Object[12];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String query = "";
        Connection conect = conectarBD();
        query = "SELECT * FROM paciente WHERE id LIKE '%"+textABuscar+"%' OR nombre LIKE '%"+textABuscar+"%' OR apellido1 LIKE '%"+textABuscar+"%' " +
                "OR apellido2 LIKE '%"+textABuscar+"%' OR sexo LIKE '%"+textABuscar+"%' OR estadoCivil LIKE '%"+textABuscar+"%' OR ocupacion LIKE '%"+textABuscar+"%' OR telefono LIKE '%"+textABuscar+"%' " +
                "OR movil LIKE '%"+textABuscar+"%' OR email LIKE '%"+textABuscar+"%' OR  FechaNac LIKE '%"+textABuscar+"%' OR edad LIKE '%"+textABuscar+"%'";
    
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultados[0] = Integer.parseInt(rs.getString("id"));    
                resultados[1] = rs.getString("nombre");
                resultados[2] = rs.getString("apellido1");
                resultados[3] = rs.getString("apellido2");
                resultados[4] = rs.getString("sexo");
                resultados[5] = rs.getString("estadoCivil");
                resultados[6] = rs.getString("ocupacion");
                resultados[7] = rs.getString("telefono");
                resultados[8] = rs.getString("movil");
                resultados[9] = rs.getString("email");
                resultados[10] = rs.getString("FechaNac");
                resultados[11] = Integer.parseInt(rs.getString("edad"));
                modelo.addRow(resultados);
            }
             conect.close();
             st.close();
             rs.close();
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
        return modelo;
}
    
    public static void altaHistorial(Historial hist)
    {
         PreparedStatement smt;
         Connection con = ConexionDB.conectarBD();
         String query = "INSERT INTO historial (id_paciente, fechaConsulta, padActual, examenLab, examenImg, tratamiento, comentarios,"
                 + "fechaSeguimiento)"
                 + "VALUES (?,?,?,?,?,?,?,?)";
         try{
           smt = con.prepareStatement(query);
           smt.setLong(1, hist.getId_paciente());
           System.out.println(hist.getId_paciente());
           smt.setString(2, hist.getFechaActual().obtenerFechaActual());
           smt.setString(3, hist.getPadActual());
           smt.setString(4, hist.getExLab());
           smt.setString(5, hist.getExImg());
           smt.setString(6, hist.getTratamiento());
           smt.setString(7, hist.getComentarios());
           smt.setString(8, hist.getSeguimiento().toDDMMAAAA());
           smt.execute();
           System.out.println("Si salio");
            JOptionPane.showMessageDialog(null, "Historial Añadido para el Paciente: "+hist.getId_paciente(),
                    "MediHist v0.1 dice:", JOptionPane.PLAIN_MESSAGE);
            con.close();
            smt.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public static DefaultTableModel listarTabla()
    {
        String[] columnas = {"ID","Nombre","Apellido Paterno","Apellido Materno",
            "Sexo", "Estado Civil", "Ocupacion","Telefono","Movil", "Email", "FechaNac",
            "Edad"};
        Object [] resultados = new Object[12];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String query = "";
        Connection conect = conectarBD();
        query = "SELECT * FROM paciente ";
    
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultados[0] = Integer.parseInt(rs.getString("id"));    
                resultados[1] = rs.getString("nombre");
                resultados[2] = rs.getString("apellido1");
                resultados[3] = rs.getString("apellido2");
                resultados[4] = rs.getString("sexo");
                resultados[5] = rs.getString("estadoCivil");
                resultados[6] = rs.getString("ocupacion");
                resultados[7] = rs.getString("telefono");
                resultados[8] = rs.getString("movil");
                resultados[9] = rs.getString("email");
                resultados[10] = rs.getString("FechaNac");
                resultados[11] = Integer.parseInt(rs.getString("edad"));
                modelo.addRow(resultados);
            }
            //tbPaciente.setModel(modelo);
             conect.close();
             st.close();
             rs.close();
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
        return modelo;
    }
 
    public static void  eliminarPac(String id )
    {
        String query;
        Connection conect = ConexionDB.conectarBD();
        query= "DELETE FROM paciente WHERE id = ?";
        try
        {
         PreparedStatement smt = conect.prepareStatement(query);
         smt.setString(1, id);
         int queryOk = smt.executeUpdate();
         if (queryOk == 1){
             JOptionPane.showMessageDialog(null, "Registro Afectado paciente id="+id, "Medicare dice:", JOptionPane.PLAIN_MESSAGE);
         }else{
             JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminarlo", "Medicare dice:", JOptionPane.ERROR_MESSAGE);
         }
         
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
    }//fin de eliminarPac
    
   public static void  eliminarAnt(String id )
    {
        String query;
        Connection conect = ConexionDB.conectarBD();
        query= "DELETE FROM patologicos WHERE id_paciente = ?";
        try
        {
         PreparedStatement smt = conect.prepareStatement(query);
         smt.setString(1, id);
         int queryOk = smt.executeUpdate();
         if (queryOk == 1){
             JOptionPane.showMessageDialog(null, "Registro Afectados: patologicos id="+id, "Medicare dice:", JOptionPane.PLAIN_MESSAGE);
         }else{
             JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminarlo", "Medicare dice:", JOptionPane.ERROR_MESSAGE);
         }
         
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
    }//fin de eliminarAnt
    
    
   public static void  eliminarNoAnt(String id )
    {
        String query;
        Connection conect = ConexionDB.conectarBD();
        query= "DELETE FROM nopatologicos WHERE id_paciente = ?";
        try
        {
         PreparedStatement smt = conect.prepareStatement(query);
         smt.setString(1, id);
         int queryOk = smt.executeUpdate();
         if (queryOk == 1){
             JOptionPane.showMessageDialog(null, "Registro Afectado: nopatologicos id="+id, "Medicare dice:", JOptionPane.PLAIN_MESSAGE);
         }else{
             JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminarlo", "Medicare dice:", JOptionPane.ERROR_MESSAGE);
         }
         
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
    }//fin de eliminarNoAnt
   
    public static int ultimoId(){
        int id = -1;
        Connection link = ConexionDB.conectarBD();
        String query = "SELECT MAX(id) FROM paciente";
        try
        {
         Statement smt = link.createStatement();
         ResultSet rset = smt.executeQuery(query);
         while(rset.next()){
         id = Integer.parseInt(rset.getString(1));
         }
         link.close();
         smt.close();
         rset.close();
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
        return id;
    }

    public static ArrayList<String> obtenerDatosPacientes(String id)
    {
        ArrayList<String> resultados = new ArrayList<>();
        String query;
        Connection conect = conectarBD();
        query = "SELECT * FROM paciente WHERE id=?";
    
        try{
            PreparedStatement st = conect.prepareStatement(query);
            st.setString(1, id);           
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                resultados.add(rs.getString("id"));    
                resultados.add(rs.getString("nombre"));
                resultados.add(rs.getString("apellido1"));
                resultados.add(rs.getString("apellido2"));
                resultados.add(rs.getString("sexo"));
                resultados.add(rs.getString("estadoCivil"));
                resultados.add(rs.getString("ocupacion"));
                resultados.add(rs.getString("telefono"));
                resultados.add(rs.getString("movil"));
                resultados.add(rs.getString("email"));
                resultados.add(rs.getString("FechaNac"));
                resultados.add(rs.getString("edad"));
            }
                    
            query = "SELECT * FROM patologicos WHERE id_paciente=?";
            st = conect.prepareStatement(query);
            st.setString(1, id);           
            rs = st.executeQuery();
            while(rs.next()){
                resultados.add(rs.getString("diabetes"));    
                resultados.add(rs.getString("hipertension"));
                resultados.add(rs.getString("tabaquismo"));
                resultados.add(rs.getString("alcoholismo"));
                resultados.add(rs.getString("otroPat"));
                resultados.add(rs.getString("alergiaMed"));
                resultados.add(rs.getString("alergiaSus"));
                resultados.add(rs.getString("alergiaAl"));
                resultados.add(rs.getString("otraAlergia"));
            }
            
            query = "SELECT * FROM nopatologicos WHERE id_paciente=?";
            st = conect.prepareStatement(query);
            st.setString(1, id);           
            rs = st.executeQuery();
            while(rs.next()){
                resultados.add(rs.getString("ginecologico"));    
                resultados.add(rs.getString("peso"));
                resultados.add(rs.getString("talla"));
                resultados.add(rs.getString("tiposangre"));
                resultados.add(rs.getString("freccard"));
                resultados.add(rs.getString("tensionArt"));
                resultados.add(rs.getString("frecresp"));
                resultados.add(rs.getString("otronopat"));
            }
            
            conect.close();
            st.close();
            rs.close();
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
        return resultados;
    }

    public static void updatePaciente (Paciente pac, int id){
        String query;
        PreparedStatement smt;        
        query="UPDATE paciente SET nombre=?, apellido1=?, apellido2=?, sexo=?, "
                + "estadoCivil=?, ocupacion=?, telefono=?, movil=?, email=?,"
                + "FechaNac=?, edad=? WHERE id="+id;
        Connection conex = ConexionDB.conectarBD();
        try{
           smt = conex.prepareStatement(query);
           smt.setString(1, pac.getNombrePac());
           smt.setString(2, pac.getApellidoPac1());
           smt.setString(3, pac.getApellidoPac2());
           smt.setBoolean(4, pac.getSexoPac());
           smt.setString(5, pac.getEstadoCivPac());
           smt.setString(6, pac.getOcupacionPac());
           smt.setLong(7, pac.getTelefono());
           smt.setLong(8, pac.getCelular());
           smt.setString(9, pac.getEmail());
           smt.setString(10, pac.getNacimiento().toString());
           smt.setInt(11, pac.getNacimiento().obtenerEdad());
           smt.execute();
                
            query="UPDATE patologicos SET diabetes=?, hipertension=?, tabaquismo=?,"
                    + "alcoholismo=?, otroPat=?, alergiaMed=?, alergiaSus=?, "
                    + "alergiaAl=?, otraAlergia=? WHERE id_paciente="+id;     
            smt = conex.prepareStatement(query);
            smt.setBoolean(1, pac.getAntPatPac().getDiabetes());
            smt.setBoolean(2, pac.getAntPatPac().getHipertension());
            smt.setBoolean(3, pac.getAntPatPac().getTabaquismo());
            smt.setBoolean(4, pac.getAntPatPac().getAlcoholismo());
            smt.setString(5, pac.getAntPatPac().getOtroAnt());
            smt.setString(6, pac.getAntPatPac().getAlergiasPac().getMedicamento());
            smt.setString(7, pac.getAntPatPac().getAlergiasPac().getSustancias());
            smt.setString(8, pac.getAntPatPac().getAlergiasPac().getAlimentos());
            smt.setString(9, pac.getAntPatPac().getAlergiasPac().getOtra());
            smt.execute();
 
            query="UPDATE nopatologicos SET ginecologico=?, peso=?, talla=?, "
                        + "tiposangre=?, freccard=?, tensionArt=?, frecresp=?, "
                        + "otronopat=? WHERE id_paciente="+id;
          
                smt = conex.prepareStatement(query);
                smt.setString(1, pac.getAntNoPatPac().getGinecologico());
                smt.setDouble(2, pac.getAntNoPatPac().getPeso());
                smt.setDouble(3, pac.getAntNoPatPac().getTalla());
                smt.setString(4, pac.getAntNoPatPac().getTipoSangre());
                smt.setDouble(5, pac.getAntNoPatPac().getFrecCard());
                smt.setDouble(6, pac.getAntNoPatPac().getTensionArt());
                smt.setDouble(7, pac.getAntNoPatPac().getFrecResp());
                smt.setString(8, pac.getAntNoPatPac().getOtroAnt());
                smt.execute();
                System.out.println("Si salio");
                JOptionPane.showMessageDialog(null, "Se han agregado los datos Satisfactoriamente",
                        "Medicare dice:", JOptionPane.PLAIN_MESSAGE);
                conex.close();
                smt.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado", JOptionPane.ERROR_MESSAGE);
        }

    }
   
    public static DefaultTableModel tablaHistModel(String id_pac)
    {
        String[] columnas = {"ID","Fecha Consulta","Padecimiento Actual","Ex Laboratorio",
            "Ex Imagen", "Tratamiento", "Comentario","Fecha Seguimiento"};
        Object [] resultados = new Object[8];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        String query = "";
        Connection conect = conectarBD();
        query = "SELECT * FROM historial WHERE id_paciente ="+id_pac;
    
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultados[0] = Integer.parseInt(rs.getString("id_paciente"));    
                resultados[1] = rs.getString("fechaConsulta");
                resultados[2] = rs.getString("padActual");
                resultados[3] = rs.getString("examenLab");
                resultados[4] = rs.getString("examenImg");
                resultados[5] = rs.getString("tratamiento");
                resultados[6] = rs.getString("comentarios");
                resultados[7] = rs.getString("fechaSeguimiento");
                modelo.addRow(resultados);
            }
            //tbPaciente.setModel(modelo);
             conect.close();
             st.close();
             rs.close();
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado",
                JOptionPane.ERROR_MESSAGE);    
        }
        return modelo;
    }
    
    public static boolean validAdmin(String user, String pass){
       String[] result = new String[2];
        String query = "";
        Connection conect = conectarBD();
        query = "SELECT * FROM admin WHERE username ='"+user+"' AND password = '"+pass+"'";
        boolean login = false;
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(query);
               
            if(rs.next()){
                conect.close();
                st.close();
                rs.close();
                login = true;
            }
            else{
                login = false; 
                conect.close();
                st.close();
                rs.close();
               
            }
        }catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR de MySQL",
                JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){        
            JOptionPane.showMessageDialog(null, e, "ERROR Inesperado validAdmin",
                JOptionPane.ERROR_MESSAGE);    
        }   
    return login;
    }
    
}

