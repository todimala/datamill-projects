package com.datamill_projects.fibonacciService;

import foundation.stack.datamill.http.Response;
import foundation.stack.datamill.http.ServerRequest;
import foundation.stack.datamill.http.annotations.GET;
import foundation.stack.datamill.http.annotations.Path;
import rx.Observable;

@Path("/fibonacci")
public class FibonacciController {

	private FibonacciService fibonacciService;
	
	//@Inject
	public FibonacciController(FibonacciService service) {
		fibonacciService = service;
	}
	
	@GET
    @Path("/{count}")
    public Observable<Response> getSeries(ServerRequest request) throws Exception {
    	int count = Integer.valueOf(request.uriParameter("count").asString());
    	return fibonacciService.getFibonacciSeries(count);
    }
}
