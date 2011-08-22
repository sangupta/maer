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

/**
 * Problem 20 on Project Euler, http://projecteuler.net/index.php?section=problems&id=20
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem20 {
	
	private static final int base = 100000;
	
	private static final int num = 100;
	
	/**
	 * Using technique outlined at http://stackoverflow.com/questions/1469529/sum-of-digits-of-a-factorial
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long dig[] = new long[10000], carry, sum = 0;
		int n, x, first = 0, last = 0;
		dig[0] = 1;
		
		for (n = 2; n <= num; n++) {
			carry = 0;
			for (x = first; x <= last; x++) {
				carry = dig[x] * n + carry;
				long carryPercented = carry % base; 
				dig[x] = carryPercented;
				if (x == first && !(carryPercented > 0)) {
					first++;
				}
				carry /= base;
			}
			if (carry > 0) {
				dig[++last] = carry;
			}
		}
		
		for(x = first; x <= last; x++) {
			sum += dig[x]%10 + (dig[x]/10)%10 + (dig[x]/100)%10 + (dig[x]/1000)%10 + (dig[x]/10000)%10;
		}
		
		System.out.println("Sum=" + sum);
	}

}
