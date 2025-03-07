package com.grafos.lista1;

import java.util.ArrayList;
import java.util.List;

import com.grafos.lista1.impl.ArestaImpl;
import com.grafos.lista1.impl.VerticeImpl;
import com.grafos.lista1.interfaces.Aresta;
import com.grafos.lista1.interfaces.IGrafo;
import com.grafos.lista1.interfaces.Vertice;

public class GrafoMatrizAdjacencia implements IGrafo {

    private int[][] matrizAdjacencia;

    /**
     * Construtor da classe GrafoMatrizAdjacencia que implementa um grafo usando matriz de adjacência.
     * A matriz é inicializada com zeros, onde:
     * - matrizAdjacencia[i][j] = 0 significa que não há aresta entre os vértices i e j
     * - matrizAdjacencia[i][j] = 1 significa que existe uma aresta entre os vértices i e j
     * - matrizAdjacencia[i][j] > 1 indica múltiplas arestas entre i e j (multigrafo)
     * 
     * Exemplo para um grafo com 3 vértices onde existe uma aresta entre v0->v1 e v1->v2:
     * [0 1 0]
     * [0 0 1]
     * [0 0 0]
     *
     * @param numVertices Número de vértices do grafo.
     */
    public GrafoMatrizAdjacencia(int numVertices) {
        matrizAdjacencia = new int[numVertices][numVertices];
    }

    /**
     * Construtor que inicializa um grafo a partir de uma matriz de adjacência.
     * 
     * @param matrizAdjacencia matriz de inteiros que representa as conexões entre os vértices do grafo,
     *                         onde o elemento [i][j] indica se existe uma aresta do vértice i para o vértice j
     */
    public GrafoMatrizAdjacencia(int[][] matrizAdjacencia) {
        this.matrizAdjacencia = matrizAdjacencia;
    }

    public void setMatrizAdjacencia(int[][] matrizAdjacencia) {
        this.matrizAdjacencia = matrizAdjacencia;
    }

    public int[][] getMatriz() {
        return matrizAdjacencia;
    }

    @Override
    public void adicionarVertice(Vertice vertice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarVertice'");
    }

    @Override
    public void removerVertice(Vertice vertice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerVertice'");
    }

    @Override
    public void adicionarAresta(Vertice origem, Vertice destino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarAresta'");
    }

    @Override
    public void removerAresta(Vertice origem, Vertice destino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerAresta'");
    }

    @Override
    public List<Vertice> getVertices() {
        List<Vertice> vertices = new ArrayList<>();
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            vertices.add(new VerticeImpl(i));
        }
        return vertices;
    }

    @Override
    public List<Aresta> getArestas() {
        List<Aresta> arestas = new ArrayList<>();
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (matrizAdjacencia[i][j] > 0) {
                    Vertice origem = new VerticeImpl(i);
                    Vertice destino = new VerticeImpl(j);
                    arestas.add(new ArestaImpl(origem, destino));
                }
            }
        }
        return arestas;
    }

    @Override
    public List<Vertice> getAdjacentes(Vertice vertice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdjacentes'");
    }

    @Override
    /**
     * Verifica se o grafo é simples.
     * Um grafo é simples se não possui laços (arestas que conectam um vértice a ele mesmo)
     * 
     * Um grafo também pode ser identificado como não simples se possuir
     * arestas múltiplas entre os mesmos vértices (arestas paralelas), entretanto
     * a matriz de adjacência não permite representar arestas paralelas.
     * 
     * @return true se o grafo for simples, false caso contrário
     */
    public boolean isSimples() {
        System.out.println("Verificando se o grafo é simples...");
        
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            // Verifica laços
            if (matrizAdjacencia[i][i] != 0) {
                System.out.println("Grafo não é simples: possui laço no vértice " + i);
                return false;
            }
        }

        System.out.println("O grafo é simples");
        return true;
    }

    @Override
    public boolean isAdjacente(Vertice v1, Vertice v2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAdjacente'");
    }

    @Override
    public int getGrau(Vertice v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGrau'");
    }

    @Override
    public boolean isIsolado(Vertice v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isIsolado'");
    }

    @Override
    public boolean isPendente(Vertice v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPendente'");
    }

    @Override
    public boolean isRegular() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRegular'");
    }

    @Override
    public boolean isCompleto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCompleto'");
    }

    @Override
    public boolean isNulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNulo'");
    }

    @Override
    public boolean isLinear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isLinear'");
    }

    @Override
    public void removeVertice(Vertice v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeVertice'");
    }

    @Override
    public IGrafo getComplementar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComplementar'");
    }

    @Override
    public boolean isConexo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isConexo'");
    }

    @Override
    public int getNumComponentes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumComponentes'");
    }

    @Override
    public boolean isBipartido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBipartido'");
    }

    @Override
    public boolean isBipartidoCompleto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBipartidoCompleto'");
    }

    @Override
    public boolean hasCiclo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasCiclo'");
    }
    
}
