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
 * Problem 35 on Project Euler, http://projecteuler.net/index.php?section=problems&id=35
 *
 * @author Sandeep Gupta
 * @since Jan 18, 2011
 */
public class Problem35 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		for(int i = 3; i < 1000000; i+=2) {
			if(MathUtil.isPrime(i)) {
				// try and rotate
				String prime = String.valueOf(i);
				if(prime.length() > 1) {
					boolean test = true;
					for(int n=1; n < prime.length(); n++) {
						String first = prime.substring(0, n);
						String second = prime.substring(n);
						String newNum = second + first;
						// System.out.println("Testing " + newNum + " for " + prime);
						if(!MathUtil.isPrime(Integer.parseInt(newNum))) {
							test = false;
							break;
						}
					}
					
					if(test) {
						count++;
					}
				} else {
					count++;
				}
			}
		}
		
		// adding 1 for 2 that we didn't count
		count += 1;
		
		System.out.println("Total primes: " + count);
	}

}
