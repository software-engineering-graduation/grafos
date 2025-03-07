package com.grafos.lista1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorGrafo {
    // Exemplo de arquivo de entrada:
    // 3
    // 0 1 0
    // 0 0 1
    // 0 0 0
    // Onde a primeira linha indica o número de vértices do grafo e as linhas seguintes representam a matriz de adjacência.
	public static int[][] lerGrafo(String caminhoArquivo) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				linha = linha.trim();
				if (linha.isEmpty() || linha.startsWith("#")) continue;
				
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
					if (valores.length != tamanho) throw new IOException("Número incorreto de valores na linha " + (i + 1));
					
					for (int j = 0; j < tamanho; j++) {
						matriz[i][j] = Integer.parseInt(valores[j]);
					}
				}
				return matriz;
			}
			throw new IOException("Arquivo vazio ou mal formatado");
		}
	}
}
