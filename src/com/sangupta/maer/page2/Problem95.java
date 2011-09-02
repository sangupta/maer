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
import java.util.Set;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 95 on Project Euler, http://projecteuler.net/index.php?section=problems&id=95
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 02-Sep-2011
 */
public class Problem95 {
	
	private static final int MAX = 1000000;
	
	private static int[] sums = new int[MAX + 1];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int num = 1; num < MAX; num++) {
			long sum = MathUtil.sumOfProperDivisors(num);
			if(sum >= MAX) {
				sum = 0;
			}
			
			sums[num] = (int) sum;
		}
		
		// Starting chaining...
		int firstInChain = 0;
        int len = 1;
        
        final Set<Integer> chain = new HashSet<Integer>();
        
        int temp;
		for (int num = 1; (temp = num) <= MAX; ++num) {
			chain.clear();
			
			while (temp != 0 && chain.add(temp)) {
				temp = sums[temp];
			}
			
			if (temp == num) {
				if (chain.size() > len) {
					len = chain.size();
					firstInChain = num;
				}
				
				for (int i : chain) {
					sums[i] = 0;
				}
			} else if (temp == 0) {
				for (int i : chain) {
					sums[i] = 0;
				}
			}
        }
        
        System.out.println("Starting chain number: " + firstInChain);
	}

}

