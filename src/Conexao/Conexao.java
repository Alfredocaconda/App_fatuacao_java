/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author TEODORO
 */
public class Conexao {

    private Connection c;
    private String caminho = "jdbc:mysql://localhost/farmacia";
    private String usuario = "root";
    private String senha = "";

//    private void enderecodabd() {
//        String arquivo = "C:/FARMACIA 1.0.1/Extras/endereco.txt";
//        File f = new File(arquivo);
//        try {
//            Scanner s = new Scanner(f);
//            if (s.hasNextLine()) {
//                String[] dados = s.nextLine().split(";");
//                caminho = "jdbc:mysql://" + dados[0] + "/farmacia";
//                usuario = dados[1];
//                if (usuario.equals("root")) {
//                    senha = "";
//                } else {
//                    senha = dados[2];
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }

    public Connection conectar() {
//        enderecodabd();
        try {
            c = (Connection) DriverManager.getConnection(caminho, usuario, senha);
        } //se houver problema com a base de dados
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return c;
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }

    public void backupDaBd() {
        
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmm");
        String caminhoArquivoBackup ="C://App_faturacao//backup//HSD-"+ s.format(d)+".sql";

        try {
            // Criação do comando para fazer backup do banco de dados
            String comando = "C://xampp//mysql//bin//mysqldump -u " + usuario + " -p" + senha + "farmacia";
            // Execução do comando e escrita do resultado no arquivo de backup
            Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            FileWriter writer = new FileWriter(new File(caminhoArquivoBackup));
            String linha;
            while ((linha = reader.readLine()) != null) {
                writer.write(linha + "\n");
            }
            writer.flush();
            writer.close();
            reader.close();
            processo.waitFor();
            JOptionPane.showMessageDialog(null,"Backup do banco de dados concluído com sucesso!");
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null,"Erro ao fazer backup do banco de dados!");
            e.printStackTrace();
        }
        
        
        
        
    }
}
