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
 * Problem 19 on Project Euler, http://projecteuler.net/index.php?section=problems&id=19
 *
 * @author Sandeep Gupta
 * @since Jan 11, 2011
 */
public class Problem19 {
	
	private static final int[] numDays = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public static void main(String[] args) {
		int weekday = 1;
		int numSundays = 0;
		
		for(int year = 1900; year <= 2000; year++) {
			for(int month = 0; month < 12; month++) {
				if(month == 0 && year == 1900) {
					continue;
				}
				
				int monthIndex = month - 1;
				if(monthIndex == -1) {
					monthIndex = 11;
				}
				weekday += numDays[monthIndex];
				
				// is the month FEB
				if(month == 2 && isLeapYear(year)) {
					weekday += 1;
				}
				
				weekday = weekday % 7;
				
				if(year > 1900 && weekday == 0) {
					numSundays++;
				}
			}
		}
		
		System.out.println("Number of sundays falling on 1st of month = " + numSundays);
	}

	/**
	 * @param year
	 * @return
	 */
	private static boolean isLeapYear(int year) {
		if(year % 400 == 0) {
			return true;
		} else if(year % 100 == 0) {
			return false;
		} else if(year % 4 == 0) {
			return true;
		}
		
		return false;
	}
}
