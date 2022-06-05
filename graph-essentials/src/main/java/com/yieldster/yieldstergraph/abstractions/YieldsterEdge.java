package com.yieldster.yieldstergraph.abstractions;

import com.yieldster.yieldstergraph.enums.EdgeProperties;
import org.web3j.crypto.Credentials;

import java.math.BigInteger;
import java.util.Map;

public abstract class YieldsterEdge {

      ////todo setup provider id?
      public abstract String getEdgeId();

      public abstract String getName();

      public abstract YieldsterVertex getStartVertex();

      public abstract String getEndVertexName();
//
      public abstract String getStartVertexName();

      public abstract Map<EdgeProperties,Object> getProperties();

      public abstract YieldsterVertex getEndVertex();

      public abstract void getCredentials(Credentials credentials);

      public abstract YieldsterEstimationResponse estimate(BigInteger inputAssetAmount, BigInteger outputAssetAmount, String vaultAddress) throws InterruptedException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException;

      public abstract YieldsterExecutionResponse execute(BigInteger inputAssetAmount, BigInteger outputAssetAmount, String vaultAddress);







}
