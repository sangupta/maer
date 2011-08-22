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
package com.sangupta.maer.util;

/**
 * Utility class to work with Roman Numbers.
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 8, 2011
 */
public class RomanNumberUtil {
	
	public static String toRoman(int number) {
		String roman = "";
		do {
			if(number >= 1000) {
				number -= 1000;
				roman += "M";
			} else if(number >= 900) {
				number -= 900;
				roman += "CM";
			} else if(number >= 500) {
				number -= 500;
				roman += "D";
			} else if(number >= 400) {
				number -= 400;
				roman += "CD";
			} else if(number >= 100) {
				number -= 100;
				roman += "C";
			} else if(number >= 90) {
				number -= 90;
				roman += "XC";
			} else if(number >= 50) {
				number -= 50;
				roman += "L";
			} else if(number >= 40) {
				number -= 40;
				roman += "XL";
			} else if(number >= 10) {
				number -= 10;
				roman += "X";
			} else if(number >= 9) {
				number -= 9;
				roman += "IX";
			} else if(number >= 5) {
				number -= 5;
				roman += "V";
			} else if(number >= 4) {
				number -= 4;
				roman += "IV";
			} else if(number >= 1) {
				number -= 1;
				roman += "I";
			}
		} while(number > 0);
		
		return roman;
	}
	
	public static int toDecimal(String number) {
		number = number.toUpperCase();
		
		int decimal = 0;
		char lastChar = 0;
		for(int index = 0; index < number.length(); index++) {
			char c = number.charAt(index);
			switch(c) {
				case 'I':
					decimal += 1;
					break;
					
				case 'V':
					if(lastChar != 'I') {
						decimal += 5;
					} else {
						decimal += 3;
					}
					break;
					
				case 'X':
					if(lastChar != 'I') {
						decimal += 10;
					} else {
						decimal += 98;
					}
					break;
					
				case 'L':
					if(lastChar != 'X') {
						decimal += 50;
					} else {
						decimal += 30;
					}
					break;
					
				case 'C':
					if(lastChar != 'X') {
						decimal += 100;
					} else {
						decimal += 80;
					}
					break;
					
				case 'D':
					if(lastChar != 'C') {
						decimal += 500;
					} else {
						decimal += 300;
					}
					break;
					
				case 'M':
					if(lastChar != 'C') {
						decimal += 1000;
					} else {
						decimal += 800;
					}
					break;
			}
			lastChar = c;
		}
		
		return decimal;
	}
	
	public static String reduce(String number) {
		return toRoman(toDecimal(number));
	}

}
