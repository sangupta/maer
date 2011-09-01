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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sangupta.maer.util.MathUtil;
import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 60 on Project Euler, http://projecteuler.net/index.php?section=problems&id=60
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem60 {
	
	private static final int MAX = 10000;
	
	private static final PrimeSeive primeSeive = new PrimeSeive(MAX);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Set<Integer>> sets = new TreeMap<Integer, Set<Integer>>();
		
		int firstPrime = 1;
		do {
			firstPrime = primeSeive.nextPrime(firstPrime);
			
			if(firstPrime == -1) {
				break;
			}
			
			int nextPrime = firstPrime;
			do {
				nextPrime = primeSeive.nextPrime(nextPrime);
				
				if(nextPrime == -1) {
					break;
				}
				
				if(arePairPrimes(firstPrime, nextPrime)) {
					Set<Integer> primes;
					if(sets.containsKey(firstPrime)) {
						primes = sets.get(firstPrime);
					} else {
						primes = new TreeSet<Integer>();
						sets.put(firstPrime, primes);
					}
					
					primes.add(nextPrime);
				}
			} while(true);
		} while(true);
		
		List<Integer> keys = new ArrayList<Integer>(sets.keySet());
		final int size = keys.size();
		for(int n1 = 0; n1 < size - 1; n1++) {
			int prime1 = keys.get(n1);
			final Set<Integer> firstSet = sets.get(prime1);

			boolean found = false;
			for(int n2 = n1 + 1; n2 < size; n2++) {
				int prime2 = keys.get(n2);
				Set<Integer> secondSet = sets.get(prime2);
				
				// compute the intersection
				Set<Integer> retainable = new TreeSet<Integer>(firstSet);
				retainable.retainAll(secondSet);
				
				if(firstSet.size() > 2) {
					List<Integer> primes = new ArrayList<Integer>(retainable);
	
					// check if this set has 3 numbers that are concatenable primes
					int sum = checkSetForPrimes(primes); 
					if(sum != -1) {
						System.out.println("Primes are: " + prime1 + ", " + prime2);
						System.out.println("Sum: " + (sum + prime1 + prime2));
						found = true;
						break;
					}
				}
			}
			
			if(found) {
				break;
			}
		}
	}
	
	private static boolean arePairPrimes(int firstPrime, int secondPrime) {
		String prefixBuild = String.valueOf(firstPrime) + String.valueOf(secondPrime);
		long testPrime1 = Long.parseLong(prefixBuild);
		
		String suffixBuild = String.valueOf(secondPrime) + String.valueOf(firstPrime);
		long testPrime2 = Long.parseLong(suffixBuild);
		
		if(isPrime(testPrime1) && isPrime(testPrime2)) {
			return true;
		}
		
		return false;
	}

	/**
	 * @param testPrime1
	 * @return
	 */
	private static boolean isPrime(long testPrime) {
		if(testPrime > MAX) {
			return MathUtil.isPrime(testPrime);
		}
		
		return primeSeive.isPrime((int) testPrime);
	}

	/**
	 * @param primeSet
	 * @return
	 */
	private static int checkSetForPrimes(List<Integer> primes) {
		final int size = primes.size();

		int prime1, prime2;
		for(int n1 = 0; n1 < size - 1; n1++) {
			prime1 = primes.get(n1);
			for(int n2 = n1 + 1; n2 < size; n2++) {
				prime2 = primes.get(n2);
				if(arePairPrimes(prime1, prime2)) {
					int anotherPrime = hasAnotherPrime(prime1, prime2, primes);
					if(anotherPrime != -1) {
						System.out.println(prime1 + ", " + prime2 + ", " + anotherPrime);
						return prime1 + prime2 + anotherPrime;
					}
				}
			}
		}
		
		return -1;
	}

	/**
	 * @param prime1
	 * @param prime2
	 * @param primeSet
	 * @return
	 */
	private static int hasAnotherPrime(int prime1, int prime2, List<Integer> primes) {
		final int size = primes.size();
		
		for(int index = 0; index < size; index++) {
			int prime = primes.get(index);
			if(prime != prime1 && prime != prime2 && arePairPrimes(prime, prime1) && arePairPrimes(prime, prime2)) {
				return prime;
			}
		}
		
		return -1;
	}

}
