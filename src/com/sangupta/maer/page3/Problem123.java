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
package com.sangupta.maer.page3;

import com.sangupta.maer.util.MathUtil;
import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 123 on Project Euler, http://projecteuler.net/index.php?section=problems&id=123
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 02-Sep-2011
 */
public class Problem123 {

	/**
	 * Refer problem 120 for description of approach.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeSeive ps = new PrimeSeive(1000000);
		long maxRemainder = (long) Math.pow(10, 10);
		
		// we start with 3
		int prime = 2;
		int n = 1;
		do {
			// get the prime and the prime count
			prime = ps.nextPrime(prime);
			++n;
			
			// max remainder now is
			if(MathUtil.isOdd(n)) {
				long remainder = 2l * prime * n;
				if(remainder > maxRemainder) {
					break;
				}
			}
		} while(prime != -1);
		
		System.out.println("Minimum value of n=" + n);
	}

}
