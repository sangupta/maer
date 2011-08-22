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

/**
 * Problem 30 on Project Euler, http://projecteuler.net/index.php?section=problems&id=30
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 11, 2011
 */
public class Problem30 {
	
	private static final long maxDigitPower = (long) Math.pow(9, 5);
	
	public static void main(String[] args) {
		
		int num = 10;
		
		long sum = 0;
		do {
			String digits = String.valueOf(num);
			long digitSum = 0;
			for(int i = 0; i < digits.length(); i++) {
				int digit = digits.charAt(i) - '0';
				digitSum += Math.pow(digit, 5);
			}
			
			if(digitSum == num) {
				System.out.println("Number encountered: " + num);
				sum += num;
			}
			
			if(digits.length() * maxDigitPower < num) {
				break;
			}
			
			num++;
		} while(true);
		
		System.out.println("Sum=" + sum);
		
	}

}
