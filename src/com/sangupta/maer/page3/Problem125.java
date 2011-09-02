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

import java.util.HashSet;
import java.util.Set;

import com.sangupta.maer.util.PalindromeUtil;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 02-Sep-2011
 */
public class Problem125 {
	
	private static final int LIMIT = 100000000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Long> palindromes = new HashSet<Long>();
		
		final int midWay = (int) Math.sqrt(LIMIT); 
		for(int start = 1; start < midWay; start++) {
			long sumOfSquares = start * start;
			for(int end = start + 1; end <= midWay; end++) {
				sumOfSquares += (end * end);
				if(sumOfSquares > LIMIT) {
					break;
				}
				
				if(PalindromeUtil.checkPalindrome(sumOfSquares)) {
					palindromes.add(sumOfSquares);
				}
			}
		}
		
		long sum = 0;
		for(Long num : palindromes) {
			sum += num;
		}
		System.out.println("Total numbers: " + palindromes.size() + " with sum: " + sum);
	}

}
