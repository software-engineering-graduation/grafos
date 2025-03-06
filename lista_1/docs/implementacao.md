# Detalhes da Implementação

Este documento descreve os detalhes da implementação das interfaces `Grafo`, `Vertice` e `Aresta`.

## Interfaces

*   **`IGrafo`:** Define o contrato para um grafo.  Métodos para adicionar/remover vértices e arestas, verificar propriedades do grafo (simples, regular, completo, etc.), e realizar operações como obter o grafo complementar e verificar a conectividade.
*   **`IVertice`:** Define o contrato para um vértice.  Possui um método `getId()` para retornar o identificador único do vértice.
*   **`IAresta`:** Define o contrato para uma aresta.  Possui métodos `getOrigem()` e `getDestino()` para retornar os vértices de origem e destino da aresta.

## Implementações

Este projeto deve incluir pelo menos duas implementações da interface `Grafo`:

*   **`GrafoListaAdjacencia`:** Implementa o grafo usando listas de adjacência.
*   **`GrafoMatrizAdjacencia`:** Implementa o grafo usando uma matriz de adjacência.