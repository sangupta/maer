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
 * Problem 6 on Project Euler, http://projecteuler.net/index.php?section=problems&id=6
 * 
 * @author Sandeep Gupta
 * @since Jan 6, 2011
 */
public class Problem06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long n = 100;
		long squareOfSum = MathUtil.squareOfSumFirstN(n);
		long sumOfSquare = MathUtil.sumOfSquaresFirstN(n);
		
		
		long result = squareOfSum - sumOfSquare;
		System.out.println("Result=" + result);
	}

}
