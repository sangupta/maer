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
 * Problem 24 on Project Euler, http://projecteuler.net/index.php?section=problems&id=24
 *
 * @author Sandeep Gupta
 * @since Jan 18, 2011
 */
public class Problem24 {
	
	private static final int eulerLimit = 10;
	
	private static double eulerDestination = 1000000;
	
	public static void main(String[] args) {
		int len = 1;
		String digits = "0123456789";
		String number = "";
		do {
			int diff = eulerLimit - len;
			double permutations = MathUtil.factorial(diff).doubleValue();
			double div = eulerDestination / permutations;
			int digitPosition = (int) Math.ceil(div);
			
			long multiplied = (long) ((digitPosition - 1) * permutations);
			int index = Math.min(digits.length(), digitPosition - 1);
			String digit = digits.substring(index, index + 1);
			number += digit;
			
			digits = digits.replaceAll(digit, "");
			if(eulerDestination != multiplied) {
				eulerDestination -= multiplied;
			}
			len++;
			
		} while(digits.length() > 0);
		
		System.out.println("Lexicographic permutation: " + number);
	}

}
