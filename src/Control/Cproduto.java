/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mproduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TEODORO
 */
public class Cproduto {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Modal.Mproduto p) {
        String sql = "insert into produto(idp,nome,descricao,categoria,idf) values(default,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setString(3, p.getCategoria());
            ps.setString(4, p.getIdMfuncionario());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }

  

    public void atualizar(Mproduto p) {
        //declaramos uma variavel qualquer que vai receber a linha de codigo do mysl que é a atualicação de dados
        String sql = "Update produto set nome=?,descricao=?,categoria=?,idf=? where idp=?";
        // usamos o try para nos dar informação acerca dos erros
        try {
            //preparamos a base de dados e conetamos com a conexão
            ps = c.conectar().prepareStatement(sql);
            // recemos da modal e setamos os valor em cada posição
            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setString(3, p.getCategoria());
            ps.setString(4, p.getIdMfuncionario());
            ps.setString(5, p.getCodigo());
            //condção que vai atualizar os dados
            if (ps.executeUpdate() == 1) {
                c.mensagem("Sucesso");
            } else {
                c.mensagem("Erro");
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
    }

    public void apagar(Mproduto p) {
        //declaramos uma variavel qualquer que vai receber a linha de codigo do mysl que é o delete
        String sql = "delete from produto where idp=?";
        // usamos o try para nos dar informação acerca dos erros
        try {
            //preparamos a base de dados e conectamos com a conexão
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            //condção que vai atualizar os dados
            if (ps.executeUpdate() == 1) {
                c.mensagem("sucesso");
            } else {
                c.mensagem("Erro");
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
    }

    public ArrayList<Mproduto> pesquisar(String pesquisar) {
        ArrayList<Mproduto> dados = new ArrayList<>();
        String sql = "select *from produto where nome like '%" + pesquisar + "%' "
                + " or categoria like '%" + pesquisar + "%'  order by idp desc";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mproduto d = new Mproduto();
                d.setCodigo(rs.getString("idp"));
                d.setCategoria(rs.getString("categoria"));
                d.setNome(rs.getString("nome"));
                d.setDescricao(rs.getString("descricao"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }
}
