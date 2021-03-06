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
 * Problem 9 on Project Euler, http://projecteuler.net/index.php?section=problems&id=9
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem09 {
	
	private static long desiredMaxSum = 1000;
	
	/**
	 * Function to compute find the pythogorean triplet.
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		long maxSize = desiredMaxSum / 2;
		for(int a = 1; a <= maxSize; a++) {
			for(int b = 1; b <= maxSize; b++) {
				long c = desiredMaxSum - a - b;
				long as = a * a;
				long bs = b * b;
				long cs = c * c;
				if(cs == as + bs) {
					long product = a * b * c;
					System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", product=" + product);
					return;
				}
			}
		}
	}

}
