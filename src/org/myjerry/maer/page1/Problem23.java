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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.myjerry.maer.util.MathUtil;

/**
 * Problem 23 on Project Euler,
 * http://projecteuler.net/index.php?section=problems&id=23
 * 
 * @author Sandeep Gupta
 * @since Jan 18, 2011
 */
public class Problem23 {
	
	private static final int eulerLimit = 20162;

	public static void main(String[] args) {
		// make a list of all abundants
		List<Integer> abundants = new ArrayList<Integer>();
		
		for(int number = 1; number < eulerLimit; number++) {
			long sumOfDivisors = MathUtil.sumOfDivisors(number); 
			if(sumOfDivisors > number) {
				abundants.add(number);
			}
		}
		
		// find all those which are a sum of two abundants
		int[] array = new int[eulerLimit];
		int len = array.length;
		for (int i = 0; i < len; i++) {
			array[i] = i + 1;
		}
		
		Iterator<Integer> it = abundants.iterator();
		while (it.hasNext()) {
			int one = it.next();
			for (int j = 0; j < abundants.size(); j++) {
				int sum = one + abundants.get(j);
				if (sum <= len) {
					array[sum - 1] = 0;
				}
			}
			it.remove(); // remove it as checked against ALL numbers
		}
		int sum = 0;
		len = array.length;
		for (int i = 0; i < len; i++) {
			sum += array[i];
		}		     
		     
		System.out.println("Sum: " + sum);
	}
	
}
