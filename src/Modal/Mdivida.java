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
public class Mdivida {

    private int iddivda;
    private int iddevedor;
    private int n_factura;
    private double total;
    private String data;

    public int getIddevedor() {
        return iddevedor;
    }

    public void setIddevedor(int iddevedor) {
        this.iddevedor = iddevedor;
    }

    public int getIddivda() {
        return iddivda;
    }

    public void setIddivda(int iddivda) {
        this.iddivda = iddivda;
    }

    public int getN_factura() {
        return n_factura;
    }

    public void setN_factura(int n_factura) {
        this.n_factura = n_factura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
}
