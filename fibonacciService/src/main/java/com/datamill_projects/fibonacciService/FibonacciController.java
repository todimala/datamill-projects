package com.datamill_projects.fibonacciService;

import foundation.stack.datamill.http.Response;
import foundation.stack.datamill.http.ServerRequest;
import foundation.stack.datamill.http.annotations.GET;
import foundation.stack.datamill.http.annotations.Path;
import foundation.stack.datamill.http.impl.ResponseBuilderImpl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import foundation.stack.datamill.http.Client;
import rx.Observable;

@Path("/fibonacci")
public class FibonacciController {

	private FibonacciService fibonacciService;
	
	//@Inject
	public FibonacciController(FibonacciService service) {
		fibonacciService = service;
	}
	
	// Test hook
	private FibonacciController() {
		fibonacciService = new FibonacciService();
	}
	
    @GET
    @Path("/{count}")
    public Observable<Response> getSeries(ServerRequest request) throws Exception {
    	int count = Integer.valueOf(request.uriParameter("count").asString());
    	ExecutorService service = Executors.newSingleThreadExecutor();
    	return fibonacciService.getFibonacciSeries(count);
    }
}
