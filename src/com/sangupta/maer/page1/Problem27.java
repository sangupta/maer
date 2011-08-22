/**
 *
 * maer - Solutions to problems of Project Euler
 * Copyright (C) 2011, Sandeep Gupta
 * http://www.sangupta.com/projects/maer
 *
 * The file is licensed under the the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.sangupta.maer.page1;

import java.util.ArrayList;
import java.util.List;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 27 on Project Euler, http://projecteuler.net/index.php?section=problems&id=27
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 19, 2011
 */
public class Problem27 {

	/**
	 * Equation of the for prime = n^2 + an  + b
	 * For n=0, prime = b ==> b is a prime
	 * For n=1, prime = a + b ==> as b is a prime, a must be odd for (a+b) to be a prime.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int maxPrime = 0;
		long maxProduct = 0;
		
		// get all primes under 1000
		List<Integer> primes = getPrimes(999);
		
		// now find the coefficient a
		for(int a = -999; a <= 999; a+=2) {
			for(Integer b : primes) {
				int n = 1;
				do {
					long equation = (long) (Math.pow(n, 2) + (a * n) + b);
					if(MathUtil.isPrime(equation)) {
						n++;
					} else {
						break;
					}
				} while(true);
				
				if(n > maxPrime) {
					maxPrime = n;
					maxProduct = a * b;
				}
			}
		}
		
		System.out.println("Product of coefficients: " + maxProduct);
	}

	/**
	 * @param i
	 * @return
	 */
	private static List<Integer> getPrimes(int i) {
		List<Integer> primes = new ArrayList<Integer>();
		if(i >= 2) {
			primes.add(2);
		}
		
		for(int n = 3; n <= i; n+=2) {
			if(MathUtil.isPrime(n)) {
				primes.add(n);
			}
		}
		
		return primes;
	}

}
