package com.grafos.lista1.interfaces;

/**
* Interface que define o contrato para uma aresta de um grafo.
*/
public interface Aresta {

    /**
     * Retorna o vértice de origem da aresta.
     * @return O vértice de origem.
     */
    Vertice getOrigem();
 
    /**
     * Retorna o vértice de destino da aresta.
     * @return O vértice de destino.
     */
    Vertice getDestino();
}