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
package org.myjerry.maer.page2;

import java.math.BigInteger;

import org.myjerry.maer.util.PalindromeUtil;

/**
 * Problem 55 on Project Euler, http://projecteuler.net/index.php?section=problems&id=55
 * 
 * @author Sandeep Gupta
 * @since Jan 6, 2011
 */
public class Problem55 {
	
	private static final int eulerLimit = 10000;
	
	private static final int iterationLimit = 60;
	
	private static final Integer[] attempts = new Integer[eulerLimit + 1];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 1; i <= eulerLimit; i++) {
			if(attempts[i] == null) {
				// System.out.println("Checking number: " + i);
				int iterations = tryIterations(i, BigInteger.valueOf(i), 1);
				if(iterations != -1) {
					attempts[i] = iterations;
				}
				// System.out.println("\n\n\n");
			}
		}
		
		int count = 0;
		for(int i = 1; i <= eulerLimit; i++) {
			if(attempts[i] == null || attempts[i] == -1) {
				System.out.print(i + ", ");
				++count;
			}
		}
		
		System.out.println("\n\nTotal numbers: " + count);
	}

	/**
	 * @param i
	 */
	private static int tryIterations(int number, BigInteger currentSum, int iterationNumber) {
		if(iterationNumber > iterationLimit) {
			return -1;
		}
		
		if(PalindromeUtil.checkPalindrome(currentSum) && currentSum.compareTo(BigInteger.valueOf(9)) > 0 && iterationNumber != 1) {
			// the number must not be a single digit
			return iterationNumber;
		}
		
		BigInteger reverse = PalindromeUtil.reverse(currentSum);
		BigInteger reverseSum = currentSum.add(reverse);
		// System.out.println("Iteration " + iterationNumber + ": " + currentSum.toString() + " + " + reverse.toString() + " = " + reverseSum.toString());
		if(PalindromeUtil.checkPalindrome(reverseSum) && currentSum.compareTo(BigInteger.valueOf(9)) > 0) {
			return iterationNumber;
		}
		
		int attempt = tryIterations(number, reverseSum, iterationNumber + 1);
		if(attempt != -1) {
			if(reverseSum.compareTo(BigInteger.valueOf(10001l)) < 0) {
				int ival = reverseSum.intValue();
				attempts[ival] = (attempt - iterationNumber);
			}
		}
		
		return attempt;
	}

}
