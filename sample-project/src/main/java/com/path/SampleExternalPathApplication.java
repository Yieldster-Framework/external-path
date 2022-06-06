package com.path;

import com.path.graph.implementation.model.ExGraph;
import com.yieldster.yieldstergraph.abstractions.YieldsterGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleExternalPathApplication {

	private static final Logger logger = LoggerFactory.getLogger(SampleExternalPathApplication.class);

	public static void main(String[] args) {SpringApplication.run(SampleExternalPathApplication.class, args);
		ExGraph graph = new ExGraph("123","sample-graph");
		YieldsterGraph graphInstance = graph.getGraphInstance();
		logger.info(graphInstance.toString());
		logger.info("Successfully generated graph");
	}

}
