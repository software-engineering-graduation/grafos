package com.grafos.lista1.impl;

import com.grafos.lista1.interfaces.Vertice;

public class VerticeImpl implements Vertice {
    private final Integer id;

    public VerticeImpl(Integer id) {
        this.id = id;
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertice) {
            return getId().equals(((Vertice) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
