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

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem92 {
	
	private static final int MAX = 10000000;
	
	private static final boolean[] numberTested = new boolean[MAX + 1];
	
	private static final boolean[] numberResult = new boolean[MAX + 1];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		numberTested[1] = true;
		numberTested[89] = true;
		numberResult[89] = true;

		for(int num = 2; num < MAX; num++) {
			if(!numberTested[num]) {
				numberResult[num] = checkAndMark(num);
				numberTested[num] = true;
			}
		}
		
		int count = 0;
		for (int i = 0; i < numberResult.length; i++) {
			if(numberResult[i]) {
				count++;
			}
		}
		
		System.out.println("Total numbers: " + count);
	}

	/**
	 * @param num
	 */
	private static boolean checkAndMark(int num) {
		numberTested[num] = true;

		char[] chars = String.valueOf(num).toCharArray();
		
		int sum = 0;
		for (int i = 0; i < chars.length; i++) {
			int digit = chars[i] - '0';
			sum += (digit * digit);
		}
		
		if(sum == 1) {
			return false;
		}
		
		if(sum == 89) {
			numberResult[num] = true;
			return true;
		}
		
		boolean result = checkAndMark(sum);
		numberResult[num] = result;
		return result;
	}

}
