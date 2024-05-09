/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.unipar.desktop.juliane.arquivo.txt;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class arquivo{

 
    public static void main(String[] args) {
        File arquivo = new File("C:\\Users\\diogo\\OneDrive\\Documents\\pasta-arquivo");

        try {
            // Criar arquivo (mesmo se já existir)
            arquivo.createNewFile();
            System.out.println("Arquivo criado");

            // Escrever tabuada no arquivo
            try (FileWriter escritor = new FileWriter(arquivo)) {
                try (BufferedWriter buffer = new BufferedWriter(escritor)) {
                    for (int i = 1; i < 10; i++) {
                        buffer.write("9 * " + i + " = " + 9 * i);
                        buffer.newLine();
                    }
                }
            }

            // Ler arquivo e imprimir conteúdo no console
            try (FileReader leitor = new FileReader(arquivo)) {
                try (BufferedReader buffer = new BufferedReader(leitor)) {
                    String linha;
                    while ((linha = buffer.readLine()) != null) {
                        System.out.println(linha);
                    }
                }
            }

            // Perguntar ao usuário se deseja excluir o arquivo
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o arquivo?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                if (arquivo.exists()) {
                    arquivo.delete();
                    System.out.println("Arquivo excluído");
                }
            } else {
                System.out.println("Arquivo não excluído");
            }

        } catch (IOException ex) {
            System.out.println("Erro ao criar ou manipular o arquivo:");
            ex.printStackTrace(); // Imprime a pilha de chamadas de erro
        }
    }
}

