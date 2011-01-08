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
package org.myjerry.maer.util;

import java.math.BigInteger;

/**
 * 
 * @author Sandeep Gupta
 * @since Jan 6, 2011
 */
public class MathUtil {
	
	public static long sumFirstN(long n) {
		return (n * (n + 1)) / 2;
	}
	
	public static long squareOfSumFirstN(long n) {
		long sumN = sumFirstN(n);
		return sumN * sumN;
	}
	
	public static long sumOfSquaresFirstN(long n) {
		long result = (n * (n + 1) * (2* n + 1)) / 6;
		return result;
	}
	
	public static long sumFirstNDivisibleByM(long n, long m) {
		return sumFirstNDivisibleByM(n, m, true);
	}
	
	public static long sumFirstNDivisibleByM(long n, long m, boolean includeN) {
		if(!includeN) {
			n -= 1;
		}
		return m * sumFirstN(n / m);
	}

	public static boolean isPrime(long n) {
		if(n % 2 == 0) {
			return false;
		}
		
		long num = (long) Math.sqrt(n);
		for(int i = 3; i < num; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
	
	public static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		
		return gcd(b, a % b);
	}

	public static BigInteger raiseToPowerInPrecision(int i, long power, int precision) {
		BigInteger number = BigInteger.valueOf(i);
		BigInteger product = BigInteger.valueOf(1l); 
		for(long l = 0; l < power; l++) {
			product = product.multiply(number);
			
			product = trimToPrecision(product, precision);
		}
		
		return product;
	}
	
	public static BigInteger trimToPrecision(BigInteger number, int precision) {
		String n = number.toString();
		if(n.length() > precision) {
			n = n.substring(n.length() - precision);
		}
		return new BigInteger(n);
	}

}
