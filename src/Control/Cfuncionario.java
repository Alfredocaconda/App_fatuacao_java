/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mfuncionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TEODORO
 */
public class Cfuncionario {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Mfuncionario f) {
        String sql = "insert into funcionario values(default,?,?,?,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2,f.getGenero());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getBi());
            ps.setString(5, f.getEstado());
            ps.setString(6 , f.getCargo());
            ps.setString(7, f.getSenha());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }

    //codigo para atualizar
    public void atualizar(Mfuncionario f){
        String sql= "update funcionario set nome=?,genero=?,"
                + "tel=?,bi=?,cargo=?,estado=?,senha=? WHERE IDF=?";
        try {
            ps=c.conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getGenero());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getBi());
            ps.setString(5, f.getCargo());
            ps.setString(6, f.getEstado());
            ps.setString(7, f.getSenha());
            ps.setString(8, f.getCodigo());
            if (ps.executeUpdate()==1) {
                f.mensagem("SUCESSO");
            } else {
                f.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }
    public ArrayList<Mfuncionario> pesquisar(String pesquisar) {
        ArrayList<Mfuncionario> dados = new ArrayList<>();
        String sql = "select * from funcionario where nome like '%" + pesquisar + "%'order by idf";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mfuncionario f = new Mfuncionario();
                f.setCodigo(rs.getString("idf"));
                f.setNome(rs.getString("nome"));
                f.setGenero(rs.getString("genero"));
                f.setBi(rs.getString("bi"));
                f.setSenha(rs.getString("senha"));
                f.setCargo(rs.getString("cargo"));
               f.setEstado(rs.getString("estado"));
                f.setTelefone(rs.getString("tel"));
                dados.add(f);
            }
        } catch (SQLException ex) {
            c.mensagem(ex.getMessage());
        }
        return dados;
    }
}
