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
package com.sangupta.maer.page3;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem112 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// given that 90% numbers are bouncy at 21780
		int number = 21780;
		int bouncy = (int) (number * 0.9);
		double ratio = 0.9;
		do {
			number++;
			if(isBouncy(number)) {
				bouncy++;
			}
			
			ratio = (double) bouncy / (double) number;
		} while(ratio < 0.99);
		
		System.out.println("Number to break even at 0.99 ratio: " + number);
	}

	/**
	 * @param n
	 * @return
	 */
	private static boolean isBouncy(int n) {
		char[] chars = String.valueOf(n).toCharArray();
		int max = chars.length - 1;
		
		boolean increasing = false, decreasing = false;
		for(int index = 0; index < max; index++) {
			if(!increasing && chars[index + 1] > chars[index]) {
				increasing = true;
			}
			
			if(!decreasing && chars[index + 1] < chars[index]) {
				decreasing = true;
			}
			
			if(increasing && decreasing) {
				return true;
			}
		}
		
		return false;
	}

}
