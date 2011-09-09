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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sangupta.maer.util.PrimeSeive;

/**
 * Problem 87 on Project Euler, http://projecteuler.net/index.php?section=problems&id=87
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 09-Sep-2011
 */
public class Problem87 {
	
	private static final long MAX = 50 * 1000 * 1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeSeive psSquare = new PrimeSeive((int) Math.sqrt(MAX));
		PrimeSeive psCube = new PrimeSeive((int) Math.cbrt(MAX));
		PrimeSeive psFourth = new PrimeSeive((int) Math.pow(MAX, 0.25));
		
		List<Integer> ps = psSquare.primes();
		List<Integer> pc = psCube.primes();
		List<Integer> pf = psFourth.primes();
		
		Set<Long> numbers = new HashSet<Long>();
		
		for(int p4 : pf) {
			long fourth = (long) Math.pow(p4, 4);
			for(int p3 : pc) {
				long cube = (long) Math.pow(p3, 3);
				long add = fourth + cube;
				if(add > MAX) {
					break;
				}
				
				for(int p2 : ps) {
					double number = Math.pow(p2, 2) + add;
					long num = (long) number;
					if(num > MAX) {
						break;
					}

					numbers.add(num);
				}
			}
		}
		
		System.out.println("Total numbers: " + numbers.size());
	}

}
