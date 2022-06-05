package com.yieldster.yieldstergraph.abstractions;

public abstract class YieldsterExecutionResponse {


    public abstract Integer getStatusCode();
    public abstract void setStatusCode(Integer statusCode);



    public abstract Object getError();
    public abstract void setError(Object error);



    public abstract Object getData();
    public abstract void setData(Object data);



    public abstract String getMessage();
    public abstract void setMessage(String message);



    public abstract Boolean getExecutionStatus();
    public abstract void setExecutionStatus(Boolean executionStatus);



    public abstract String getTransactionHash();
    public abstract void setTransactionHash(String transactionHash);

}
