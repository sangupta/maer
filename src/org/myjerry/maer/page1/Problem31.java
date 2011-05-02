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
 * Problem 31 on Project Euler, http://projecteuler.net/index.php?section=problems&id=31
 *
 * @author Sandeep Gupta
 * @since May 2, 2011
 */
public class Problem31 {
	
	private static final int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
	
	private static final int eulerSum = 200;

	/**
	 * Additional ONE in lines 41, 46 and 51 are due to zero-index in Java.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int ways[] = new int[eulerSum + 2];
		ways[0] = 0;
		ways[1] = 1;
		
		for(int coin : coins) {
			for(int i = coin; i <= eulerSum + 1; i++) {
				ways[i] += ways[i - coin];
			}
		}
		
		System.out.println("Total number of ways: " + ways[eulerSum + 1]);
	}

}
