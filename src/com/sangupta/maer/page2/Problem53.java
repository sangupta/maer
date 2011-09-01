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
 * Problem 53 on Project Euler, http://projecteuler.net/index.php?section=problems&id=53
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem53 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int combinations = 0;
		for(int n = 1; n <= 100; n++) {
			for(int r = 1; r <= n; r++) {
				long result = ncr(n, r);
				
				// per pascal's triangle
				// if 23c10 is greater than numbers till 23c(23-10) will be greater
				if(result > 1000000) {
					combinations += ((n - r) - r + 1);
					break;
				}
			}
		}
		
		System.out.println("Total combinations: " + combinations);
	}

	/**
	 * @param n
	 * @param r
	 * @return
	 */
	private static long ncr(int n, int r) {
		long result = 1;
		for (int i = 1; i <= r; ++i) {
			result = (result * ((n + 1) - i)) / i;
		}

		return result;
	}

}
