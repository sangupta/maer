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

import com.sangupta.maer.util.MathUtil;
import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem58 {
	
	private static final int MAX = 10000000;

	private static final PrimeSeive ps = new PrimeSeive(MAX);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// the corner's of the triangle are always a series like (3, 5, 7, 9), (13, 17, 21, 25), (31, 37, 43, 49), ...
		// thus we need to make sure what the average is at any given time
		
		int n = 1;
		int primes = 0;
		int count = 1;
		do {
			n += 2;
			count += 4;
			
			int v1 = n * (n - 3) + 3;
			int v2 = n * (n - 2) + 2;
			int v3 = n * (n - 1) + 1;
			
			if(isPrime(v1)) {
				primes++;
			}
			
			if(isPrime(v2)) {
				primes++;
			}
			
			if(isPrime(v3)) {
				primes++;
			}
			
			double avg = ((double) primes) / ((double) count);
			if(avg < 0.1) {
				System.out.println("Side length: " + n);
				break;
			}
		} while(true);
	}

	/**
	 * @param v3
	 * @return
	 */
	private static boolean isPrime(int value) {
		if(value > MAX) {
			return MathUtil.isPrime(value);
		}
		
		return ps.isPrime(value);
	}

}
