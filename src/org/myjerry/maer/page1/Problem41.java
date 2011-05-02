/**
 *
 * maer - Solutions to problems of Project Euler
 * Copyright (C) 2011, myJerry Developers
 * http://www.myjerry.org/maer
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
package org.myjerry.maer.page1;

import org.myjerry.maer.util.MathUtil;

/**
 * Problem 41 on Project Euler, http://projecteuler.net/index.php?section=problems&id=41
 *
 * @author Sandeep Gupta
 * @since May 2, 2011
 */
public class Problem41 {
	
	public static void main(String[] args) {
		// the largest n-digit pandigital prime can be a max of 9 digits
		// it cannot contain a ZERO for sure
		// if it is a 9-digit pandigital - the sum of digits is 45
		// hence, it cannot be a prime as is divisible by 3
		// similarly 8-digit pandigital numbers cannot be prime
		// similarly 5-digit cannot be pandigital prime's
		// atleast 4-digit primes
		int prime = 0;
		for(int n = 7654321; n > 1234567; n -= 2) {
			String number = String.valueOf(n);
			if(number.indexOf('0') == -1) {
				if(MathUtil.isPandigital(number)) {
					if(MathUtil.isPrime(n)) {
						prime = n;
						break;
					}
				}
			}
		}
		
		System.out.println("Max pandigital prime: " + prime);
	}

}
