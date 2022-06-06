package com.path.graph.implementation.model;


import com.yieldster.yieldstergraph.abstractions.YieldsterEdge;
import com.yieldster.yieldstergraph.abstractions.YieldsterEstimationResponse;
import com.yieldster.yieldstergraph.abstractions.YieldsterExecutionResponse;
import com.yieldster.yieldstergraph.abstractions.YieldsterVertex;
import com.yieldster.yieldstergraph.enums.EdgeProperties;

import org.bson.types.ObjectId;
import org.web3j.crypto.Credentials;

import java.math.BigInteger;
import java.util.Map;

public class ExEdge extends YieldsterEdge {

    private String id;
    private String name;
    private Map<EdgeProperties,Object> properties;
    private String startVertexName;
    private String endVertexName;
    private YieldsterVertex startVertex;
    private YieldsterVertex endVertex;

    private Credentials credentials;

    public ExEdge(String name, Map<EdgeProperties, Object> properties, String startVertexName, String endVertexName) {
        ObjectId objectId = new ObjectId();
        this.id = objectId.toHexString();
        this.name = name;//notnull
        this.properties = properties;
        this.startVertexName = startVertexName;//notnull
        this.endVertexName = endVertexName;//notnull
    }

    @Override
    public String getEdgeId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public YieldsterVertex getStartVertex() {
        return startVertex;
    }

    @Override
    public String getEndVertexName() {
        return endVertexName;
    }

    @Override
    public String getStartVertexName() {
        return startVertexName;
    }

    @Override
    public Map<EdgeProperties, Object> getProperties() {
        return properties;
    }

    @Override
    public YieldsterVertex getEndVertex() {
        return endVertex;
    }

    @Override
    public void getCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProperties(Map<EdgeProperties, Object> properties) {
        this.properties = properties;
    }

    public void setStartVertexName(String startVertexName) {
        this.startVertexName = startVertexName;
    }

    public void setEndVertexName(String endVertexName) {
        this.endVertexName = endVertexName;
    }

    public void setStartVertex(YieldsterVertex startVertex) {
        this.startVertex = startVertex;
    }

    public void setEndVertex(YieldsterVertex endVertex) {
        this.endVertex = endVertex;
    }

    @Override
    public YieldsterEstimationResponse estimate(BigInteger inputAssetAmount, BigInteger outputAssetAmount, String vaultAddress){
        // logic to estimate the estimated return when we swap x(inputAssetAmount) of coin A to coin B
        return null;
    }

    @Override
    public YieldsterExecutionResponse execute(BigInteger inputAssetAmount, BigInteger outputAssetAmount, String vaultAddress) {
        //logic to execute the swap/transformation operation from coin A to coin B
        return null;
    }

    @Override
    public String toString() {
        return "ExEdge{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startVertexName='" + startVertexName + '\'' +
                ", endVertexName='" + endVertexName + '\'' +
                '}';
    }
}
