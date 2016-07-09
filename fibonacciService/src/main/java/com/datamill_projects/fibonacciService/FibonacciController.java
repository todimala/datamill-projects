package com.datamill_projects.fibonacciService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import foundation.stack.datamill.http.Response;
import foundation.stack.datamill.http.ServerRequest;
import foundation.stack.datamill.http.annotations.GET;
import foundation.stack.datamill.http.annotations.Path;
import rx.Observable;

@Path("/fibonacci")
public class FibonacciController {

	private FibonacciService fibonacciService;
	static String response = "";
	
	//@Inject
	public FibonacciController(FibonacciService service) {
		fibonacciService = service;
	}
	
	@GET
    @Path("/{count}")
    public Observable<Response> getSeries(ServerRequest request) throws Exception {
		int count = request.uriParameter("count").asInteger();
		try {
			response = fibonacciService.getFibonacciSeries(count).toString();
			System.out.println("response = " + response);
		} catch (Exception ex) {

		}
		return request.respond(b -> b.ok(response));
    }
}
