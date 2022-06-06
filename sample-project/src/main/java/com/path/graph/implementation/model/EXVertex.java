package com.path.graph.implementation.model;



import com.yieldster.yieldstergraph.abstractions.YieldsterEdge;
import com.yieldster.yieldstergraph.abstractions.YieldsterVertex;
import com.yieldster.yieldstergraph.enums.TokenProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EXVertex extends YieldsterVertex {

    private String id;
    private String name;
    private boolean isTerminal;
    Map<TokenProperties,Object> properties;
    List<YieldsterEdge> fromEdges = new ArrayList<>();
    List<YieldsterEdge> toEdges = new ArrayList<>();

    public EXVertex(String name, Map<TokenProperties, Object> properties) {
        this.name = name;
        this.properties = properties;
    }

    @Override
    public String getVertexId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<TokenProperties, Object> getProperties() {
        return properties;
    }

    @Override
    public boolean isTerminal() {
        return isTerminal;
    }

    @Override
    public List<YieldsterEdge> getFromEdges() {
        return fromEdges;
    }

    @Override
    public List<YieldsterEdge> getToEdges() {
        return toEdges;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }

    public void setProperties(Map<TokenProperties, Object> properties) {
        this.properties = properties;
    }

    public void setFromEdges(List<YieldsterEdge> fromEdges) {
        this.fromEdges = fromEdges;
    }

    public void setToEdges(List<YieldsterEdge> toEdges) {
        this.toEdges = toEdges;
    }

    @Override
    public String toString() {
        return "EXVertex{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
