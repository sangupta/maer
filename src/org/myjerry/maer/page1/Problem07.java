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

import java.util.Arrays;

/**
 * Problem 7 on Project Euler, http://projecteuler.net/index.php?section=problems&id=7
 *
 * @author Sandeep Gupta
 * @since Jan 9, 2011
 */
public class Problem07 {
	
	private static boolean[] numbers;
	
	private static final int eulerIndex = 10001;

	/**
	 * Solving using Sieve of Eratosthenes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int limit = 200000;
		
		numbers = new boolean[limit + 1];
		Arrays.fill(numbers, true);
		
		for(int i = 2; i != -1; i = getNextFreeIndex(i)) {
			for(int j = i * 2; j < numbers.length; j += i) {
				numbers[j] = false;
			}
		}
		
		int count = 0;
		for(int index = 2; index < numbers.length; index++) {
			if(numbers[index] == true) {
				count++;
				if(eulerIndex == count) {
					System.out.println("Prime " + eulerIndex + ": " + index);
					return;
				}
			}
		}
		
		System.out.println("Prime not found. Max primes detected=" + count);

	}
	
	private static int getNextFreeIndex(int i) {
		for(int index = i + 1; index < numbers.length; index++) {
			if(numbers[index] == true) {
				return index;
			}
		}
		return -1;
	}

}
