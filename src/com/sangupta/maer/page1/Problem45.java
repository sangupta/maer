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
 * Problem 45 on Project Euler, http://projecteuler.net/index.php?section=problems&id=45
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 11, 2011
 */
public class Problem45 {
	
	public static void main(String[] args) {
		int num = 165;
		long hex = 0;
		do {
			num++;
			
			hex = num * (2 * num - 1);
			if(isPentagonal(hex)) {
				break;
			}
		} while(true);
		
		System.out.println("Solution: " + hex + " at index " + num);
	}

	/**
	 * @param hex
	 * @return
	 */
	private static boolean isPentagonal(long num) {
		double p = (Math.sqrt(1 + 24 * num) + 1) / 6;
		return p == ((int) p);
	}

}
