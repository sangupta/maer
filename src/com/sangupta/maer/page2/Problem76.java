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
 * Problem 76 on Project Euler, http://projecteuler.net/index.php?section=problems&id=76
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 09-Sep-2011
 */
public class Problem76 {
	
	private static final int MAX = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ways = new int[MAX + 1];
		ways[0] = 1;

		for(int i = 1; i < MAX; i++) {
			for(int j = i; j < MAX + 1; j++) {
				ways[j] += ways[j - i]; 
			}
		}
		
		System.out.println("Number of ways: " + ways[MAX]);
	}

}
