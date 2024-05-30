/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mentrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author TEODORO
 */
public class Cstock {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Modal.Mentrada m) {
        String sql = "insert into entrada(preco,qtd,dataentrada,caducidade,idp ,idf,codigo_barra,valor_compra,lucro ) values(?,?,?,?,?,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setDouble(1, m.getPreco());
            ps.setInt(2, m.getQuantidade());
            ps.setString(3, m.getDataEntrada());
            ps.setString(4, m.getCaducidade());
            ps.setString(5, m.getProduto());
            ps.setString(6, m.getFuncionario());
            ps.setString(7, m.getCodigo_barra());
            ps.setDouble(8, m.getPreco_compra());
            ps.setDouble(9, m.getLucro());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem("PRODUTO JÁ EXISTE NO STOCK , POR FAVOR ATUALIZAR A QUANTIDADE");
            c.mensagem(e.getMessage());
        }

    }

    public void atualizar(Mentrada m) {
        String sql = "update entrada set qtd=?,caducidade=?,dataentrada=?,preco=?,codigo_barra=?,valor_compra=?, lucro=? "
                + "where ide=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, m.getQuantidade());
            ps.setString(2, m.getCaducidade());
            ps.setString(3, m.getDataEntrada());
            ps.setDouble(4, m.getPreco());
            ps.setString(5, m.getCodigo_barra());
            ps.setDouble(6, m.getPreco_compra());
            ps.setDouble(7, m.getLucro());
            ps.setInt(8, m.getCodigo());
            if (ps.executeUpdate() == 1) {
                c.mensagem("ACTUALIZADO COM SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }

    public void atualizarquantidade(String qtd, String idp, boolean control) {
        String sql;
        if (control) {

            sql = "update entrada set qtd=qtd-" + qtd + " where idp=?";
        } else {
            sql = "update entrada set qtd=qtd+" + qtd + " where idp=?";
        }
        try {
            ps = c.conectar().prepareStatement(sql);

            ps.setString(1, idp);

            // ps.setString(5, m.getFuncionario());
            if (ps.executeUpdate() == 1) {
                // c.mensagem("ACTUALIZADO COM SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }

    }

    public void atualizarquantidade_stock(Mentrada m) {
        String sql = "update entrada set qtd=? where ide=?";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, m.getQuantidade());
            ps.setInt(2, m.getCodigo());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }

    }

    public ArrayList<Mentrada> pesquisar(String pesquisar) {
        ArrayList<Mentrada> dados = new ArrayList<>();
        String sql = "select *from VENTRADA where medicamento like '%" + pesquisar + "%' order by CODIGO_ENTRADA";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentrada d = new Mentrada();
                d.setCodigo(rs.getInt("CODIGO_ENTRADA"));
                d.setProduto(rs.getString("MEDICAMENTO") + " " + rs.getString("DESCRICAO") + " " + rs.getString("CATEGORIA"));
                d.setDescricao(rs.getString("DESCRICAO"));
                d.setPreco(rs.getDouble("PRECO"));
                d.setQuantidade(rs.getInt("QUANTIDADE"));
                d.setCaducidade(rs.getString("CADUCIDADE"));
                d.setDataEntrada(rs.getString("DATA_ENTRADA"));
                d.setCodigo_barra(rs.getString("CODIGO_BARRA"));
                d.setPreco_compra(rs.getDouble("VALOR_COMPR"));
                d.setLucro(rs.getDouble("LUCRO"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }

    public ArrayList<Mentrada> total_compra() {
        ArrayList<Mentrada> dados = new ArrayList<>();
        String sql = "select sum(valor_compra*qtd) as valor_compra from entrada ";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentrada d = new Mentrada();
                d.setPreco_compra(rs.getDouble("valor_compra"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }

    public ArrayList<Mentrada> total_venda() {
        ArrayList<Mentrada> dados = new ArrayList<>();
        String sql = "select sum(preco*qtd) as preco  from entrada ";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentrada d = new Mentrada();
                d.setPreco(rs.getDouble("preco"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }

    public int caducado() {
        int dados = 0;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");

        String sql = "select *from ventrada where CADUCIDADE<='" + s.format(d) + "'";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dados++;
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }

}
