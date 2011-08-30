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
import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 46 on Project Euler, http://projecteuler.net/index.php?section=problems&id=46
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 30-Aug-2011
 */
public class Problem46 {
	
	public static void main(String[] args) {
		int max = 1000000;
		PrimeSeive ps = new PrimeSeive(max);
		
		// build up a list of squares
		List<Integer> squares = new ArrayList<Integer>();
		for(int i = 1; i < 1001; i++) {
			squares.add(i * i);
		}
		
		// the first non-tested odd composite value;
		int candidate = 35;
		
		boolean found = false;
		do {
			if(ps.isPrime(candidate)) {
				candidate += 2;
				continue;
			}
			
			int prime = candidate;
			do {
				prime = ps.previousPrime(prime);
				if(prime > 0) {
					int diff = candidate - prime;

					// check the diff to be even
					if(MathUtil.isEven(diff) && squares.contains(diff / 2)) {
						break;
					}
				} else {
					found = true;
					System.out.println("Number: " + candidate);
					break;
				}
			} while(true);
			
			candidate += 2;
		} while(!found);
	}

}
