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

import java.util.Arrays;
import java.util.List;

import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 77 on Project Euler, http://projecteuler.net/index.php?section=problems&id=77
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 09-Sep-2011
 */
public class Problem77 {
	
	private static final int LIMIT = 5000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeSeive ps = new PrimeSeive(80);
		List<Integer> primes = ps.primes();
		
		int target = 11;
		
		do {
			int[] ways = new int[LIMIT];
			ways[0] = 1;

			for(int i : primes) {
				for(int j = i; j < target + 1; j++) {
					ways[j] += ways[j - i];
				}
			}
			
			if(ways[target] > LIMIT) {
				break;
			}
			
			target++;
		} while(true);
		
		System.out.println("Minimum number: " + target);
	}

}
