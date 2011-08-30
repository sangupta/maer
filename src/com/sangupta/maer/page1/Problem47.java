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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 47 on Project Euler, http://projecteuler.net/index.php?section=problems&id=47
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 30-Aug-2011
 */
public class Problem47 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// first number with 4 distinct prime factors = 2 * 3 * 5 * 7 = 210
		int candidate = 210;
		int mfr = 4;
		
		boolean[] factors = new boolean[mfr];
		
		for(int i = 0; i < mfr; i++) {
			factors[i] = moreFactors(candidate++, mfr);
		}

		boolean allTrue = false;
		do {
			allTrue = allTrue(factors);
			if(!allTrue) {
				// shift the array backwards
				for(int j = 1; j < mfr; j++) {
					factors[j - 1] = factors[j];
				}
				
				factors[mfr - 1] = moreFactors(candidate++, mfr);
			}
		} while(!allTrue);

//		System.out.println(MathUtil.primeFactors(candidate - mfr));
		System.out.println("Starting number: " + (candidate - mfr));
	}
	
	private static boolean allTrue(boolean[] array) {
		for(int i = 0; i < array.length; i++) {
			if(!array[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean moreFactors(int candidate, int mfr) {
		List<Long> factors = MathUtil.primeFactors(candidate);
		Set<Long> uniqueFactors = new HashSet<Long>(factors);
		
//		System.out.println("Unique factors for " + candidate + ": " + uniqueFactors);
		if(uniqueFactors.size() >= mfr) {
			return true;
		}
		
		return false;
	}

}
