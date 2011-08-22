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

import java.util.ArrayList;
import java.util.List;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 37 on Project Euler, http://projecteuler.net/index.php?section=problems&id=37
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since May 2, 2011
 */
public class Problem37 {
	
	private static final List<Integer> primes = new ArrayList<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// set up base
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		
		int number = 11;
		long sum = 0;
		int count = 0;
		while(true) {
			if(MathUtil.isPrime(number)) {
				primes.add(number);
				if(isTruncatable(number)) {
					System.out.println("Truncatable prime: " + number);
					sum += number;
					count++;
					if(count == 11) {
						break;
					}
				}
			}
			
			number += 2;
		}
		
		System.out.println("Sum of truncatable primes: " + sum);
	}

	/**
	 * @param number
	 * @return
	 */
	private static boolean isTruncatable(int number) {
		String num = String.valueOf(number);
		for(int i = 1; i <= num.length() - 1; i++) {
			String subNum = num.substring(i);
			int n = Integer.parseInt(subNum);
			if(!primes.contains(n)) {
				return false;
			}
		}
		
		for(int i = 1; i <= num.length() - 1; i++) {
			String subNum = num.substring(0, i);
			int n = Integer.parseInt(subNum);
			if(!primes.contains(n)) {
				return false;
			}
		}
		
		return true;
	}

}
