# Conceitos de Grafos

Este documento explica os conceitos fundamentais de grafos utilizados neste projeto.

## Definição

Um grafo é uma estrutura de dados composta por:

*   **Vértices (ou nós):** Representam objetos.
*   **Arestas:** Representam as relações entre os vértices.

## Tipos de Grafos

*   **Direcionado:** As arestas têm uma direção (origem -> destino).
*   **Não Direcionado:** As arestas não têm direção.
*   **Simples:** Não possui laços (arestas que ligam um vértice a ele mesmo) nem arestas múltiplas (mais de uma aresta entre o mesmo par de vértices).
*   **Regular:** Todos os vértices têm o mesmo grau.
*   **Completo:** Todos os vértices são adjacentes entre si.
*   **Bipartido:** Os vértices podem ser divididos em dois conjuntos independentes, de forma que todas as arestas conectem vértices de conjuntos diferentes.
*   **Conexo:** Existe um caminho entre qualquer par de vértices.

## Propriedades

*   **Grau de um Vértice:** Número de arestas incidentes a um vértice.
*   **Vértice Isolado:** Vértice com grau 0.
*   **Vértice Pendente:** Vértice com grau 1.
*   **Adjacência:** Dois vértices são adjacentes se existe uma aresta entre eles.
*   **Ciclo:** Um caminho que começa e termina no mesmo vértice.
*   **Componente Conexa:** Um subgrafo conexo maximal.

## Métodos da Interface `Grafo`

A interface `Grafo` define os seguintes métodos para manipular e analisar grafos:

*   `adicionarVertice(Vertice vertice)`: Adiciona um vértice ao grafo.
*   `removerVertice(Vertice vertice)`: Remove um vértice do grafo.
*   `adicionarAresta(Vertice origem, Vertice destino)`: Adiciona uma aresta entre dois vértices.
*   `removerAresta(Vertice origem, Vertice destino)`: Remove uma aresta entre dois vértices.
*   `getVertices()`: Retorna a lista de vértices do grafo.
*   `getArestas()`: Retorna a lista de arestas do grafo.
*   `getAdjacentes(Vertice vertice)`: Retorna a lista de vértices adjacentes a um determinado vértice.
*   `isSimples()`: Verifica se o grafo é simples.
*   `isAdjacente(Vertice v1, Vertice v2)`: Verifica se dois vértices são adjacentes.
*   `getGrau(Vertice v)`: Retorna o grau de um vértice.
*   `isIsolado(Vertice v)`: Verifica se um vértice é isolado.
*   `isPendente(Vertice v)`: Verifica se um vértice é pendente.
*   `isRegular()`: Verifica se o grafo é regular.
*   `isCompleto()`: Verifica se o grafo é completo.
*   `isNulo()`: Verifica se o grafo é nulo.
*   `isLinear()`: Verifica se o grafo é linear.
*   `removeVertice(Vertice v)`: Remove um vértice e suas arestas incidentes do grafo.
*   `getComplementar()`: Retorna o grafo complementar.
*   `isConexo()`: Verifica se o grafo é conexo.
*   `getNumComponentes()`: Retorna o número de componentes conexas do grafo.
*   `isBipartido()`: Verifica se o grafo é bipartido.
*   `isBipartidoCompleto()`: Verifica se o grafo é bipartido completo.
*   `hasCiclo()`: Verifica se o grafo possui ciclo.