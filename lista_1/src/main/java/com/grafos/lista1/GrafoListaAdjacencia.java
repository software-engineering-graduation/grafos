package com.grafos.lista1;

import java.util.ArrayList;
import java.util.List;

import com.grafos.lista1.interfaces.Aresta;
import com.grafos.lista1.interfaces.IGrafo;
import com.grafos.lista1.interfaces.Vertice;

public class GrafoListaAdjacencia implements IGrafo {

    List<Aresta> arestas;
    private List<Vertice> vertices;

    public GrafoListaAdjacencia(List<Aresta> arestas) {
        this.arestas = new ArrayList<>(arestas);
        this.vertices = new ArrayList<>();
        
        // Extract vertices from edges
        for (Aresta aresta : arestas) {
            if (!vertices.contains(aresta.getOrigem())) {
                vertices.add(aresta.getOrigem());
            }
            if (!vertices.contains(aresta.getDestino())) {
                vertices.add(aresta.getDestino());
            }
        }
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
        return new ArrayList<>(vertices);
    }

    @Override
    public List<Aresta> getArestas() {
        return new ArrayList<>(arestas);
    }

    @Override
    public List<Vertice> getAdjacentes(Vertice vertice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdjacentes'");
    }

    @Override
    public boolean isSimples() {
        if(arestas.stream().anyMatch(a -> a.getOrigem().equals(a.getDestino()))) {
            return false;
        }
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
