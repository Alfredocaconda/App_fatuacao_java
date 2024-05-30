/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author TEODORO
 */
public class Extra {
    
        File f = new File("C:/App_faturacao/Extras/categoria.txt");
    public void guardarArquivo( String dados){
        File ff = new File("C:/App_faturacao/Extras");
        
        ff.mkdir();
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(dados+"\n");
            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
     public ArrayList<String> lerArquivo(){
        
        ArrayList<String> dados = new ArrayList<>();
        try {
         Scanner s = new Scanner(f);
            while (s.hasNextLine()) {                
                dados.add(s.nextLine());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
      return dados;
    }
}
