package com.path.graph.implementation.model;

import com.yieldster.yieldstergraph.abstractions.YieldsterExecutionResponse;

public class ExExecutionResponse extends YieldsterExecutionResponse {
    Object data;
    String message;
    String transactionHash;
    Object error;
    Integer statusCode;
    Boolean executionStatus;

    @Override
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    @Override
    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public Boolean getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(Boolean executionStatus) {
        this.executionStatus = executionStatus;
    }
}
