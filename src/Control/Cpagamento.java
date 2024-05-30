    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mdivida;
import Modal.Mpagamento;
import Modal.vpagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Cpagamento {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();

    public void salvar(Mpagamento d) {
        String sql = "insert into pagamento values(default,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, d.getIddivida());
            ps.setDouble(2, d.getValor_pago());
            ps.setString(3, d.getDatapagamento());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            d.mensagem(e.getMessage());
        }
    }

   public ArrayList<vpagamento> pesquisar() {
        ArrayList<vpagamento> dados = new ArrayList<>();
        String sql = "select * from vpagamento";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vpagamento d = new vpagamento();
                d.setCodigo(rs.getInt("idpagamento"));
                d.setNome(rs.getString("nome"));
                d.setValor(rs.getDouble("valor_pago"));
                d.setData(rs.getString("data"));
                dados.add(d);
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
        return dados;
    }

}
