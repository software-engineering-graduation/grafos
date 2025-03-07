# Arquivos de Entrada

[← Voltar para README](../README.md)

## Localização dos Arquivos

Os arquivos de entrada devem ser colocados no diretório:
```
/grafos/matriz/
```

## Formato do Arquivo

O arquivo deve seguir o seguinte formato:
```
# Comentários começam com #
N           # Número de vértices
a11 a12 ... a1N
a21 a22 ... a2N
... ... ... ...
aN1 aN2 ... aNN
```

Onde:
- A primeira linha não comentada contém o número N de vértices
- As próximas N linhas contêm a matriz de adjacência NxN
- Cada elemento aij representa a conexão entre os vértices i e j
- Use 0 para ausência de aresta e 1 para presença de aresta

## Exemplo

```
# Exemplo de grafo com 3 vértices
3
0 1 1
1 0 0
1 0 0
```

## Convenções

- Linhas em branco são ignoradas
- Comentários começam com # e são ignorados
- Valores devem ser separados por espaço
- Cada linha da matriz deve conter exatamente N valores
