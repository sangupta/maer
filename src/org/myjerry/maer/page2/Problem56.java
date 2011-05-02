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

import org.myjerry.maer.util.MathUtil;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author Sandeep Gupta
 * @since May 2, 2011
 */
public class Problem56 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long max = 0;
		for(int a = 99; a > 0; a--) {
			for(int b = 99; b > 0; b--) {
				BigInteger ab = MathUtil.raiseToPower(a, b);
				long sum = MathUtil.sumOfDigits(ab);
				if(sum > max) {
					max = sum;
				}
			}
		}
		
		System.out.println("Max sum: " + max);
	}

}
