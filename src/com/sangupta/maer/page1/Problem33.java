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
 * Problem 33 on Project Euler, http://projecteuler.net/index.php?section=problems&id=33
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 29-Aug-2011
 */
public class Problem33 {
	
	public static void main(String[] args) {
		float denominator = 1;
		
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {
				for(int k = 1; k <= j; k++) {
					float ki = k * 10 + i;
					float ij = ((float) i) * 10 + j;
					
					if((k * ij) == (ki *j)) {
						denominator *= (ij / ki);
					}
				}
			}
		}
		
		System.out.println("Denominator: " + denominator);
	}

}
