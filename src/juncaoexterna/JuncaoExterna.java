package juncaoexterna;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Paim
 * @author Vinicius Leal
 */
public class JuncaoExterna {
    
    public ArrayList<String> tabelaPalavrasReservadas = new ArrayList<>();
    public BufferedReader fita;

    public JuncaoExterna(String file) {
        try {
            ReadFile(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Informe um arquivo de banco válido");
        }
        
        tabelaPalavrasReservadas.add("t_signal");
        tabelaPalavrasReservadas.add("p_signal");
    }
    
    public void nextToken() {
        try {
            String line = fita.readLine();
        
            while (line != null) {
                for (StringTokenizer stringTokenizer = new StringTokenizer(line);stringTokenizer.hasMoreTokens();) {
                    String token = stringTokenizer.nextToken();
                    System.out.println(token);
                }
            }
            
        } catch (IOException ex) {
            System.out.println("Erro ao ler arquivo de banco.");
        } 
    }
    
    public void ReadFile (String file) throws FileNotFoundException {
        FileInputStream stream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(stream);
        fita = new BufferedReader(reader);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        JuncaoExterna lex = new JuncaoExterna(args[0]);
    }
    
}
