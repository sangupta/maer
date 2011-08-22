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
package com.sangupta.maer.page1;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 3 on Project Euler, http://projecteuler.net/index.php?section=problems&id=3
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem03 {
	
	private static long num = 600851475143l;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int divisor = 3;
		do {
			long mod = num % divisor;
			if(mod == 0) {
				// check if the number is prime
				long quotient = num / divisor;
				if(MathUtil.isPrime(quotient)) {
					System.out.println("Max prime: " + quotient);
					break;
				}
			}
			
			divisor++;
		} while(true);

	}

}
