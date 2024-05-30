    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mdividas;
import java.io.File;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Cdivida {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Mdividas d) {
        String sql = "insert into divida values(default,?,?,?,?,?,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, d.getNome());
            ps.setString(2, d.getGenero());
            ps.setString(3, d.getBi());
            ps.setString(4, d.getMorada());
            ps.setInt(5, d.getTelefone());
            ps.setDouble(6, d.getDivida());
            ps.setDouble(7, d.getPagamento());
            ps.setString(8, d.getData());
            ps.setInt(9, d.getFuncionario());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            d.mensagem(e.getMessage());
        }
    }

    public ArrayList<Mdividas> pesquisar(String p) {
        ArrayList<Mdividas> dados = new ArrayList<>();
        String sql = "select * from divida where nome like '%" + p + "%'";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Mdividas d = new Mdividas();
                d.setIdt(rs.getInt("idd"));
                d.setNome(rs.getString("nome"));
                d.setGenero(rs.getString("genero"));
                d.setBi(rs.getString("bi"));
                d.setMorada(rs.getString("morada"));
                d.setTelefone(rs.getInt("telefone"));
                d.setDivida(rs.getDouble("divida"));
                d.setPagamento(rs.getDouble("pagamento"));
                d.setData(rs.getString("data"));
                d.setFuncionario(rs.getInt("idf"));
                dados.add(d);
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
        return dados;
    }

    public void apagar(Mdividas d) {
        String sql = "delete from divida where idd=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, d.getIdt());
            if (ps.executeUpdate() == 1) {
                d.mensagem("SUCESSO");
            } else {
                d.mensagem("ERRO");
            }
        } catch (Exception e) {
            d.mensagem(e.getMessage());
        }
    }

    public void actualizar(Mdividas d) {

        String sql = "update divida set nome=?,genero=?,bi=?,morada=?,telefone=?,idf=? where idd=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, d.getNome());
            ps.setString(2, d.getGenero());
            ps.setString(3, d.getBi());
            ps.setString(4, d.getMorada());
            ps.setInt(5, d.getTelefone());
            ps.setInt(6, d.getFuncionario());
            ps.setInt(7, d.getIdt());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            d.mensagem(e.getMessage());
        }
    }
    public void actualizarpagamento(Mdividas d) {

        String sql = "update divida set nome=?,genero=?,bi=?,morada=?,telefone=?,divida=? ,pagamento=?,data=?, idf=? where idd=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, d.getNome());
            ps.setString(2, d.getGenero());
            ps.setString(3, d.getBi());
            ps.setString(4, d.getMorada());
            ps.setInt(5, d.getTelefone());
            ps.setDouble(6, d.getDivida());
            ps.setDouble(7, d.getPagamento());
            ps.setString(8, d.getData());
            ps.setInt(9, d.getFuncionario());
            ps.setInt(10, d.getIdt());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            d.mensagem(e.getMessage());
        }
    }

  
}
