# Yieldster Graph Abstraction

The Yieldster abstraction classes was developed for 3rd party developers, inorder for them to develop external paths containing vertices and edges other than the ones currently present in our framework. This gives them the privilege to develop swap strategies between tokens which the developers believe would produce best results than the existing swap functionalities.

The abstraction class contains 2 different packages:

- abstractions
- enums

The abstractions contains several abstract classes which are expected to be extended by the external JAR developer and implement methods that are present in those abstract classes in their classes so that the main project could access these functions for processing an external JAR.

The abstract classes contained in the yieldster-graph JAR are:

- YieldsterEdge
- YieldsterVertex
- YieldsterGraph
- YieldsterEstmationResponse
- YieldsterExecutionResponse

### **Abstract Classes**

### YieldsterEdge:

This class contains the following functions:

- `getEdgeId()`: returns the Id of the edge of type string
- `getName()` : returns the name of the edge of type string
- `getStartVertex()` : returns the start vertex of the edge of type YieldsterVertex
- `getStartVertexName()` : returns the start vertex name of the edge of type string
- `getEndVertex()` : returns the end vertex of the edge of type YieldsterVertex
- `getEndVertexName()` : returns the end vertex name of the edge of type string
- `getProperties()` : returns the properties that the edge hold of type Map<EdgeProperties,Object>
- `estimate(BigInteger inputAssetAmount, BigInteger outputAssetAmount, String vaultAddress)` : returns the estimated value after executing a swap/any transformation operation using the current edge. Return type is YieldsterEstimationResponse
- `execute(BigInteger inputAssetAmount, BigInteger outputAssetAmount, String vaultAddress)` : execute a swap/transformation operation by swapping x number of(represented as `inputAssetAmount`) initial token represented by the edge to y number of final token represented by the edge. Return type is YieldsterExecutionResponse

### YieldsterVertex:

- `getVertexId()` : returns the Id of the vertex of type string
- `getName()` : returns the name of the edge of type string
- `getProperties()` : returns the properties that the edge hold of type Map<TokenProperties,Object>
- `isTerminal()` : returns wheather a vertex is the terminal vertex of type boolean
- `getFromEdges()` : returns a list of edges that start from this vertex. Return type is List<YieldsterEdge>
- `getToEdges()` : returns a list of edges that move towards this vertex. Return type is List<YieldsterEdge>

### YieldsterGraph:

- `getGraphId()` : returns the Id of the graph of type string
- `getName()` : returns the name of the graph of type string
- `getVertices()` : returns a list of vertices present in the graph. Return type is List<YieldsterVertex>
- `getEdges()` : returns a list of edgess present in the graph. Return type is List<YieldsterEdge>
- `getGraphInstance()` : returns an instance of the graph with all necessary graph details and values in it. Return type is YieldsterGraph

### YieldsterEstimationResponse:

- `getStatusCode()` : returns status code of type Integer
- `setStatusCode(Integer statusCode)` : set the status code
- `getError()` : returns the error of type Object
- `setError(Object error)` : set the error object
- `getData()` : returns the data part of type Object
- `setData(Object data)` : set the data part
- `getMessage()` : returns the message of type String
- `setMessage(String message)` : set the message
- `getExecutionStatus()` : returns execution status of type Boolean
- `setExecutionStatus(Boolean executionStatus)` : set the execution status
- `getTransactionHash()` : returns the transaction hash of type String
- `setTransactionHash(String transactionHash)` : set the transaction hash

### YieldsterExecutionResponse:

- `getStatusCode()` : returns status code of type Integer
- `setStatusCode(Integer statusCode)` : set the status code
- `getError()` : returns the error of type Object
- `setError(Object error)` : set the error object
- `getData()` : returns the data part of type Object
- `setData(Object data)` : set the data part
- `getMessage()` : returns the message of type String
- `setMessage(String message)` : set the message
- `getExecutionStatus()` : returns execution status of type Boolean
- `setExecutionStatus(Boolean executionStatus)` : set the execution status
- `getTransactionHash()` : returns the transaction hash of type String
- `setTransactionHash(String transactionHash)` : set the transaction hash

### Enum

### EdgeProperties

- *`poolName` : name of the pool that is being interacted by this edge (Optional)*
- *`version` : version of the protocol being used (Optional)*
- *`initialToken` : name of the token that we are trying to swap using this edge*
- *`finalToken` : name of the token that we will get back once this edge is executed*
- *`protocolName` : name of the protocol whose pool we are using in the current edge*
- *`poolAddress` : address of the pool  being used*
- *`poolType` : describes what type of pool we are using for the operation. Eg:Curve,Uniswap etc..*
- *`operationType` : specifies wheather the operation is deposit/withdraw*
- *`poolList` : List of protocols we are using in this edge operation*
- *`poolId` : id of the pool into which we are initiating the swap/changing liquidity operations*
- *`isStake` : boolean that depicts wheather the execution of the current edge results in a staking operation or not. True if we are staking, false if not. This is required*
- *`stakingContract` : address of the contract to be staked. Should be provided if isStake is true*

### TokenProperties

- *`tokenAddress` : address of the crypto token*
- *`decimal` : decimal of the crypto token*
