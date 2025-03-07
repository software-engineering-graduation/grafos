package com.grafos.lista1.impl;

import com.grafos.lista1.interfaces.Aresta;
import com.grafos.lista1.interfaces.Vertice;

public class ArestaImpl implements Aresta {
    private final Vertice origem;
    private final Vertice destino;

    public ArestaImpl(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
    }

    @Override
    public Vertice getOrigem() {
        return origem;
    }

    @Override
    public Vertice getDestino() {
        return destino;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Aresta) {
            Aresta other = (Aresta) obj;
            return origem.equals(other.getOrigem()) && destino.equals(other.getDestino());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return origem.hashCode() * 31 + destino.hashCode();
    }
}
