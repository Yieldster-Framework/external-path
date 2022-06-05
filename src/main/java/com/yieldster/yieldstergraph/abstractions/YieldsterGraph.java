package com.yieldster.yieldstergraph.abstractions;

import java.util.List;

public abstract class YieldsterGraph {

    public abstract String getGraphId();

    public abstract String getName();

    public abstract List<YieldsterVertex> getVertices();

    public abstract List<YieldsterEdge>  getEdges();

    public abstract YieldsterGraph getGraphInstance();



}
