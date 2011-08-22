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

import com.sangupta.maer.util.PalindromeUtil;

/**
 * Problem 36 on Project Euler, http://projecteuler.net/index.php?section=problems&id=36
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 18, 2011
 */
public class Problem36 {
	
	public static void main(String[] args) {
		long sum = 0;
		for(int number = 1; number < 1000000; number++) {
			if(PalindromeUtil.checkPalindrome(number)) {
				// check its binary equivalent
				String binary = Integer.toString(number, 2);
				if(PalindromeUtil.checkPalindrome(binary)) {
					System.out.println(number + "\t" + binary);
					sum += number;
				}
			}
		}
		
		System.out.println("Sum of all numbers: " + sum);
	}

}
