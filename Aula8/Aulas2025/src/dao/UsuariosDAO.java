package dao;

import bean.Usuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author u11249767105
 */
public class UsuariosDAO  extends DaoAbstract{

    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            pass = "marcos_vilhanueva";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = cnt.prepareStatement("" + "insert into usuarios values(?,?,?,?,?,?,?,?)");
           
            pst.setInt(1,usuarios.getIdusuarios());
            pst.setString(2,usuarios.getNome());
            pst.setString(3,usuarios.getApelido());
            pst.setString(4,usuarios.getCpf());
            pst.setDate(5,null); //usuarios.getDataNascimento()
            pst.setString(6,usuarios.getSenha());
            pst.setInt(7,usuarios.getNivel());
            pst.setString(8,usuarios.getAtivo());
            pst.executeUpdate();
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.insert(null);
        System.out.println("executado com sucesso");
    }
    
}