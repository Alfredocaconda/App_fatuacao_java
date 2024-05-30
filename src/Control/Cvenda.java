  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.Conexao;
import Modal.Mvenda;
import Modal.Mvews;
import Modal.MviewEntrada;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TEODORO
 */
public class Cvenda {
    
    private PreparedStatement ps;
    private ResultSet rs;
    Conexao c = new Conexao();
    
    public void salvar(Mvenda v) {
        String sql = "insert into venda(qtdrequerida,totalcompra,datavenda,fatura,idp,idf)"
                + " values(?,?,?,?,?,?)";
        try {
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, v.getQuantidaderequerida());
            ps.setString(2, v.getTotalcompra());
            ps.setString(3, v.getDatavenda());
            ps.setString(4, v.getFatura());
            ps.setString(5, v.getIdproduto());
            ps.setString(6, v.getIdfuncionario());
            if (ps.executeUpdate() == 1) {
                // c.mensagem("SUCESSO");
                new Cstock().atualizarquantidade(v.getQuantidaderequerida(), v.getIdproduto(), true);
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }
    
    public ArrayList<MviewEntrada> pesquisar(String pesquisar) {
        ArrayList<MviewEntrada> dados = new ArrayList<>();
        String sql = "select * from Ventrada where quantidade > 0 and (medicamento like '%" + pesquisar + "%' || codigo_barra = '" + pesquisar + "') order by CODIGO_PRODUTO";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MviewEntrada d = new MviewEntrada();
                d.setCodigo(rs.getString("CODIGO_PRODUTO"));
                d.setCategoria(rs.getString("categoria"));
                d.setDescricao(rs.getString("descricao"));
                d.setNome(rs.getString("medicamento"));
                d.setPreco(rs.getString("preco"));
                d.setQuantidade(rs.getString("quantidade"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }
    
    public ArrayList<Modal.Mvews> devolucao(String pesquisar) {
        ArrayList<Modal.Mvews> dados = new ArrayList<>();
        String sql = "select * from Vvenda where fatura like '%" + pesquisar + "%' ";
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Modal.Mvews d = new Mvews();
                d.setCodigop(rs.getString("codigop"));
                d.setCategoria(rs.getString("categoria"));
                d.setDescricao(rs.getString("descricao"));
                d.setNome(rs.getString("nome"));
                d.setCodigov(rs.getString("codigov"));
                d.setQuantidade(rs.getString("quantidade"));
                d.setTotalcompra(rs.getString("totalcompra"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }

    public ArrayList<Modal.Mvews> relatorio(String pesquisar, String datade, String datapara) {
        ArrayList<Modal.Mvews> dados = new ArrayList<>();
       String sql = "select codigov,  nome, descricao, categoria,preco,"
               + " sum(quantidade) as quantidade,datavenda, sum( totalcompra) as totalcompra, nomef from Vvenda where (datavenda>='" + datade + "' and "
                + "datavenda<='" + datapara + "') and (nome like '%" + pesquisar + "%' or"
               + " nomef like '%" + pesquisar + "%') GROUP BY nome,categoria ";
        if (datade.equals("")) {
              sql = "select codigov, nome, descricao,datavenda, categoria,preco, "
                      + "sum(quantidade) as quantidade, sum( totalcompra) as totalcompra, nomef from Vvenda GROUP BY nome,categoria";
        }
        
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Modal.Mvews d = new Mvews();
                d.setCategoria(rs.getString("categoria"));
                d.setDescricao(rs.getString("descricao"));
                d.setNome(rs.getString("nome"));
                d.setCodigov(rs.getString("codigov"));
                d.setQuantidade(rs.getString("quantidade"));
                d.setTotalcompra(rs.getString("totalcompra"));
                d.setNomef(rs.getString("nomef"));
                d.setPreco(rs.getString("preco"));
                d.setDatavenda(rs.getString("DATAVENDA"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }
    public ArrayList<Modal.Mvews> relatorio_nome(String pesquisar) {
        ArrayList<Modal.Mvews> dados = new ArrayList<>();
       String sql = "select * from Vvenda where (nome like '%" + pesquisar + "%' or"
               + " nomef like '%" + pesquisar + "%') GROUP BY nome,categoria ";
        
        try {
            ps = c.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Modal.Mvews d = new Mvews();
                d.setCategoria(rs.getString("categoria"));
                d.setDescricao(rs.getString("descricao"));
                d.setNome(rs.getString("nome"));
                d.setCodigov(rs.getString("codigov"));
                d.setQuantidade(rs.getString("quantidade"));
                d.setTotalcompra(rs.getString("totalcompra"));
                d.setNomef(rs.getString("nomef"));
                d.setPreco(rs.getString("preco"));
                d.setDatavenda(rs.getString("DATAVENDA"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
        return dados;
    }
    
    public void delete(Mvenda v) {
        //declaramos uma variavel qualquer que vai receber a linha de codigo do mysl que é o delete
        String sql = "delete from venda where idv=?";
        // usamos o try para nos dar informação acerca dos erros
        try {
            //preparamos a base de dados e conectamos com a conexão
            ps = c.conectar().prepareStatement(sql);
            ps.setString(1, v.getCodigo());
            //condção que vai atualizar os dados
            if (ps.executeUpdate() == 1) {
                new Cstock().atualizarquantidade(v.getQuantidaderequerida(), v.getIdproduto(), false);
            } else {
                c.mensagem("Erro");
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.mensagem(ex.getMessage());
        }
    }
    
    public void impressao(double troco, double valor, String fatura, String cliente) {
        
        File f = new File("C:/App_faturacao/Extras/empresa.txt");
        HashMap d = new HashMap();
        try {
            Scanner s = new Scanner(f);
            if (s.hasNextLine()) {
                String[] dados = s.nextLine().split("separar");
                d.put("empresa", dados[0]);
                d.put("bairro", dados[1]);
                d.put("provincia", dados[2]);
                d.put("contacto", dados[3]);
                d.put("email", dados[4]);
                d.put("nif", dados[5]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        d.put("troco", troco);
        d.put("entregue", valor);
        d.put("faturas", fatura);
        d.put("cliente", cliente);
        
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\App_faturacao\\relatorio\\venda.jasper", d, c.conectar());
            JasperViewer.viewReport(imprimir, false);
            
        } catch (Exception ex) {
            c.mensagem(ex.getMessage());
            
        }
    }
    
    public void impressaoDiaria(String idf, String data) {
        
        File f = new File("C:/App_faturacao/Extras/empresa.txt");
        HashMap d = new HashMap();
        try {
            Scanner s = new Scanner(f);
            if (s.hasNextLine()) {
                String[] dados = s.nextLine().split("separar");
                d.put("empresa", dados[0]);
                d.put("bairro", dados[1]);
                d.put("provincia", dados[2]);
                d.put("contacto", dados[3]);
                d.put("email", dados[4]);
                d.put("nif", dados[5]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        d.put("idf", idf);
        d.put("datavenda", data);
        
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\App_faturacao\\relatorio\\vendadiaria.jasper", d, c.conectar());
            JasperViewer.viewReport(imprimir, false);
            
        } catch (Exception ex) {
            c.mensagem(ex.getMessage());
            
        }
    }

    public void impressaoDeRelatorio(String pesquisa, String datade, String datapara) {
        
        File f = new File("C:/App_faturacao/Extras/empresa.txt");
        HashMap d = new HashMap();
        try {
            Scanner s = new Scanner(f);
            if (s.hasNextLine()) {
                String[] dados = s.nextLine().split("separar");
                d.put("empresa", dados[0]);
                d.put("bairro", dados[1]);
                d.put("provincia", dados[2]);
                d.put("contacto", dados[3]);
                d.put("email", dados[4]);
                d.put("nif", dados[5]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        d.put("pesquisa", "%"+pesquisa+"%");
        d.put("datade", datade);
        d.put("datapara", datapara);
        
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\App_faturacao\\relatorio\\relatorio.jasper", d, c.conectar());
            JasperViewer.viewReport(imprimir, false);
            
        } catch (Exception ex) {
            c.mensagem(ex.getMessage());
            
        }
    }
    public void impressaoDeRelatorio_nome(String pesquisa) {
        
        File f = new File("C:/App_faturacao/Extras/empresa.txt");
        HashMap d = new HashMap();
        try {
            Scanner s = new Scanner(f);
            if (s.hasNextLine()) {
                String[] dados = s.nextLine().split("separar");
                d.put("empresa", dados[0]);
                d.put("bairro", dados[1]);
                d.put("provincia", dados[2]);
                d.put("contacto", dados[3]);
                d.put("email", dados[4]);
                d.put("nif", dados[5]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        d.put("pesquisa", "%"+pesquisa+"%");
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\App_faturacao\\relatorio\\relatorio.jasper", d, c.conectar());
            JasperViewer.viewReport(imprimir, false);
            
        } catch (Exception ex) {
            c.mensagem(ex.getMessage());
            
        }
    }
}
