/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import javax.swing.JOptionPane;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Mpagamento {

    private int idpagamento;
    private int iddivida;
    private double valor_pago;
    private String datapagamento;

    public String getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(String datapagamento) {
        this.datapagamento = datapagamento;
    }

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public int getIddivida() {
        return iddivida;
    }

    public void setIddivida(int iddivida) {
        this.iddivida = iddivida;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }
    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
}
