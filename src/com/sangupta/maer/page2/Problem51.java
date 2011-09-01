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
package com.sangupta.maer.page2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sangupta.maer.util.PrimeSeive;


/**
 * Problem 51 on Project Euler, http://projecteuler.net/index.php?section=problems&id=51
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 30-Aug-2011
 */
public class Problem51 {
	
	public static Map<String, List<Integer>> primed = new HashMap<String, List<Integer>>(); 

	private static final int max = 1000000;
	
	private static final PrimeSeive ps = new PrimeSeive(max);
	
	public static void main(String[] args) {
		int prime = 99999;
		do {
			prime = ps.nextPrime(prime);
			if(prime == -1) {
				break;
			}
			
			String number = String.valueOf(prime);
			char digit = getRepeatingDigit(number);
			if(isDesiredResult(number, digit)) {
				System.out.println("Smallest prime: " + prime);
				break;
			}
		} while(true);
		
	}
	
	/**
	 * @param prime
	 * @param digit
	 * @return
	 */
	private static boolean isDesiredResult(String prime, char digit) {
		int count = 0;
		for(int i = 0; i < 10; i++) {
			char c = (char) ('0' + i);
			String builtPrime = prime.replace(digit, c);
			int p = Integer.parseInt(builtPrime);
			if(p > 99999 && ps.isPrime(p) ) {
				count++;
			}
		}
		
		if(count == 8) {
			return true;
		}
		
		return false;
	}

	private static char getRepeatingDigit(final String prime) {
		String num = String.valueOf(prime);
		for(int i = 0; i < num.length(); i++) {
			char repeatingDigit = num.charAt(i);
			String digit = String.valueOf(repeatingDigit);
			String reduced = num.replace(digit, "");
			
			if(reduced.length() == 3 && !prime.endsWith(digit)) {
				return repeatingDigit;
			}
		}
		
		return '?';
	}

}
