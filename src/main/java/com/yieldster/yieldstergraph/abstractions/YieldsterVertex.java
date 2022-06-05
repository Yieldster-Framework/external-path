package com.yieldster.yieldstergraph.abstractions;



import com.yieldster.yieldstergraph.enums.TokenProperties;

import java.util.List;
import java.util.Map;

public abstract class YieldsterVertex {

    //todo setup provider id?
    public abstract String getVertexId();

    public abstract String getName();       //

    public abstract Map<TokenProperties,Object> getProperties();        //

    public abstract boolean isTerminal();       //

    public abstract List<YieldsterEdge> getFromEdges();

    public abstract List<YieldsterEdge> getToEdges();
}
