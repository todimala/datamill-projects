package com.datamill_projects.fibonacciService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import foundation.stack.datamill.http.Response;
import foundation.stack.datamill.http.impl.ResponseBuilderImpl;
import rx.Observable;

public class FibonacciService {

	ExecutorService service = Executors.newSingleThreadExecutor();
	
	public Observable<Response> getFibonacciSeries(Integer count) throws Exception {
		
		if (count <= 0) {
			throw new InvalidInputException(count);
		}
		
		List<Integer> series = new ArrayList<Integer>(count);
		
		int i = 0, j = 1, k;
		if (count >= 1) {
			series.add(0);
		}
		if (count >= 2) {
			series.add(1);
		}
		count=count-2;
		while (count>0) {
			count--;
			k = i + j;
			i = j;
			j = k;
			series.add(k);
		}
		
		//return series;		
		return Observable.just(new ResponseBuilderImpl(service).ok(series.toString()));
	}
}

class InvalidInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(int n) {
		super("The user input is '" + n + "'. Give a positive number.");
	}
}