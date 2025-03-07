package com.grafos.lista1.util;

import java.util.ArrayList;
import java.util.List;

import com.grafos.lista1.GrafoListaAdjacencia;
import com.grafos.lista1.GrafoMatrizAdjacencia;
import com.grafos.lista1.impl.ArestaImpl;
import com.grafos.lista1.impl.VerticeImpl;
import com.grafos.lista1.interfaces.Aresta;
import com.grafos.lista1.interfaces.Vertice;

public class GrafoConverter {
    
    public static GrafoMatrizAdjacencia matrixFromFile(int[][] matriz) {
        return new GrafoMatrizAdjacencia(matriz);
    }
    
    public static GrafoListaAdjacencia listFromFile(int[][] matriz) {
        List<Aresta> arestas = new ArrayList<>();
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 0) {
                    Vertice origem = new VerticeImpl(i);
                    Vertice destino = new VerticeImpl(j);
                    // Add the number of edges specified in the matrix
                    for (int k = 0; k < matriz[i][j]; k++) {
                        arestas.add(new ArestaImpl(origem, destino));
                    }
                }
            }
        }
        
        return new GrafoListaAdjacencia(arestas);
    }
}
