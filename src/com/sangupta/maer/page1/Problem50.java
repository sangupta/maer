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

import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 50 on Project Euler, http://projecteuler.net/index.php?section=problems&id=50
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 29-Aug-2011
 */
public class Problem50 {
	
	public static void main(String[] args) {
		int max = 1000000;
		PrimeSeive ps = new PrimeSeive(max);
		final int totalPrimes = ps.count();
		
		// build a list of all sums
		long[] sumArray = new long[totalPrimes + 2];
		
		int prime = 0;
		int maxTermsInArray = 1;
		sumArray[0] = 0;
		do {
			prime = ps.nextPrime(prime);
			if(prime != -1) {
				long previous = sumArray[maxTermsInArray -1];
				long sum = previous + prime;
				if(sum < max) {
					sumArray[maxTermsInArray] = sum;
					maxTermsInArray++;
				}
			}
		} while(prime != -1);
		
		int candidate = max;
		int maxPrime = -1;
		int maxTerms = 1;
		do {
			candidate = ps.previousPrime(candidate);
			if(candidate != -1) {
				int terms = findTerms(candidate, maxTerms, sumArray, maxTermsInArray);
				if(terms != -1 && terms > maxTerms) {
					maxTerms = terms;
					maxPrime = candidate;
				}
			}
		} while(candidate > -1);
		
		System.out.println("Max prime: " + maxPrime + " with terms " + maxTerms);
	}

	/**
	 * @param candidate
	 * @param sumArray
	 * @return
	 */
	private static int findTerms(int candidate, int maxTerms, long[] sumArray, int maxTermsInArray) {
		// check if the value is present directly in the array
		for(int i = 1; i <= maxTermsInArray; i++) {
			if(sumArray[i] == candidate) {
				return i;
			}
		}
		
		// if not, let's see if this can be a combination of anything
		for(int subtractive = 0; subtractive < maxTermsInArray; subtractive++) {
			for(int iterative = subtractive + maxTerms; iterative <= maxTermsInArray; iterative++) {
				long number = sumArray[iterative] - sumArray[subtractive];
				if(number == candidate) {
					return iterative - subtractive;
				}
				
				if(number > candidate) {
					break;
				}
			}
		}
		
		return -1;
	}

}
