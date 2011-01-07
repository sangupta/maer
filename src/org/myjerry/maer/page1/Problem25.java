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
 * Problem 25 on Project Euler, http://projecteuler.net/index.php?section=problems&id=25
 * 
 * @author Sandeep Gupta
 * @since Jan 6, 2011
 */
public class Problem25 {
	
	private static final int eulerLimit = 1000;
	
	private static final int maxPrecision = 7;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// the value of F(10)=55, F(11)=89 and both are double digits
		int digits = 2;
		
		long fx = 55, fy = 89, fz = 0;
		int index = 11;
		do {
			++index;

			// compute the next fib value
			fz = fx + fy;
			
			String sfz = String.valueOf(fz), sfy = String.valueOf(fy);
			if(sfz.length() > sfy.length()) {
				digits += (sfz.length() - sfy.length());
			}
			
			if(digits == eulerLimit) {
				break;
			}
			
			// now change the initial values for next iteration
			fx = fy;
			fy = fz;
			
			// see if we are crossing upper bound of X digits
			String sfx = String.valueOf(fx);
			sfy = String.valueOf(fy);
			if(sfx.length() > maxPrecision) {
				int delta = sfx.length() - maxPrecision;
				sfx = sfx.substring(0, maxPrecision);
				sfy = sfy.substring(0, sfy.length() - delta);
				
				fx = Long.valueOf(sfx);
				fy = Long.valueOf(sfy);
			}
		} while(true);
		
		System.out.println("F(" + index + ") yields a 1000 digit number.");
	}

}
