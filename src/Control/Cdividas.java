    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mdivida;
import Modal.Vdivida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Cdividas {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Mdivida d) {
        String sql = "insert into divida values(default,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, d.getIddevedor());
            ps.setDouble(2, d.getTotal());
            ps.setString(3, d.getData());
            ps.setInt(4, d.getN_factura());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
            d.mensagem(e.getMessage());
        }
    }

    public ArrayList<Vdivida> pesquisar() {
        ArrayList<Vdivida> dados = new ArrayList<>();
        String sql = "select * from vdivida";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vdivida d = new Vdivida();
                d.setCodigo(rs.getInt("codigo"));
                d.setNome(rs.getString("nome"));
                d.setTelefone(rs.getInt("telefone"));
                d.setMorada(rs.getString("morada"));
                d.setDivida(rs.getDouble("divida"));
                d.setData(rs.getString("data"));
                d.setN_factura(rs.getInt("n_factura"));
                dados.add(d);
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
        return dados;
    }

    public void apagar(Mdivida d) {
        String sql = "delete from divida where iddividas=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, d.getIddivda());
            if (ps.executeUpdate() == 1) {
                d.mensagem("SUCESSO");
            } else {
                d.mensagem("ERRO");
            }
        } catch (Exception e) {
            d.mensagem(e.getMessage());
        }
    }

    public void actualizar(Mdivida d) {

        String sql = "update divida set iddevedor=?,divida=?,data=?,n_factura=? where iddividas=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, d.getIddevedor());
            ps.setDouble(2, d.getTotal());
            ps.setString(3, d.getData());
            ps.setInt(4, d.getN_factura());
            ps.setInt(5, d.getIddivda());
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
