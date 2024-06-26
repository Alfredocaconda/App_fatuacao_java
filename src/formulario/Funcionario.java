/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import Control.Cfuncionario;
import Modal.Mfuncionario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TEODORO
 */
public class Funcionario extends javax.swing.JFrame {

    /**
     * Creates new form entrada
     */
    public Funcionario() {
        initComponents();
        pesquisar("");
        btnactualizar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnsalvar = new rojeru_san.RSButton();
        txtnome = new rojeru_san.RSMTextFull();
        cbgenero = new javax.swing.JComboBox();
        txtbi = new rojeru_san.RSMTextFull();
        txttelefone = new rojeru_san.RSMTextFull();
        cbestado = new javax.swing.JComboBox();
        txtsenha = new rojeru_san.RSMPassView();
        cbcargo = new javax.swing.JComboBox();
        btnactualizar = new rojeru_san.RSButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtpesquisar = new rojeru_san.RSMTextFull();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbfuncionario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(52, 58, 115));

        btnsalvar.setBackground(new java.awt.Color(255, 102, 0));
        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/salvar.png"))); // NOI18N
        btnsalvar.setText("GUARDAR");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        txtnome.setPlaceholder("NOME ");
        txtnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnomeKeyPressed(evt);
            }
        });

        cbgenero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbgenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONAR O GENERO", "MASCULINO", "FEMENINO" }));
        cbgenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbgeneroKeyPressed(evt);
            }
        });

        txtbi.setPlaceholder("Nº DO BI");
        txtbi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbiKeyPressed(evt);
            }
        });

        txttelefone.setPlaceholder("TELEFONE/EMAIL");
        txttelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefoneActionPerformed(evt);
            }
        });
        txttelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefoneKeyPressed(evt);
            }
        });

        cbestado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR O ESTADO", "ACTIVO", "NÃO ACTIVO" }));
        cbestado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbestadoKeyPressed(evt);
            }
        });

        txtsenha.setPlaceholder("SENHA");
        txtsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsenhaKeyPressed(evt);
            }
        });

        cbcargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbcargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR O CARGO", "GERENTE", "FUNCIONÁRIO", "TECNICO" }));
        cbcargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbcargoKeyPressed(evt);
            }
        });

        btnactualizar.setBackground(new java.awt.Color(255, 102, 0));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/salvar.png"))); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbcargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtbi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbgenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel3.setBackground(new java.awt.Color(52, 58, 115));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/left.png"))); // NOI18N
        jLabel3.setText("VOLTAR");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtpesquisar.setPlaceholder("Pesquisar");
        txtpesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesquisarKeyReleased(evt);
            }
        });

        tbfuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbfuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbfuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbfuncionario);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTO DE FUNCIONÁRIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int id = 0;
    String codigo;
    private void txttelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefoneActionPerformed

    private void tbfuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbfuncionarioMouseClicked

        codigo = (String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 0);
        //codigo para o duplo clique
        if (evt.getClickCount() == 2) {
            //codigo do Joptiona 
            //declaramos uma vetor objecto que vai armazenar os itens selecionado
            Object[] recebe = {"EDITAR", "CANCELAR"};
            int valor = (int) JOptionPane.showOptionDialog(this, "O QUE DESEJA?", "AVISO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, recebe, recebe[1]);

            if (valor == 0) {
                txtnome.setText((String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 1));
                cbgenero.setSelectedItem((String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 2));
                txtbi.setText((String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 3));
                txttelefone.setText((String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 4));
                cbestado.setSelectedItem((String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 5));
                cbcargo.setSelectedItem((String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 6));
                txtsenha.setText((String) tbfuncionario.getValueAt(tbfuncionario.getSelectedRow(), 7));
                id++;
                btnactualizar.setVisible(true);
                btnsalvar.setVisible(false);

            }

        }
    }//GEN-LAST:event_tbfuncionarioMouseClicked

    private void txtpesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar(txtpesquisar.getText());
    }//GEN-LAST:event_txtpesquisarKeyReleased

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        // TODO add your handling code here:
        salvar();
        pesquisar("");
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtnomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            cbgenero.requestFocus();
        }
    }//GEN-LAST:event_txtnomeKeyPressed

    private void cbgeneroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbgeneroKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            txtbi.requestFocus();
        }
    }//GEN-LAST:event_cbgeneroKeyPressed

    private void txtbiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbiKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            txttelefone.requestFocus();
        }
    }//GEN-LAST:event_txtbiKeyPressed

    private void txttelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefoneKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            cbestado.requestFocus();
        }
    }//GEN-LAST:event_txttelefoneKeyPressed

    private void cbestadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbestadoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            cbcargo.requestFocus();
        }
    }//GEN-LAST:event_cbestadoKeyPressed

    private void cbcargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbcargoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            txtsenha.requestFocus();
        }
    }//GEN-LAST:event_cbcargoKeyPressed

    private void txtsenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            salvar();
            pesquisar("");
        }
    }//GEN-LAST:event_txtsenhaKeyPressed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        atualizar();

    }//GEN-LAST:event_btnactualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnactualizar;
    private rojeru_san.RSButton btnsalvar;
    private javax.swing.JComboBox cbcargo;
    private javax.swing.JComboBox cbestado;
    private javax.swing.JComboBox cbgenero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbfuncionario;
    private rojeru_san.RSMTextFull txtbi;
    private rojeru_san.RSMTextFull txtnome;
    private rojeru_san.RSMTextFull txtpesquisar;
    private rojeru_san.RSMPassView txtsenha;
    private rojeru_san.RSMTextFull txttelefone;
    // End of variables declaration//GEN-END:variables

    private void salvar() {
        Mfuncionario f = new Mfuncionario();
        Cfuncionario c = new Cfuncionario();
        String nome = txtnome.getText();
        String genero = (String) cbgenero.getSelectedItem();
        String senha = txtsenha.getText();
        String bi = txtbi.getText();
        String estado = (String) cbestado.getSelectedItem();
        String cargo = (String) cbcargo.getSelectedItem();
        String telefone = txttelefone.getText();
        if (!nome.isEmpty() && !senha.isEmpty() && !telefone.isEmpty()
                && !estado.isEmpty() && !cargo.isEmpty() && !bi.isEmpty() && !genero.isEmpty()) {
            f.setBi(bi);
            f.setGenero(genero);
            f.setCargo(cargo);
            f.setEstado(estado);
            f.setNome(nome);
            f.setSenha(senha);
            f.setTelefone(telefone);
            c.salvar(f);
        } else {
            f.mensagem("PRENCHA OS ESPAÇOS VAZIOS");
        }
        LIMPAR();
        btnactualizar.setVisible(false);
        btnsalvar.setVisible(true);
    }

    private void atualizar() {
        Mfuncionario f = new Mfuncionario();
        Cfuncionario c = new Cfuncionario();
        String nome, senha, telefone, estado, cargo, usuario, bi, genero;
        if (txtbi.getText().equals("") || cbcargo.getSelectedIndex() == 0
                || txtnome.getText().equals("") || txtsenha.getText().equals("") || txttelefone.getText().equals("")
                || cbestado.getSelectedIndex() == 0
                || cbgenero.getSelectedIndex() == 0) {
            f.mensagem("PRENCHA OS ESPAÇOS VAZIOS");
        } else {
            nome = txtnome.getText();
            genero = (String) cbgenero.getSelectedItem();
            senha = txtsenha.getText();
            bi = txtbi.getText();
            estado = (String) cbestado.getSelectedItem();
            cargo = (String) cbcargo.getSelectedItem();
            telefone = txttelefone.getText();
            f.setBi(bi);
            f.setGenero(genero);
            f.setCargo(cargo);
            f.setEstado(estado);
            f.setNome(nome);
            f.setSenha(senha);
            f.setTelefone(telefone);
            f.setCodigo(codigo);
            c.atualizar(f);
        }
        LIMPAR();
        btnactualizar.setVisible(false);
        btnsalvar.setVisible(true);
    }

    public int pesquisar(String pesquisar) {
        int qtdfuncionario = 0;
        Cfuncionario f = new Cfuncionario();
        DefaultTableModel dt = (DefaultTableModel) tbfuncionario.getModel();
        Object[] recebe = {"CODIGO", "NOME", "GENERO", "BI", "TELEFONE/EMAIL",
            "ESTADO", "CARGO", "SENHA"};
        dt.setColumnIdentifiers(recebe);
        dt.setNumRows(0);
        for (Mfuncionario m : f.pesquisar(pesquisar)) {
            Object[] dado = {m.getCodigo(), m.getNome(), m.getGenero(), m.getBi(), m.getTelefone(),
                m.getEstado(), m.getCargo(), m.getSenha()};
            dt.addRow(dado);
            if (m.getEstado().equalsIgnoreCase("activo")) {
                qtdfuncionario++;
            }
        }
        return qtdfuncionario;
    }

    private void LIMPAR() {
        pesquisar("");
        txtbi.setText("");
        cbcargo.setSelectedIndex(0);
        txtnome.requestFocus();
        txtnome.setText("");
        txtsenha.setText("");
        txttelefone.setText("");
        cbestado.setSelectedIndex(0);
        cbgenero.setSelectedIndex(0);
    }
}
