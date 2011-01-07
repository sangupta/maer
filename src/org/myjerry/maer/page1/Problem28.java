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

/**
 * Problem 28 on Project Euler, http://projecteuler.net/index.php?section=problems&id=28
 * 
 * @author Sandeep Gupta
 * @since Jan 6, 2011
 */
public class Problem28 {
	
	private static final int eulerLimit = 1001;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Ignoring the middle column where 1 is the number that needs to be added
		// as we move to next column (outwards from the middle column)
		// we need to add four number which have a difference of 2, 4, 6, 8...

		long sum = 1;
		long diff = 2;
		long currentNumber = 1;
		for(int i = 1; (i <= (eulerLimit - 1) / 2); i++) {
			sum += (currentNumber + diff);
			sum += (currentNumber + 2 * diff);
			sum += (currentNumber + 3 * diff);
			sum += (currentNumber + 4 * diff);
			
			currentNumber += 4 * diff;
			
			diff += 2;
		}
		
		System.out.println("Sum: " + sum);
	}

}
