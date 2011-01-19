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

import org.myjerry.maer.util.MathUtil;

/**
 * Problem 34 on Project Euler, http://projecteuler.net/index.php?section=problems&id=34
 *
 * @author Sandeep Gupta
 * @since Jan 11, 2011
 */
public class Problem34 {
	
	private static final long maxDigitFactorial = MathUtil.factorial(9).longValue();
	
	public static void main(String[] args) {
		int num = 3;
		
		long sum = 0;
		do {
			String digits = String.valueOf(num);
			
			long digitSum = 0;
			for(int i = 0; i < digits.length(); i++) {
				int digit = digits.charAt(i) - '0';
				digitSum += MathUtil.factorial(digit).longValue();
			}
			
			if(digitSum == num) {
				System.out.println("Number encountered: " + num);
				sum += num;
			}

			
			if(num > digits.length() * maxDigitFactorial) {
				break;
			}
			
			num++;
		} while(true);
		
		System.out.println("Sum = " + sum);
	}

}
