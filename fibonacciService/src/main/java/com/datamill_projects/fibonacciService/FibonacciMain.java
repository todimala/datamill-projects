package com.datamill_projects.fibonacciService;

import foundation.stack.datamill.http.Method;
import foundation.stack.datamill.reflection.OutlineBuilder;
import foundation.stack.datamill.http.Server;
/**
 * Hello world!
 *
 */
public class FibonacciMain 
{
	public static void main(String[] args) {
		
		OutlineBuilder outlineBuilder = new OutlineBuilder();
		
		FibonacciService service = new FibonacciService();
		FibonacciController controller = new FibonacciController(service);

	    // Note the Server class here is foundation.stack.datamill.http.Server
	    Server server = new Server(
	        rb -> rb.ifMethodAndUriMatch(Method.GET, "/status", r -> r.respond(b -> b.ok()))
	            .elseIfMethodAndUriMatch(Method.GET, "/hello", r -> r.respond(b -> b.ok("Hello world!")))
	            .elseIfMatchesBeanMethod(outlineBuilder.wrap(controller))
	            .orElse(r -> r.respond(b -> b.notFound())));

	    server.listen(8081);
	}
}
