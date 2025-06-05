/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class UsuariosDao extends DaoAbstract {

    Connection cnt;

    public UsuariosDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            pass = "marcos_vilhanueva";
            cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, usuarios.getIdusuarios());
            pst.setString(2, usuarios.getNome());
            pst.setString(3, usuarios.getApelido());
            pst.setString(4, usuarios.getCpf());
            pst.setDate(5, null);//usuarios.getDataNascimento()
            pst.setString(6, usuarios.getSenha());//senha
            pst.setInt(7, usuarios.getNivel());//nivel
            pst.setString(8, usuarios.getAtivo());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update usuarios set nome=?, apelido=?, cpf=?, datanascimento=?, senha=?, nivel=?, ativo =? where idusuarios=?");
            pst.setInt(8, usuarios.getIdusuarios());
            pst.setString(1, usuarios.getNome());
            pst.setString(2, usuarios.getApelido());
            pst.setString(3, usuarios.getCpf());
            pst.setDate(4, null);//usuarios.getDataNascimento()
            pst.setString(5, usuarios.getSenha());//senha
            
            pst.setInt(6, usuarios.getNivel());//nivel
            
            pst.setString(7, usuarios.getAtivo());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from usuarios where idusuarios =?");
            pst.setInt(1, usuarios.getIdusuarios());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from usuarios where idusuarios =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdusuarios( rs.getInt("idusuarios") );
                usuarios.setNome(rs.getString("nome") );
                usuarios.setApelido(rs.getString("apelido") );
                usuarios.setCpf(rs.getString("cpf") );
                usuarios.setDataNascimento(rs.getDate("dataNascimento") );
                usuarios.setSenha(rs.getString("senha") );
                usuarios.setNivel(rs.getInt("nivel") );
                usuarios.setAtivo(rs.getString("ativo") );
                return usuarios;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        Usuarios usuarios = new Usuarios();
        usuarios.setIdusuarios(200);
        usuarios.setNome("marcos");
        usuarios.setApelido("mpv");
        usuarios.setCpf("456.546.879-87");
        usuarios.setDataNascimento(null);
        usuarios.setSenha("123");
        usuarios.setNivel(1);
        usuarios.setAtivo("S");
        UsuariosDao usuariosDao = new UsuariosDao();
        usuariosDao.insert(usuarios);
        System.out.println("executou com sucesso.");
    }

}
