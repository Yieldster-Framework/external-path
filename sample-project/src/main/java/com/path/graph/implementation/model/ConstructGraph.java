package com.path.graph.implementation.model;


import com.yieldster.yieldstergraph.enums.EdgeProperties;
import com.yieldster.yieldstergraph.enums.TokenProperties;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class ConstructGraph {

    ExGraph exGraph = new ExGraph("11231212","NewProtocolGraph");

    public ExGraph constructGraph(){
        try{
            constructVertices();
            constructEdges();
            return exGraph;
        }
        catch(Exception e){
            System.out.println("Error occured: "+e.getMessage());
            return null;
        }
    }

    public void constructVertices() throws Exception {
        addGraphVertex("sample-project/src/main/java/com/path/graph/implementation/InputFiles/Vertex.txt");
    }

    public void constructEdges() throws Exception {
        //add logic to add edges
        addEdge("sample-project/src/main/java/com/path/graph/implementation/InputFiles/Edges.txt");
    }

    private void addGraphVertex(String fileName) throws Exception {
//        InputStream file = this.getClass().getClassLoader().getResourceAsStream(fileName);
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int i = 0;
        while (sc.hasNextLine()) {
            String vertexData = sc.nextLine();
            String[] vertexDetails = vertexData.split(",", -2);
            try{
                exGraph.addVertex(new EXVertex(vertexDetails[0], new HashMap() {
                    {
                        put(TokenProperties.tokenAddress, vertexDetails[1]);
                        put(TokenProperties.decimal, vertexDetails[2]);
                    }
                }));
            }
            catch(Exception e){
                System.out.println("exception: "+e);
            }
        }
    }

    public void addEdge(String fileName) throws Exception {
        File file = new File(fileName);
//        File file = new File(getClass().getResource(fileName).getFile());
//        InputStream file = this.getClass().getClassLoader().getResourceAsStream(fileName);
//        String data = readFromInputStream(is);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                this.getClass().getResourceAsStream(fileName)));


//        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int j = 0;
        while (sc.hasNextLine()) {
            String EdgeData = sc.nextLine();
            String[] vertexDetails = EdgeData.split(",", -2);
            String edgeName = vertexDetails[0]+"/"+vertexDetails[1];

            exGraph.addEdge(new ExEdge(edgeName, new HashMap() {
                {
                    put(EdgeProperties.initialToken, vertexDetails[0]);
                    put(EdgeProperties.finalToken, vertexDetails[1]);
                }
            }, vertexDetails[0], vertexDetails[1]));
        }
    }


}
