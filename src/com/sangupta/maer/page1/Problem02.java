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

import com.sangupta.maer.util.FibonacciUtil;

/**
 * Problem 2 on Project Euler, http://projecteuler.net/index.php?section=problems&id=2
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem02 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long m4 = 4000000l;
		
		long maxIndex = 0;
		for(int i = 50; i > 0; i--) {
			long fib = FibonacciUtil.getFibonnaci(i);
			if(fib < m4) {
				maxIndex = i;
				break;
			}
		}
		
		// the problem series starts with number 1,2,3,5.... and hence, the first 
		// two terms of the actual fibonacci series, 0 and 1, are missing.
		// But we need to find the sum of all terms that are actually even
		// the first even term is 2, with fib index of 3. Every third term in the
		// series, will be even.
		long sum = 0;
		for(int i = 3; i <= maxIndex; i = i + 3) {
			long f = FibonacciUtil.getFibonnaci(i);
			sum += f;
		}
		
		System.out.println("Sum=" + sum);
	}

}
