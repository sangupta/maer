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
package org.myjerry.maer.page2;

import java.util.Arrays;

/**
 * Problem 52 on Project Euler, http://projecteuler.net/index.php?section=problems&id=52
 *
 * @author Sandeep Gupta
 * @since May 2, 2011
 */
public class Problem52 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// for same digits the number has to be in between 1 & 1.66 of the
		// sequence range so that 6x has equal number of digits

		// the number should have atleast 6 digits and must be a multiple of 9
		int x = 99999;
		while(true) {
			x += 9;
			if(sameDigits(x)) {
				break;
			}
		}
		
		System.out.println("Smallest integer x: " + x);
	}

	/**
	 * @param num
	 * @return
	 */
	private static boolean sameDigits(int num) {
		for(int i = 2; i <= 6; i++) {
			if(!sameDigits(num, num * i)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * @param num
	 * @param i
	 * @return
	 */
	private static boolean sameDigits(int i, int j) {
		String n1 = String.valueOf(i);
		String n2 = String.valueOf(j);
		if(n1.length() != n2.length()) {
			return false;
		}
		
		char[] c1 = n1.toCharArray();
		char[] c2 = n2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		for(int index = 0; index < c1.length; index++) {
			if(c1[index] != c2[index]) {
				return false;
			}
		}
		
		return true;
	}

}
