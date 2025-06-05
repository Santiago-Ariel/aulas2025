/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    Connection cnt;
    public UsuariosDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");String url, user, pass;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            pass = "marcos_vilhanueva";
            
            cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
    
    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            
            PreparedStatement pst = cnt.prepareStatement("insert into usuarios values(?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, 40);
            pst.setString(2, "edp");
            pst.setString(3, "Esfaqueador do Parque");
            pst.setString(4, "123.456.789.01");
            pst.setDate(5, null);  //usuarios.getDataNascimento());
            pst.setString(6, "Senha");
            pst.setInt(7, 1);
            pst.setString(8, "S");
//            pst.setInt(1, usuarios.getIdusuarios());
//            pst.setString(2, usuarios.getNome());
//            pst.setString(3, usuarios.getApelido());
//            pst.setString(4, usuarios.getCpf());
//            pst.setDate(5, null);  //usuarios.getDataNascimento());
//            pst.setString(6, usuarios.getSenha());
//            pst.setInt(7, usuarios.getNivel());
//            pst.setString(8, usuarios.getAtivo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            
            PreparedStatement pst = cnt.prepareStatement("Delete from usuarios where idusuarios=?");
            pst.setInt(1, 40);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public void update(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            
            PreparedStatement pst = cnt.prepareStatement("update usuarios set nome=?, apelido=?, cpf=?, dataNascimento=?, senha=?, nivel=?, ativo=? where  idusuarios=?");
            pst.setInt(8, 40);
            pst.setString(1, "edp");
            pst.setString(2, "Esfaqueador do Parque");
            pst.setString(3, "123.456.789.01");
            pst.setDate(4, null);  //usuarios.getDataNascimento());
            pst.setString(5, "Senha");
            pst.setInt(6, 1);
            pst.setString(7, "S");
//            pst.setInt(1, usuarios.getIdusuarios());
//            pst.setString(2, usuarios.getNome());
//            pst.setString(3, usuarios.getApelido());
//            pst.setString(4, usuarios.getCpf());
//            pst.setDate(5, null);  //usuarios.getDataNascimento());
//            pst.setString(6, usuarios.getSenha());
//            pst.setInt(7, usuarios.getNivel());
//            pst.setString(8, usuarios.getAtivo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
   
        try {
            PreparedStatement pst;
            pst = cnt.prepareStatement("Delete from usuarios where idusuarios=?");
                       pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()== true){
                Usuarios usuarios = new Usuarios();
                
                return  usuarios;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

         return null;
    }

    @Override
    public Object listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.insert(null);
        System.out.println("executado sem fracasso de se executar com sucesso");
        
    }
    
}