/**
 *
 * maer - Solutions to problems of Project Euler
 * Copyright (C) 2011, myJerry Developers
 * http://www.myjerry.org/maer
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
package org.myjerry.maer.page1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myjerry.maer.util.MathUtil;

/**
 * Problem 12 on Project Euler, http://projecteuler.net/index.php?section=problems&id=12
 *
 * @author Sandeep Gupta
 * @since Jan 9, 2011
 */
public class Problem12 {
	
	private static final int eulerLimit = 500;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 2;
		do {
			long number = MathUtil.sumFirstN(n);

			List<Long> divisors = MathUtil.primeFactors(number);
			Map<Long, Integer> powers = new HashMap<Long, Integer>();
			for(long num : divisors) {
				if(powers.containsKey(num)) {
					powers.put(num, powers.get(num) + 1);
				} else {
					powers.put(num, 1);
				}
			}
			
			int factors = 1;
			for(Integer power : powers.values()) {
				factors *= (power + 1);
			}
			
			if(factors > eulerLimit) {
				System.out.println("For term " + n + " with value " + number + " has total number of divisors: " + factors);
				break;
			}
			
			n++;
		} while(true);
	}

}
