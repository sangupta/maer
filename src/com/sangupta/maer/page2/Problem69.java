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
package com.sangupta.maer.page2;

import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 69 on Project Euler, http://projecteuler.net/index.php?section=problems&id=69
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem69 {
	
	private static final int MAX = 1000000;

	/**
	 * Multiply all the smallest primes to get a product that is less than
	 * the given max limit.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeSeive ps = new PrimeSeive(MAX);
		int prime = 1;
		int product = 1;
		
		do {
			prime = ps.nextPrime(prime);
			int temp = product * prime;
			if(temp > MAX) {
				break;
			}
			
			product = temp;
		} while(true);

		System.out.println("Value of n = " + product);
	}

}
