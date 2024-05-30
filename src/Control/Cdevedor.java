    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mdevedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Cdevedor {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Mdevedor d) {
        String sql = "insert into devedor values(default,?,?,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, d.getNome());
            ps.setString(2, d.getGenero());
            ps.setString(3, d.getBi());
            ps.setString(4, d.getMorada());
            ps.setInt(5, d.getTelefone());
            ps.setInt(6, d.getFuncionario());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            d.mensagem(e.getMessage());
        }
    }

    public ArrayList<Mdevedor> pesquisar(String p) {
        ArrayList<Mdevedor> dados = new ArrayList<>();
        String sql = "select * from devedor where nome like '%" + p + "%'";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mdevedor d = new Mdevedor();
                d.setIdt(rs.getInt("idd"));
                d.setNome(rs.getString("nome"));
                d.setGenero(rs.getString("genero"));
                d.setBi(rs.getString("bi"));
                d.setMorada(rs.getString("morada"));
                d.setTelefone(rs.getInt("telefone"));
                d.setFuncionario(rs.getInt("idf"));
                dados.add(d);
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
        return dados;
    }

    public void apagar(Mdevedor d) {
        String sql = "delete from devedor where idd=?";
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

    public void actualizar(Mdevedor d) {

        String sql = "update devedor set nome=?,genero=?,bi=?,morada=?,telefone=?,idf=? where idd=?";
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

}
