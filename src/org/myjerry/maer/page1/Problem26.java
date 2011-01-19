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

import java.math.BigInteger;

import org.myjerry.maer.util.MathUtil;

/**
 * Problem 26 on Project Euler,
 * http://projecteuler.net/index.php?section=problems&id=26
 * 
 * @author Sandeep Gupta
 * @since Jan 18, 2011
 */
public class Problem26 {
	
	private static final BigInteger one = BigInteger.valueOf(1);

	/**
	 * 1/d has a cycle of n digits if 10n-1 mod d = 0 for prime d. 
	 * It also follows that a prime number in the denominator, d, can yield up to d-1 repeating decimal digits.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 0;
		for (n = 997; n > 1; n -= 2) {
			if (MathUtil.isPrime(n)) {
				int c = 1;
				BigInteger num = BigInteger.valueOf(n);
				while (MathUtil.raiseToPower(10, c).subtract(one).mod(num).longValue() != 0) {
					c += 1;
					if(c > n) {
						break;
					}
				}
				if (n - c == 1) {
					System.out.println("Number: " + n);
					break;
				}
			}
		}

	}

}
