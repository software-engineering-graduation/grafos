package com.grafos.lista1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorGrafo {
    public static class GrafoInfo {
        public final String nome;
        public final int[][] matriz;

        public GrafoInfo(String nome, int[][] matriz) {
            this.nome = nome;
            this.matriz = matriz;
        }
    }

    public static List<GrafoInfo> lerGrafos(String caminhoArquivo) throws IOException {
        List<GrafoInfo> grafos = new ArrayList<>();
        String currentName = "Grafo sem nome";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;
                
                if (linha.startsWith("#")) {
                    currentName = linha.substring(1).trim();
                    continue;
                }
                
                int tamanho = Integer.parseInt(linha);
                int[][] matriz = new int[tamanho][tamanho];
                
                for (int i = 0; i < tamanho; i++) {
                    while ((linha = reader.readLine()) != null) {
                        linha = linha.trim();
                        if (linha.isEmpty() || linha.startsWith("#")) continue;
                        break;
                    }
                    if (linha == null) throw new IOException("Arquivo incompleto");
                    
                    String[] valores = linha.split("\\s+");
                    if (valores.length != tamanho) 
                        throw new IOException("Número incorreto de valores na linha " + (i + 1));
                    
                    for (int j = 0; j < tamanho; j++) {
                        matriz[i][j] = Integer.parseInt(valores[j]);
                    }
                }
                grafos.add(new GrafoInfo(currentName, matriz));
                currentName = "Grafo sem nome";
            }
            
            if (grafos.isEmpty()) throw new IOException("Arquivo vazio ou mal formatado");
            return grafos;
        }
    }
}
