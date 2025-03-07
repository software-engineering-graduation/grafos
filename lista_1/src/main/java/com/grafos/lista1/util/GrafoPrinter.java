package com.grafos.lista1.util;

import com.grafos.lista1.GrafoListaAdjacencia;
import com.grafos.lista1.GrafoMatrizAdjacencia;
import com.grafos.lista1.interfaces.Aresta;
import com.grafos.lista1.interfaces.IGrafo;
import com.grafos.lista1.interfaces.Vertice;

public class GrafoPrinter {
    
    public static void printGrafo(IGrafo grafo) {
        System.out.println(ConsoleColors.CYAN + "\n=== Visualização do Grafo ===" + ConsoleColors.RESET);

        // print complete graph as adjacency matrix or list depending on the implementation
        if (grafo instanceof GrafoMatrizAdjacencia) {
            printMatrix((GrafoMatrizAdjacencia) grafo);
        } else if (grafo instanceof GrafoListaAdjacencia) {
            printList((GrafoListaAdjacencia) grafo);
        }
        
        System.out.println(ConsoleColors.YELLOW + "\nVértices:" + ConsoleColors.RESET);
        for (Vertice v : grafo.getVertices()) {
            System.out.println("  • " + v.getId());
        }

        System.out.println(ConsoleColors.YELLOW + "\nArestas:" + ConsoleColors.RESET);
        for (Aresta a : grafo.getArestas()) {
            System.out.println("  • " + a.getOrigem().getId() + " → " + a.getDestino().getId());
        }
        System.out.println();
    }

    private static void printMatrix(GrafoMatrizAdjacencia grafo) {
        System.out.println(ConsoleColors.YELLOW + "\nMatriz de Adjacência:" + ConsoleColors.RESET);
        int[][] matriz = grafo.getMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printList(GrafoListaAdjacencia grafo) {
        System.out.println(ConsoleColors.YELLOW + "\nLista de Adjacência:" + ConsoleColors.RESET);
        for (Vertice v : grafo.getVertices()) {
            System.out.print(v.getId() + ": ");
            for (Aresta a : grafo.getArestas()) {
                if (a.getOrigem().equals(v)) {
                    System.out.print(a.getDestino().getId() + " ");
                }
            }
            System.out.println();
        }
    }
}
