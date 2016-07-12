package com.datamill_projects.fibonacciService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciService {

	ExecutorService service = Executors.newSingleThreadExecutor();
	
	public List<BigInteger> getFibonacciSeries(Integer count) throws IllegalArgumentException {
		
		if (count <= 0) {
			throw new IllegalArgumentException();
		}
		
		List<BigInteger> series = new ArrayList<BigInteger>(count);
		
		BigInteger i = BigInteger.ZERO, j = BigInteger.ONE, k;
		if (count >= 1) {
			series.add(BigInteger.ZERO);
		}
		if (count >= 2) {
			series.add(BigInteger.ONE);
		}
		count=count-2;
		while (count>0) {
			count--;
			k = i.add(j);
			i = j;
			j = k;
			series.add(k);
		}
		
		return series;
		//return Observable.just(new ResponseBuilderImpl(service).ok(series.toString()));
	}
}

class InvalidInputException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(int n) {
		super("The user input is '" + n + "'. Give a positive number.");
	}
}