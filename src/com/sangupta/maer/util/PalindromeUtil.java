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

import java.math.BigInteger;
import java.util.List;

/**
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class PalindromeUtil {
	
	public static boolean checkPalindrome(long number) {
		String num = String.valueOf(number);
		return checkPalindrome(num);
	}
	
	public static long reverseSum(long number) {
		String num = String.valueOf(number);
		String reverse = new StringBuilder(num).reverse().toString();
		long rev = Long.parseLong(reverse);
		return number + rev;
	}

	public static boolean checkPalindrome(String string) {
		if(string == null) {
			return false;
		}
		
		String reverse = new StringBuilder(string).reverse().toString();
		if(string.equals(reverse)) {
			return true;
		}
		
		return false;
	}

	/**
	 * @param currentSum
	 * @return
	 */
	public static boolean checkPalindrome(BigInteger currentSum) {
		if(currentSum == null) {
			return false;
		}
		
		return checkPalindrome(currentSum.toString());
	}

	/**
	 * @param currentSum
	 * @return
	 */
	public static BigInteger reverse(BigInteger currentSum) {
		String num = currentSum.toString();
		String rev = new StringBuilder(num).reverse().toString();
		BigInteger revNum = new BigInteger(rev);
		return revNum;
	}
	
	public static int getPalindromes(int maximum) {
		int result;
		final int[] A050250 = { 0, 9, 18, 108, 198, 1098, 1998, 10998, 19998, 109998, 199998, 1099998,
		           1999998, 10999998, 19999998, 109999998, 199999998, 1099999998, 1999999998 };
		
		final int[] pow10 = { 1,10,100,1000,10000,100000, 1000000,10000000,10000000,1000000000 };
		
		int n, m, k, j;
		int[] d = new int[19];
		
		m = 0; n = maximum;
		while(n > 0) {
			d[m] = n % 10;
			n = n / 10;
			m++;
		}
		
		n = m - 1;
		result = A050250[n];
		
		m = n; j = 0; k = n / 2;
		d[n] = d[n] - 1;
		
		while((m -j) >= 2) {
			result = result + d[m] * pow10[k];
			m--;
			j++;
			k--;
		}
		
		result += d[m];
		if(d[j] > d[m]) {
			result++;
		}
		
		return result;
	}
}
