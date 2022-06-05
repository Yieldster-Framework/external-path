package com.path.graph.implementation.model;


import com.path.graph.implementation.model.error.YieldsterGraphException;
import com.yieldster.yieldstergraph.abstractions.YieldsterEdge;
import com.yieldster.yieldstergraph.abstractions.YieldsterGraph;
import com.yieldster.yieldstergraph.abstractions.YieldsterVertex;
import com.yieldster.yieldstergraph.enums.TokenProperties;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ExGraph extends YieldsterGraph {

    private String id;

    private String name;

    private CopyOnWriteArrayList<EXVertex> vertices = new CopyOnWriteArrayList<>();

    private CopyOnWriteArrayList<ExEdge> edges = new CopyOnWriteArrayList<>();

    private List<Path> paths = new ArrayList();

    public ExGraph(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getGraphId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<YieldsterVertex> getVertices() {
        if(vertices == null|| vertices.isEmpty()){
            return new ArrayList<>();
        }
        return vertices
                .stream()
                .map(e -> (YieldsterVertex) e)
                .collect(Collectors.toList());
    }

    @Override
    public List<YieldsterEdge> getEdges() {
        if(edges == null|| edges.isEmpty()){
            return new ArrayList<>();
        }
        return edges
                .stream()
                .map(e -> (YieldsterEdge) e)
                .collect(Collectors.toList());
    }

    @Override
    public YieldsterGraph getGraphInstance() {
        try {
            return (YieldsterGraph) createGraphInstance() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExGraph createGraphInstance() throws Exception {
        ConstructGraph obj = new ConstructGraph();
        return obj.constructGraph();
    }

    public void addVertex(EXVertex vertex)throws YieldsterGraphException {
        // add new vertex to 'vertices'
        Integer flag =0;
        List<YieldsterVertex> duplicates = vertices.stream().filter(v->v.getProperties().get(TokenProperties.tokenAddress).equals(vertex.getProperties().get(TokenProperties.tokenAddress))).collect(Collectors.toList());
        if(duplicates  != null && !duplicates.isEmpty()){
            throw new YieldsterGraphException("A vertex with the address "+vertex.getProperties().get(TokenProperties.tokenAddress)+" already exists");
        }
        vertices.add(vertex);

    }

    public void addEdge(ExEdge edge) throws YieldsterGraphException {


        if(vertices == null || vertices.size()<2){
            throw new YieldsterGraphException("At least two vertices are required to create an edge");
        }

        List duplicateEdge = edges.stream().filter(e->e.getName().equals(edge.getName())).collect(Collectors.toList());
        if(duplicateEdge != null && !duplicateEdge.isEmpty()){
            throw new YieldsterGraphException("Edge with name "+edge.getName()+" already exists");
        }

        List startNameCheck = vertices.stream().filter(v->v.getName().equals(edge.getStartVertexName())).collect(Collectors.toList());
        List endNameCheck = vertices.stream().filter(v->v.getName().equals(edge.getEndVertexName())).collect(Collectors.toList());


        if( startNameCheck != null && !startNameCheck.isEmpty() && endNameCheck != null && !endNameCheck.isEmpty()){

            ((ExEdge)edge).setStartVertex((YieldsterVertex) startNameCheck.get(0));
            ((ExEdge)edge).setEndVertex((YieldsterVertex) endNameCheck.get(0));
            vertices.forEach(v->{
                //Update fromEdges of source vertex of the edge
                if(v.getName().equals(edge.getStartVertexName())){
                    List fromEdges = v.getFromEdges();
                    fromEdges.add(edge);
                    try{
                        v.setFromEdges(fromEdges);
                    }
                    catch(Exception e){
                        System.out.println("error is: "+e);
                    }

                    //update adjacentVertices of the source vertex
//                    List adjVertices = v.getAdjVertices();
//                    adjVertices.add(new AdjacentVertex(edge,edge.getEndVertex(), Direction.OUT));
//                    ((ProtocolVertex)v).setAdjVertices(adjVertices);
                }
                //update toEdges of end vertex of the edge
                if(v.getName().equals(edge.getEndVertexName())){
                    List toEdges = v.getToEdges();
                    toEdges.add(edge);
                    v.setToEdges(toEdges);

                    //update adjacentVertices of the end vertex
//                    List adjVertices = v.getAdjVertices();
//                    adjVertices.add(new AdjacentVertex(edge,edge.getStartVertex(),Direction.IN));
//                    ((ProtocolVertex)v).setAdjVertices(adjVertices);
                }
            });
            //Add edge to edges list
            edges.add(edge);

        }else {
            throw new YieldsterGraphException("Given vertex not found in graph");
        }
    }

    @Override
    public String toString() {
        return "ExGraph{" +
                "id='" + id + '\'' +
                ", name='" + name +
                '}';
    }
}

