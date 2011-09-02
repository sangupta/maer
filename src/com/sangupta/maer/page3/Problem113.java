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

/**
 * Problem 113 on Project Euler,
 * http://projecteuler.net/index.php?section=problems&id=113
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 02-Sep-2011
 */
public class Problem113 {

	private static final int MAX_DIGITS = 100;

	private static long[][] increasingCount = new long[10][MAX_DIGITS + 1];

	private static long[][] decreasingCount = new long[10][MAX_DIGITS + 1];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;

		for (int i = 1; i <= MAX_DIGITS; i++) {
			sum += incrementedNumbers(1, i) + decrementedNumbers(9, i) - 10; // -10 to remove duplicates of number containing same digits
		}

		System.out.println("Total bouncy numbers: " + sum);
	}

	private static long incrementedNumbers(int leftDigit, int numOfDigits) {
		if (increasingCount[leftDigit][numOfDigits] == 0) {
			if (numOfDigits == 1) {
				increasingCount[leftDigit][numOfDigits] = 10 - leftDigit;
			} else {
				for (int i = leftDigit; i < 10; i++) {
					increasingCount[leftDigit][numOfDigits] += incrementedNumbers(i, numOfDigits - 1);
				}
			}
		}
		
		return increasingCount[leftDigit][numOfDigits];
	}

	private static long decrementedNumbers(int leftDigit, int numOfDigits) {
		if (decreasingCount[leftDigit][numOfDigits] == 0) {
			if (numOfDigits == 1) {
				decreasingCount[leftDigit][numOfDigits] = leftDigit + 1;
			} else {
				for (int i = leftDigit; i >= 0; i--) {
					decreasingCount[leftDigit][numOfDigits] += decrementedNumbers(i, numOfDigits - 1);
				}
			}
		}
		
		return decreasingCount[leftDigit][numOfDigits];
	}
	
}
