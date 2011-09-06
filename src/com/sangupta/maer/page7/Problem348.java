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
package com.sangupta.maer.page7;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 348 on Project Euler, http://projecteuler.net/index.php?section=problems&id=348
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 06-Sep-2011
 */
public class Problem348 {
	
	private static int found = 0;
	
	private static long sum = 0;

	/**
	 * Found 5229225
	 * Found 37088073
	 * Found 56200265
	 * Found 108909801
	 * @param args
	 */
	public static void main(String[] args) {
		iterateOnPalindromes(7, 12);
		System.out.println("Sum: " + sum);
	}
	
	private static void iterateOnPalindromes(final int startDigits, final int maxDigits) {
		for(int numDigits = startDigits; numDigits <= maxDigits; numDigits++) {
			if(MathUtil.isEven(numDigits)) {
				long end = (long) Math.pow(10, (numDigits / 2));
				long start = end / 10;
				
				// loop
				for(long i = start; i < end; i++) {
					String palindrome = String.valueOf(i);
					palindrome = palindrome + new StringBuilder(palindrome).reverse().toString();
					boolean stopLoop = checkPalindrome(palindrome);
					if(stopLoop) {
						return;
					}
				}
			} else {
				// this is odd digit based
				int digitGroupLength = numDigits - 1;
				long end = (long) Math.pow(10, (digitGroupLength / 2));
				long start = end / 10;
				
				// loop
				for(long i = start; i < end; i++) {
					// the middle digit comes from the second loop
					for(int middle = 0; middle < 10; middle++) {
						String palindrome = String.valueOf(i);
						palindrome = palindrome + String.valueOf(middle) + new StringBuilder(palindrome).reverse().toString();
						boolean stopLoop = checkPalindrome(palindrome);
						if(stopLoop) {
							return;
						}
					}
				}				
			}
		}
	}

	/**
	 * @param palindrome
	 * @return
	 */
	private static boolean checkPalindrome(String palindrome) {
		Long number = Long.parseLong(palindrome);
		if(isPalindromeRepresentable(number)) {
			System.out.println("Found " + number);
			found++;
			sum += number;
		}
		
		if(found == 5) {
			return true;
		}
		return false;
	}

	private static boolean isPalindromeRepresentable(final long number) {
		int cubeLimit = (int) Math.cbrt(number - 4);
		
		int countForms = 0;
		
		for(int testNumber = 2; testNumber <= cubeLimit; testNumber++) {
			int cube = testNumber * testNumber * testNumber;
			long diff = number - cube;
			double squareRoot = Math.sqrt(diff);
			int intSquareRoot = (int) squareRoot;
			if(squareRoot == intSquareRoot) {
				countForms++;
			}
		}
		
		if(countForms == 4) {
			return true;
		}
		
		return false;
	}
}
