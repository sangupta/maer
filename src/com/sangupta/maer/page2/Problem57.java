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

import java.math.BigInteger;

/**
 * Problem 57 on Project Euler, http://projecteuler.net/index.php?section=problems&id=57
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 07-Sep-2011
 */
public class Problem57 {
	
	public static void main(String[] args) {
		final BigInteger BIG_TWO = BigInteger.valueOf(2l);
		BigInteger numerator = BigInteger.valueOf(3l);
		BigInteger denominator = BigInteger.valueOf(2l);
		int count = 0;
		
		for(int iterations = 2; iterations < 1000; iterations++) {
			BigInteger temp = numerator.add(denominator.multiply(BIG_TWO));
			denominator = numerator.add(denominator);
			numerator = temp;
			
			if(String.valueOf(numerator).length() > String.valueOf(denominator).length()) {
				count++;
			}
		}
		
		System.out.println("Answer: " + count);
	}

}
