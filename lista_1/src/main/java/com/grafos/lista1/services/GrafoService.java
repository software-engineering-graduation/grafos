package com.grafos.lista1.services;

import com.grafos.lista1.interfaces.IGrafo;
import com.grafos.lista1.util.GrafoConverter;

public class GrafoService {
    public IGrafo createGrafo(String implementationType, int[][] matriz) {
        return implementationType.equals("Matriz de Adjacência") ? 
            GrafoConverter.matrixFromFile(matriz) :
            GrafoConverter.listFromFile(matriz);
    }

    public void verificarPropriedade(IGrafo grafo, int opcao) {
        switch (opcao) {
            case 2:
                System.out.println("É simples? " + (grafo.isSimples() ? "Sim" : "Não"));
                break;
            case 3:
                System.out.println("É completo? " + (grafo.isCompleto() ? "Sim" : "Não"));
                break;
            case 4:
                System.out.println("É regular? " + (grafo.isRegular() ? "Sim" : "Não"));
                break;
            case 5:
                System.out.println("É conexo? " + (grafo.isConexo() ? "Sim" : "Não"));
                break;
            case 6:
                System.out.println("É bipartido? " + (grafo.isBipartido() ? "Sim" : "Não"));
                break;
        }
    }
}
