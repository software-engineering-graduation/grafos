package com.grafos.lista1.interfaces;

import java.util.List;

/**
* Interface que define o contrato para um grafo.
*/
public interface IGrafo {

   /**
    * Adiciona um vértice ao grafo.
    * @param vertice O vértice a ser adicionado.
    */
   void adicionarVertice(Vertice vertice);

   /**
    * Remove um vértice do grafo.
    * @param vertice O vértice a ser removido.
    */
   void removerVertice(Vertice vertice);

   /**
    * Adiciona uma aresta entre dois vértices.
    * @param origem O vértice de origem da aresta.
    * @param destino O vértice de destino da aresta.
    */
   void adicionarAresta(Vertice origem, Vertice destino);

   /**
    * Remove uma aresta entre dois vértices.
    * @param origem O vértice de origem da aresta.
    * @param destino O vértice de destino da aresta.
    */
   void removerAresta(Vertice origem, Vertice destino);

   /**
    * Retorna a lista de vértices do grafo.
    * @return Uma lista contendo todos os vértices do grafo.
    */
   List<Vertice> getVertices();

   /**
    * Retorna a lista de arestas do grafo.
    * @return Uma lista contendo todas as arestas do grafo.
    */
   List<Aresta> getArestas();

   /**
    * Retorna a lista de vértices adjacentes a um determinado vértice.
    * @param vertice O vértice para o qual se deseja obter os adjacentes.
    * @return Uma lista contendo os vértices adjacentes.
    */
   List<Vertice> getAdjacentes(Vertice vertice);

   /**
    * Verifica se o grafo é simples (não possui laços nem arestas múltiplas).
    * @return `true` se o grafo for simples, `false` caso contrário.
    */
   boolean isSimples();

   /**
    * Verifica se dois vértices são adjacentes.
    * @param v1 O primeiro vértice.
    * @param v2 O segundo vértice.
    * @return `true` se os vértices forem adjacentes, `false` caso contrário.
    */
   boolean isAdjacente(Vertice v1, Vertice v2);

   /**
    * Retorna o grau de um vértice (número de arestas incidentes).
    * @param v O vértice para o qual se deseja obter o grau.
    * @return O grau do vértice.
    */
   int getGrau(Vertice v);

   /**
    * Verifica se um vértice é isolado (não possui arestas incidentes).
    * @param v O vértice a ser verificado.
    * @return `true` se o vértice for isolado, `false` caso contrário.
    */
   boolean isIsolado(Vertice v);

   /**
    * Verifica se um vértice é pendente (possui grau 1).
    * @param v O vértice a ser verificado.
    * @return `true` se o vértice for pendente, `false` caso contrário.
    */
   boolean isPendente(Vertice v);

   /**
    * Verifica se o grafo é regular (todos os vértices possuem o mesmo grau).
    * @return `true` se o grafo for regular, `false` caso contrário.
    */
   boolean isRegular();

   /**
    * Verifica se o grafo é completo (todos os vértices são adjacentes entre si).
    * @return `true` se o grafo for completo, `false` caso contrário.
    */
   boolean isCompleto();

   /**
    * Verifica se o grafo é nulo (não possui arestas).
    * @return `true` se o grafo for nulo, `false` caso contrário.
    */
   boolean isNulo();

   /**
    * Verifica se o grafo é linear (todos os vértices possuem grau 2 ou menos).
    * @return `true` se o grafo for linear, `false` caso contrário.
    */
   boolean isLinear();

   /**
    * Remove um vértice e suas arestas incidentes do grafo.
    * @param v O vértice a ser removido.
    */
   void removeVertice(Vertice v);

   /**
    * Retorna o grafo complementar.
    * @return Um novo grafo que é o complementar do grafo original.
    */
   IGrafo getComplementar();

   /**
    * Verifica se o grafo é conexo (existe um caminho entre qualquer par de vértices).
    * @return `true` se o grafo for conexo, `false` caso contrário.
    */
   boolean isConexo();

   /**
    * Retorna o número de componentes conexas do grafo.
    * @return O número de componentes conexas.
    */
   int getNumComponentes();

   /**
    * Verifica se o grafo é bipartido (seus vértices podem ser divididos em dois conjuntos independentes).
    * @return `true` se o grafo for bipartido, `false` caso contrário.
    */
   boolean isBipartido();

   /**
    * Verifica se o grafo é bipartido completo.
    * @return `true` se o grafo for bipartido completo, `false` caso contrário.
    */
   boolean isBipartidoCompleto();

   /**
    * Verifica se o grafo possui ciclo.
    * @return `true` se o grafo possui ciclo, `false` caso contrário.
    */
   boolean hasCiclo();
}
