package mx.edu.utez.recuperacion.models;

import mx.edu.utez.recuperacion.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    User user;

    public User loadUser(String mail, String pass) {
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT id_user, mail, name, lastname, role FROM users " +
                    "WHERE mail = ? AND pass = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, mail);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId_user(rs.getLong("id_user"));
                user.setMail(rs.getString("mail"));
                user.setName(rs.getString("name"));
                user.setLastname(rs.getString("lastname"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,
                            "Credentials diferentes: " + e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public List<Incidencia> findIncidencias(){
        List<Incidencia> incidencias = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from incidencias where estado = 'Aceptada' OR  estado = 'Aprovada';";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Incidencia incidencia = new Incidencia();
                incidencia.setId(rs.getLong("id"));
                incidencia.setTitulo(rs.getString("titulo"));
                incidencia.setDescripcion(rs.getString("descripcion"));
                incidencia.setTipo(rs.getString("tipo"));
                incidencia.setEstado(rs.getString("estado"));
                incidencia.setMensaje(rs.getString("mensaje"));
                incidencia.setFk_user(rs.getLong("fk_user"));
                incidencias.add(incidencia);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return incidencias;

    }
    public List<Incidencia> findIncidenciasCharger(){
        List<Incidencia> incidencias = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from incidencias;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Incidencia incidencia = new Incidencia();
                incidencia.setId(rs.getLong("id"));
                incidencia.setTitulo(rs.getString("titulo"));
                incidencia.setDescripcion(rs.getString("descripcion"));
                incidencia.setTipo(rs.getString("tipo"));
                incidencia.setEstado(rs.getString("estado"));
                incidencia.setMensaje(rs.getString("mensaje"));
                incidencia.setFk_user(rs.getLong("fk_user"));
                incidencias.add(incidencia);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return incidencias;

    }
    public List<Incidencia> findIncidenciasUser(Long fk_user){
        List<Incidencia> incidencias = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from incidencias where fk_user = "+fk_user+";";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Incidencia incidencia = new Incidencia();
                incidencia.setId(rs.getLong("id"));
                incidencia.setTitulo(rs.getString("titulo"));
                incidencia.setDescripcion(rs.getString("descripcion"));
                incidencia.setTipo(rs.getString("tipo"));
                incidencia.setEstado(rs.getString("estado"));
                incidencia.setMensaje(rs.getString("mensaje"));
                incidencia.setFk_user(rs.getLong("fk_user"));
                incidencias.add(incidencia);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return incidencias;
    }

    public boolean saveIncidencia(Incidencia object){
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT into incidencias (titulo, descripcion, tipo, estado, fk_user) values (?,?,?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,object.getTitulo());
            pstm.setString(2, object.getDescripcion());
            pstm.setString(3,object.getTipo());
            pstm.setString(4, object.getEstado());
            pstm.setLong(5,object.getFk_user());
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public boolean invaliteI(Long id){
        try {
            conn = new MySQLConnection().connect();
            String query = "UPDATE incidencias SET estado = 'Invalidado', mensaje = 'No procede' WHERE id = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public boolean aceptI(Long id){
        try {
            conn = new MySQLConnection().connect();
            String query = "UPDATE incidencias SET estado = 'Aceptada', mensaje = '' WHERE id = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error acept"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    public boolean aprove(Long id ){
        try {
            conn = new MySQLConnection().connect();
            String query = "UPDATE incidencias SET estado = 'Aprovado', mensaje = 'Echale ganas' WHERE id = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            return pstm.executeUpdate() > 0; // == 1
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error aprove"+e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public void close(){
        try {
            if(conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        }catch (SQLException e){

        }

    }
}
