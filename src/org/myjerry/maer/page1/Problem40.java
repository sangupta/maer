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

/**
 * Problem 40 on Project Euler,
 * http://projecteuler.net/index.php?section=problems&id=40
 * 
 * @author Sandeep Gupta
 * @since Jan 18, 2011
 */
public class Problem40 {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int d1 = getDigit(1);
		int d2 = getDigit(10);
		int d3 = getDigit(100);
		int d4 = getDigit(1000);
		int d5 = getDigit(10000);
		int d6 = getDigit(100000);
		int d7 = getDigit(1000000);

		long m = d1 * d2 * d3 * d4 * d5 * d6 * d7;
		System.out.println("Value: " + m);
	}

	/**
	 * @param i
	 * @return
	 */
	private static int getDigit(int i) {
		int num = 1;
		do {
			String s = String.valueOf(num);
			if(i == s.length()) {
				return num;
			}
			
			if(i < s.length()) {
				return Integer.parseInt(s.substring(i - 1, i));
			}
			
			i -= s.length();
			num++;
		} while(true);
	}

}
