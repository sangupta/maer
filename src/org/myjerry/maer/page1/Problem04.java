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

import org.myjerry.maer.util.PalindromeUtil;

/**
 * Problem 4 on Project Euler, http://projecteuler.net/index.php?section=problems&id=4
 * 
 * @author Sandeep Gupta
 * @since Jan 6, 2011
 */
public class Problem04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long maxProduct = 0;
		String result = null;
		
		for(int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				long product = i * j;
				boolean isPalindrome = PalindromeUtil.checkPalindrome(product);
				if(isPalindrome) {
					if(product > maxProduct) {
						maxProduct = product;
						result = "Numbers are: " + i + ", " + j + " with product: " + product;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
