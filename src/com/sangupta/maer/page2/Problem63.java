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
 * Problem 63 on Project Euler, http://projecteuler.net/index.php?section=problems&id=63
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem63 {
	
	public static void main(String[] args) {
		int count = 0;
		
		int number = 1;
		do {
			int startCount = count;
			
			int power = 1;
			do {
				BigInteger raised = BigInteger.valueOf(number).pow(power); // (long) Math.pow(number, power);
				int numDigits = String.valueOf(raised).length();
				
				if(numDigits == power) {
					System.out.println(raised + " = " + number + " ^ " + power);
					count++;
				}
				
				if(numDigits < power) {
					break;
				}
				
				if(numDigits > power) {
					break;
				}
				
				power++;
			} while(true);
			
			if(startCount == count && count != 0) {
				break;
			}
			
			number++;
		} while(true);
		
		System.out.println("Total numbers: " + count);
	}

}
