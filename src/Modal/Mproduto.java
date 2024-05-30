/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import javax.swing.JOptionPane;

/**
 *
 * @author TEODORO
 */
public class Mproduto {

    private String codigo;
    private String nome;
    private String descricao;
    private String categoria;
    private String  idMfuncionario;

    public String getIdMfuncionario() {
        return idMfuncionario;
    }

    public void setIdMfuncionario(String idMfuncionario) {
        this.idMfuncionario = idMfuncionario;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }

}
