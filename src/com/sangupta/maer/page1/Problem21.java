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

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 21 on Project Euler, http://projecteuler.net/index.php?section=problems&id=21
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem21 {
	
	private static final int eulerLimit = 10000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[] amicable = new boolean[eulerLimit];
		long next;
		long sum = 0;
		
		for(int i = 1; i < eulerLimit; i++) {
			if(!amicable[i]) {
				// test this number
				next = findNext(i);
				if(next > 0) {
					if(next < eulerLimit) {
						int nextIndex = (int) next;
						amicable[nextIndex] = true;
					}
					sum += i + next;
				}
			}
		}
		
		System.out.println("Sum = " + sum);
	}

	/**
	 * Find the next amicable number.
	 * 
	 * @param number
	 * @return
	 */
	private static long findNext(int number) {
		long divSum = MathUtil.sumOfDivisors(number);
		long otherSum = MathUtil.sumOfDivisors(divSum);
		
		if(otherSum == number && number != divSum) {
			return divSum;
		}
		
		return 0;
	}

}
