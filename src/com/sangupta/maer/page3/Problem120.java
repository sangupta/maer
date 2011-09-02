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
 * Problem 120 on Project Euler, http://projecteuler.net/index.php?section=problems&id=120
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 02-Sep-2011
 */
public class Problem120 {

	/**
	 * (a+1)^2 + (a-1)^2 = 2a^2 + 2
	 * in general, (a+1)^n + (a-1)^n = 2a^n + 2 for n=even
	 * 
	 * (a+1)^3 + (a-1)^3 = 2a^3 + 2a*3
	 * in general, (a+1)^n + (a-1)^n = 2a^n + 2a*n for n=odd
	 * 
	 * Dividing by a^2 will give remainder as,
	 * for n=even: 2
	 * for n=odd: 2a*n
	 * 
	 * Thus max remainder will be 2a*n amongst all n. If 2*n == a, then
	 * 2*a*n => 2*a*a => 2a^2 which will again be divided.
	 * 
	 * So, remainder is max when 2*n < a (with n being max).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		for(int a = 3; a <= 1000; a++) {
			int n = (int) ((a - 1) / 2);
			sum += (2 * n * a);
		}
		
		System.out.println("Sum: " + sum);

	}

}
