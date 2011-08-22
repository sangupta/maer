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
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem01 {
	
	private static long maxNumberRange = 1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		long sum3 = MathUtil.sumFirstNDivisibleByM(maxNumberRange, 3, false);
		long sum5 = MathUtil.sumFirstNDivisibleByM(maxNumberRange, 5, false);
		long sum15 = MathUtil.sumFirstNDivisibleByM(maxNumberRange, 15, false);
		sum = sum3 + sum5 - sum15;
		System.out.println("Sum: " + sum );

	}
	
}
